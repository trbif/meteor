package cn.meteor.cloud.train.word2vec.util;

import java.util.*;

/**
 * Created by fangy on 13-12-17.
 * 哈夫曼树
 */
public class HuffmanTree {

//    private TreeSet<HuffmanNode> tree = new TreeSet<HuffmanNode>();

    public static void make(Collection<? extends HuffmanNode> nodes){

        TreeSet<HuffmanNode> tree = new TreeSet<HuffmanNode>(nodes);

        while (tree.size() > 1){
            HuffmanNode left = tree.pollFirst();//哈夫曼树的向量独立于neuronMap中的节点向量
            HuffmanNode right = tree.pollFirst();
            HuffmanNode parent = left.merge(right);
            tree.add(parent);
        }

    }

    public static List<HuffmanNode> getPath(HuffmanNode leafNode){

        List<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
        for (HuffmanNode hn = leafNode ; hn != null; hn = hn.getParent()){
            nodes.add(hn);//包括空节点在内的哈夫曼路径
        }
        Collections.reverse(nodes);

        return nodes;
    }

}
