package cn.meteor.centauri.alpha.train;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 14:18
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 14:18
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class WordSegmenterTest {
    @Test
    public void testWordSegmenter(){
        List<Word> initWords = WordSegmenter.seg("这里用作初始化word分词器");
        List<Word> words = WordSegmenter.seg("我用过ik，用过结巴，也用过fudannlp，但从来没用过word");
        System.out.println(initWords.toString().substring(1,initWords.toString().length()-1).replaceAll(", "," "));
        System.out.println(words.toString().substring(1,words.toString().length()-1).replaceAll(", "," "));
    }
}
