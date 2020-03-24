package com.breeze.structure.linkedlist.single;

/**
 * @author breeze
 * @date 2020/2/25
 * 定义HeroNode， 每个HeroNode对象就是一个节点
 */
public class HeroNode {
    public int no; //排行的名次
    public String name; //姓名
    public String nickname; //昵称
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
