package com.breeze.linkedlist.joseph;

import lombok.Data;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 创建一个boy类，表示一个节点
 */
@Data
public class Boy {
    private int no; //编号
    private Boy next; //指向写一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }
}
