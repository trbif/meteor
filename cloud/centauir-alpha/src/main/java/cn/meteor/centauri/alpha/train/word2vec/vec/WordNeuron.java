package cn.meteor.centauri.alpha.train.word2vec.vec;

import cn.meteor.centauri.alpha.train.word2vec.util.HuffmanNode;
import cn.meteor.centauri.alpha.train.word2vec.util.HuffmanTree;

import java.util.List;
import java.util.Random;

/**
 * Created by fangy on 13-12-17.
 * 词神经元
 */
public class WordNeuron extends HuffmanNeuron {

    private String name;
    private List<HuffmanNode> pathNeurons;

    public WordNeuron(String name, int freq, int vectorSize) {
        super(freq, vectorSize);
        this.name = name;
        Random random = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (random.nextDouble() - 0.5) / vectorSize;//词元向量随机生成
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HuffmanNode> getPathNeurons() {
        if (pathNeurons != null){
            return pathNeurons;
        }
        pathNeurons = HuffmanTree.getPath(this);//每个WordNeuron已经被加进了哈夫曼树

        return pathNeurons;
    }
}
