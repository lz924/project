package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Repertory {
    private Integer repertory_no;
    private String repertory_name;
    private List<Bk> bkList;

    public Repertory() {
        bkList = new ArrayList<>();
    }

    public Repertory(String repertory_name) {
        this.repertory_name = repertory_name;
        bkList = new ArrayList<>();
    }

    public List<Bk> getBkList() {
        return bkList;
    }

    public void setBkList(List<Bk> bkList) {
        this.bkList = bkList;
    }

    public Integer getRepertory_no() {
        return repertory_no;
    }

    public void setRepertory_no(Integer repertory_no) {
        this.repertory_no = repertory_no;
    }

    public String getRepertory_name() {
        return repertory_name;
    }

    public void setRepertory_name(String repertory_name) {
        this.repertory_name = repertory_name;
    }
}
