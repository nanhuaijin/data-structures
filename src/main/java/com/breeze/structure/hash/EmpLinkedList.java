package com.breeze.structure.hash;

/**
 * @author breeze
 * @date 2020/3/31
 *
 *  表示链表
 */
public class EmpLinkedList {

    //头指针, 指向第一个雇员,因此我们这个链表的head是有效的
    private Emp head; //默认是空

    /**
     * 添加雇员
     *  1.假定当添加雇员时候id是自增的，即id的分配总是从小到大
     *  2.雇员总是加载链表的最后
     * @param emp
     */
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }

        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {//说明链表到最后了
                break;
            }
            curEmp = curEmp.next; //后移
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    /**
     * 遍历链表
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空！");
            return;
        }
        System.out.print("第" + (no + 1) + "条链表信息为：");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {//说明已经是最后节点
                break;
            }
            curEmp = curEmp.next; // 后移
        }
        System.out.println();
    }

    /**
     * 根据id查找雇员
     * 如果找到返回emp，找不到返回null
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {

        //判断是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                //找到
                break;
            }
            //退出
            if (curEmp.next == null) {
                //说明遍历当前链表没有找到雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }
}
