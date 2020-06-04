package com.breeze.structure.huffman;

/**
 * @author : breeze
 * @date : 2020/6/1
 * @description : 节点类
 *
 * 为了让Node对象支持Collections集合排序
 * 需要让Node实现Comparable接口
 */
public class Node implements Comparable<Node>{
    Byte data; //字符
    int value; //节点权值
    Node left; //指向左子节点
    Node right; //指向优子节点

    public Node(int value) {
        this.value = value;
    }

    public Node(Byte data, int value) {
        this.value = value;
        this.data = data;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }
}
