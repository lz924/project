package com.etc.studentsystem.entity;

public class Data {
    private String name;
    private  int pwd;

    public Data(String name, int pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Data() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

}
