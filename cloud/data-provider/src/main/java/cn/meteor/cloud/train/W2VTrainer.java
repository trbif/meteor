package cn.meteor.cloud.train;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.returnmsg.ReturnMsg;
import cn.meteor.cloud.train.word2vec.util.Tokenizer;
import cn.meteor.cloud.train.word2vec.vec.Word2Vec;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 13:51
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 13:51
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class W2VTrainer implements Callable<Object> {

    private Word2Vec.Method trainMethod;
    private Word2Vec word2Vec = null;
    private String modelPath;
    private W2VParams params;

    private W2VTrainer(){}
    public W2VTrainer(List<NewsBean> beanList,String modelPath,W2VParams params){
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
            return new ReturnMsg.Builder().setErrorMsg("success").build();
        }
        return new ReturnMsg.Builder().setErrorMsg("null").build();
    }

    private void fillCorpus(List<NewsBean> beanList){
        word2Vec = new Word2Vec.Factory()
                .setMethod(trainMethod)
                .setVectorSize(params.getVectorDim())
                .build();
        for(NewsBean bean:beanList){
            List<Word> words = WordSegmenter.seg(bean.getNewsTitle());
            word2Vec.readTokens(new Tokenizer(
                    words
                    .toString()
                            .substring(1,words.toString().length()-1)
                            .replaceAll(", "," "),
                    " "));
        }
    }
}
