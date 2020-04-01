package com.breeze.structure.hash;

/**
 * @author breeze
 * @date 2020/3/31
 *
 *  哈希表：  散列表
 *      1.是根据关键码值(key value)而直接进行访问的数据结构
 *  也就是说，它是通过把关键码值映射到表中一个位置来访问记录，以
 *  加快查找速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表
 */
public class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示数组大小

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     * @param emp
     */
    public void add(Emp emp) {

        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinedListNO = hashFun(emp.id);

        //将emp添加到对应的链表中
        empLinkedListArray[empLinedListNO].add(emp);
    }

    /**
     * 遍历hash表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     */
    public void findEmpById(int id) {

        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinedListNO = hashFun(id);

        Emp emp = empLinkedListArray[empLinedListNO].findEmpById(id);

        if (emp != null) {
            System.out.printf("在第%d条链表中找到 雇员id = %d\tname = %s\t", empLinedListNO, id, emp.name);
        } else {
            System.out.println("没有找到该雇员！");
        }
    }

    //编写一个散列函数，使用一个简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

}
