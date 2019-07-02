package com.plugin.test;
//tools -->codehelper-->提供一个调用指定对象的所有set方法的功能 / 根据pojo生成dao与SQL的工程
public class Test001 {
    public static void main(String[] args) {
        Test001 test001 = new Test001();
    }
    private Integer id;
    private String name;
    private String age;
    private String addr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
