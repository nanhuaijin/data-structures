package com.breeze.structure.huffman;

import java.util.*;

/**
 * @author : breeze
 * @date : 2020/6/4
 * @description : 赫夫曼编码
 *
 *  1.赫夫曼编码：电讯通信中的经典应用之一，广泛应用于数据文件压缩，压缩率在20%~90%之间，是无损处理方案
 *      1）赫夫曼码是可变字长编码（VLC）的一种，Huffman于1952年提出一种编码方法，称为最佳编码
 *      2）字符编码都不能是其他字符编码的前缀，符合此要求的编码就是前缀编码，即不能匹配到重复的编码
 *
 *      3）赫夫曼编码演示：i like like like java do you like a java
 *          其中字符出现次数：d:1 y:1 j:2 v:2 o:2 l:4 k:4 e:4 i:5 a:5 空格:9
 *          将这些字符出现的次数构成数组，然后构成赫夫曼树
 *          根据赫夫曼树给各个字符规定编码(前缀编码)，向左的路径为0，向右的编码是1，编码如下
 *          e:1111 o:1000 u:10010 d:100110 y:100111 i:101 a:110 k:1110
 *          j:0000 v:0001 l:001 空格:01
 *
 *      4）注意：赫夫曼树根据排序方法不同，也可能不太一样，比如：有三个一样的数字3，
 *          它们有6种排序方式，但是最终的编码长度都是一样的
 */
public class HuffmanCode {
    public static void main(String[] args) {

        //创建字符串
        String content = "i like like like java do you like a java";
        byte[] bytes = huffmanZip(content);
    }

    /**
     * 数据压缩 - 将字符串转换为赫夫曼编码字符数组
     * @param content
     * @return
     */
    private static byte[] huffmanZip(String content) {
        //获取字符串对应的字节数组
        byte[] contentBytes = content.getBytes();

        //将字符数组转换为Node集合
        List<Node> nodes = getNodes(contentBytes);

        //生成赫夫曼树
        Node rootNode = createHuffmanTree(nodes);
        preOrder(rootNode);

        //生成赫夫曼编码
        getHumanCode(rootNode);
        System.out.println("赫夫曼编码表是："+humanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes, humanCodes);
        System.out.println("采用赫夫曼编码压缩后的编码数组："+ Arrays.toString(huffmanCodeBytes));

        return huffmanCodeBytes;
    }

    //存储赫夫曼编码
    static Map<Byte, String> humanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 涉及二进制的原码、反码、补码
     * @param bytes 这是原始字符串对应的byte[]
     * @param huffmanCodes 生成赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     *
     * 10101000（补码）=> byte [10101000 => 10101000 - 1 => 10100111（反码）=> 11011000 => -88]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用HuffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder builder = new StringBuilder();
        //遍历byte数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("赫夫曼编码是：" + stringBuilder.toString());

        //将字符串变为byte[] 8位 1Byte
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];

        int index = 0;//记录是第几个byte
        //步长为8  每8位对应一个byte
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }

            //将strByte 转成一个byte
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanCodeBytes;
    }

    /**
     * 重载方法
     * @param root
     * @return
     */
    private static Map<Byte, String> getHumanCode(Node root) {
        if (root == null) {
            return null;
        }
        //处理root左子树
        getHumanCode(root.left, "0", stringBuilder);
        //处理root的右子树
        getHumanCode(root.right, "1", stringBuilder);
        return humanCodes;
    }

    /**
     * 得到传入的node节点的所有叶子节点的赫夫曼编码，并放入map集合
     * @param node 传入节点
     * @param code 路径：左子节点是0 右子节点是1
     * @param stringBuilder 用于拼接
     * @return
     */
    private static void getHumanCode(Node node, String code, StringBuilder stringBuilder) {

        StringBuilder builder = new StringBuilder(stringBuilder);
        //将code加入到builder
        builder.append(code);

        if (node != null) {
            if (node.data == null) {//无数据的节点
                //向左递归
                getHumanCode(node.left, "0", builder);
                //向右递归
                getHumanCode(node.right, "1", builder);
            } else {
                //说明是叶子节点
                //表示有数据的节点
                humanCodes.put(node.data, builder.toString());
            }
        }
    }

    /**
     * 获取byte数组对应的Node集合
     *
     * @param contentBytes 接收字节数组
     * @return 返回node list
     */
    private static List<Node> getNodes(byte[] contentBytes) {
        //1.创建ArrayList
        List<Node> nodes = new ArrayList<>();

        //2.统计每一个byte出现的次数 ---> map
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : contentBytes) {
            Integer count = counts.get(b);
            //第一次
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, ++count);
            }
        }

        //3.把每个键值对转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    /**
     * 生成赫夫曼树
     *
     * @param nodes Node节点集合
     * @return 赫夫曼树的根节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //1.先排序，从小到大
            Collections.sort(nodes);
            //2.取出第一棵最小的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //3.创建一棵新的二叉树
            Node parent = new Node(null, leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //4.将处理过的两棵二叉树从nodes移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //5.将新的二叉树加入到nodes
            nodes.add(parent);
        }

        //返回nodes里面最后的节点，就是赫夫曼树的根节点
        return nodes.get(0);
    }

    /**
     * 前序遍历
     *
     * @param root 赫夫曼树根节点
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历！");
        }
    }
}
