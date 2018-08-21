package cn.meteor.centauri.alpha.train;

import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.centauri.alpha.train.word2vec.util.Tokenizer;
import cn.meteor.centauri.alpha.train.word2vec.vec.VectorModel;
import cn.meteor.centauri.alpha.train.word2vec.vec.Word2Vec;
import cn.meteor.centauri.alpha.workbox.annotation.TimeCosts;
import cn.meteor.spacecraft.bean.NewsBean;
import org.apache.ibatis.io.Resources;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * @ProjectName: data-provider
 * @Description: 训练执行器
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 13:51
 * @Version: 1.0.0
 */
public class W2VTrainer implements Callable<Object> {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private Word2Vec.Method trainMethod;
    private Word2Vec word2Vec = null;
    private String modelPath;
    private W2VParams params;

    private W2VTrainer(){}
    public W2VTrainer(List<NewsBean> beanList, String modelPath, W2VParams params){
        this(beanList,modelPath,params,Word2Vec.Method.CBow);
    }
    public W2VTrainer(List<NewsBean> beanList,String modelPath,W2VParams params, Word2Vec.Method trainMethod){
        this.modelPath = modelPath;
        this.trainMethod = trainMethod;
        this.params = params;
        fillCorpus(beanList);
    }

    @Override
    public Object call() throws Exception {
        if(word2Vec!=null){
            word2Vec.training();
            word2Vec.saveModel(new File(modelPath));
            return new ReturnMsg.Builder().
                    setErrorMsg("success").
                    setAccuracy(getAccuracy(modelPath)).
                    setModelName(modelPath).
                    build();
        }
        return new ReturnMsg.Builder().setErrorMsg("null").build();
    }

    @TimeCosts(name="W2VTrainer填充语料")
    private void fillCorpus(List<NewsBean> beanList){
        LOG.info("开始填充语料");
        long start = System.currentTimeMillis();
        word2Vec = new Word2Vec.Factory()
                .setMethod(trainMethod)
                .setVectorSize(params.getVectorDim())
                .build();
        for(int i=0;i<100;i++){
            for(NewsBean bean:beanList){
                List<Word> words = WordSegmenter.seg(bean.getNewsTitle()+bean.getNewsCategory()+bean.getNewsOriginalSummary()+bean.getNewsCategory());
                word2Vec.readTokens(new Tokenizer(
                        words
                                .toString()
                                .substring(1,words.toString().length()-1)
                                .replaceAll(", "," "),
                        " "));
            }
        }
        long end = System.currentTimeMillis();
        LOG.info("结束填充语料，耗时：{}ms",end-start);
    }

    @TimeCosts(name="W2VProvider计算准确度")
    private double getAccuracy(String modelPath){
        LOG.info("开始计算准确度");
        long start = System.currentTimeMillis();
        VectorModel model = VectorModel.loadFromFile(modelPath);
        String resource = "train/corpus.check";
        BufferedReader reader = null;
        int bingo = 0;
        int total = 1;
        try {
            reader = new BufferedReader(Resources.getResourceAsReader(resource));
            String str = null;
            while((str=reader.readLine())!=null){
                String[] items = str.trim().split("&&&&&");
                if(items.length!=2)
                    continue;
                total++;
                List<Word> words = WordSegmenter.seg(items[0]);
                float[] contentVectorPlus = new float[params.getVectorDim()];
                for(Word word:words){
                    float[] wordVector = model.getWordVector(word.getText());
                    if(wordVector==null) continue;
                    vectorPlus(contentVectorPlus,wordVector);
                }
                List<String> categories = new ArrayList<>();
                categories.add("IT");
                Map<Float,String> similarityTreeMap = new TreeMap<Float,String>(new Comparator<Float>() {
                    @Override
                    public int compare(Float o1, Float o2) {
                        return o2.compareTo(o1);//desc
                    }
                });
                for(String category:categories){
                    float[] predictCategoryVector = model.getWordVector(category);
                    if(predictCategoryVector==null) continue;
                    toOne(predictCategoryVector);
                    float similarity = similarity(predictCategoryVector,contentVectorPlus);
                    similarityTreeMap.put(similarity,category);
                }
                int topK = 5;
                for(Map.Entry entry:similarityTreeMap.entrySet()){
                    if(topK==0) break;
                    if(entry.getValue().equals(items[1])) bingo++;
                    topK--;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        LOG.info("结束计算准确度，耗时：{}ms",end-start);
        LOG.info("准确度相关数字: bingo({}),total({})",bingo,total);
        return bingo/(double)total;
    }

    private void vectorPlus(float[] vector1,float[] vector2){
        for(int i=0;i<vector1.length;i++){
            vector1[i] += vector2[i];
        }
        toOne(vector1);
    }

    //精度要求不高
    private void toOne(float[] vector){
        float div = 0.0f;
        for(int i=0;i<vector.length;i++){
            div += vector[i]*vector[i];
        }
        for(int i=0;i<vector.length;i++){
            vector[i] /= div;
        }
    }

    private float similarity(float[] vector1,float[] vector2){
        float dividend = 0.0f;
        double helper1 = 0.0d;
        double helper2 = 0.0d;
        for(int i=0;i<vector1.length;i++){
            dividend += vector1[i]*vector2[i];
            helper1 += vector1[i]*vector1[i];
            helper2 += vector2[i]*vector2[i];
        }
        return dividend/(float) (Math.sqrt(helper1)*Math.sqrt(helper2));
    }
}
