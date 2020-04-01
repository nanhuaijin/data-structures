package com.breeze.structure.hash;

/**
 * @author breeze
 * @date 2020/3/31
 *
 *  表示雇员
 */
public class Emp {

    public Integer id; //id
    public String name; //姓名
    public Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
