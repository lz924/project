package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Type {
    private Integer type_no;
    private String type_name;
    private List<Bk> bks;

    public Type() {
        bks = new ArrayList<>();
    }

    public Type(String type_name) {
        this.type_name = type_name;
        bks = new ArrayList<>();
    }

    public List<Bk> getBks() {
        return bks;
    }

    public void setBks(List<Bk> bks) {
        this.bks = bks;
    }

    public Integer getType_no() {
        return type_no;
    }

    public void setType_no(Integer type_no) {
        this.type_no = type_no;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
