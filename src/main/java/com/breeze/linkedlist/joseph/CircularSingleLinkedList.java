package com.breeze.linkedlist.joseph;

/**
 * @author breeze
 * @date 2020/2/26
 *
 * 单向环形链表
 */
public class CircularSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = null;

    /**
     * 根据用户的输入，计算小孩出圈的顺序
     *      1.需要创建一个辅助指针 helper，事先应该指向环形链表的最后节点
     *      2.小孩报数前，先让first和helper移动 k-1 次
     *      3.当小孩报数时，让first和helper指针同时移动 m-1 次
     *      4.这时就可以将first指向的小孩节点出圈
     *      5.first = first.next
     *        helper.next = first
     *      6.原来的first指向的节点就没有任何引用，就会被垃圾回收器回收
     * @param start  表示第一个小孩开始数数
     * @param count 表示数几下
     * @param num 表示最初由几个小孩在圈中
     */
    public void countBoy(int start, int count, int num) {
        //先对数据进行校验
        if (first == null || start < 1 || start > num) {
            System.out.println("参数输入有误，请重新输入！");
            return;
        }

        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //辅助指针 helper 事先应该指向环形链表的最后这个节点
        while (true) {
            //说明helper指向最后一个节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper移动 k-1 次
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper指针同时移动 m-1 次，然后出圈
        //这是一个循环操作，直到圈中只有一个节点
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }

            //让first和helper同时移动 count-1次
            for (int i = 0; i < count - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点就是要出圈的节点
            System.out.printf("小孩 %d 出圈", first.getNo());
            System.out.println();
            //将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号 %d\n", helper.getNo());
    }

    /**
     * 添加小孩节点，构建成一个环形链表
     * @param num 节点的个数
     */
    public void addBoy(int num) {
        //num 做一个数据校验
        if (num < 1) {
            System.out.println("至少要有一个小孩才可以进行！！");
            return;
        }

        //辅助指针，帮助构建环形链表
        Boy curBoy = null;

        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= num; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                //构成环状
                first.setNext(first);
                //让curBoy指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                //将curBoy后移
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的链表
     */
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩！");
        }

        //因为first不能动，因此我们需要辅助指针完成遍历
        Boy curBoy = first;

        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            //说明已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            //将curBoy后移
            curBoy = curBoy.getNext();
        }
    }
}
