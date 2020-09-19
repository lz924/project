package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Orde {
    private Integer order_no;
    private Users user_no;
    private Bk book_no ;
    private String order_name;
    private String order_comment;
    private List<Sale> sales;

    public Orde() {
        sales = new ArrayList<>();
    }

    public Orde(Users user_no, Bk book_no, String order_name, String order_comment) {
        this.user_no = user_no;
        this.book_no = book_no;
        this.order_name = order_name;
        this.order_comment = order_comment;
        sales = new ArrayList<>();
    }

    public Orde(String order_name) {
        this.order_name = order_name;
        sales = new ArrayList<>();
    }

    public List<Sale> getSales() {
        return sales;
    }

    public Orde(Users user_no, Bk book_no, String order_name, String order_comment, List<Sale> sales) {
        this.user_no = user_no;
        this.book_no = book_no;
        this.order_name = order_name;
        this.order_comment = order_comment;
        this.sales = sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public Users getUser_no() {
        return user_no;
    }

    public void setUser_no(Users user_no) {
        this.user_no = user_no;
    }

    public Bk getBook_no() {
        return book_no;
    }

    public void setBook_no(Bk book_no) {
        this.book_no = book_no;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_comment() {
        return order_comment;
    }

    public void setOrder_comment(String order_comment) {
        this.order_comment = order_comment;
    }

    @Override
    public String toString() {
        return "Orde{" +
                "order_no=" + order_no +
                ", user_no=" + user_no +
                ", book_no=" + book_no +
                ", order_name='" + order_name + '\'' +
                ", order_comment='" + order_comment + '\'' +
                ", sales=" + sales +
                '}';
    }
}
