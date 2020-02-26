package com.breeze.linkedlist.doublee;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 定义HeroNode，每个HeroNode对象就是一个节点
 *
 * 注意：当toString同时打印pre和next的时候会报java.lang.StackOverflowError
 */
public class Node {
    public int no;
    public String name;
    public String nickname;
    public Node pre; //指向上一个节点，默认为null
    public Node next; //指向下一个节点，默认为null

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
