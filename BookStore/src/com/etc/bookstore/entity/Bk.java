package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Bk {
    private Integer book_no;
    private Repertory repertory_no;
    private Type type_no ;
    private String book_name;
    private String author;
    private double price;
    private String press;
    private List<Orde> ordes;

    public Bk() {
        ordes = new ArrayList<>();
    }

    public Bk(String book_name) {
        this.book_name = book_name;
        ordes = new ArrayList<>();
    }

    public Bk(Repertory repertory_no, Type type_no, String book_name, String author, double price, String press) {
        this.repertory_no = repertory_no;
        this.type_no = type_no;
        this.book_name = book_name;
        this.author = author;
        this.price = price;
        this.press = press;
        ordes = new ArrayList<>();
        this.repertory_no.getBkList().add(this);
        this.type_no.getBks().add(this);
    }

    public Bk(String book_name,String author, double price, String press) {
        this.book_name = book_name;
        this.author = author;
        this.price = price;
        this.press = press;
        ordes = new ArrayList<>();
    }


    public List<Orde> getOrdes() {
        return ordes;
    }

    public void setOrdes(List<Orde> ordes) {
        this.ordes = ordes;
    }

    public Integer getBook_no() {
        return book_no;
    }

    public void setBook_no(Integer book_no) {
        this.book_no = book_no;
    }

    public Repertory getRepertory_no() {
        return repertory_no;
    }

    public void setRepertory_no(Repertory repertory_no) {
        this.repertory_no = repertory_no;
    }

    public Type getType_no() {
        return type_no;
    }

    public void setType_no(Type type_no) {
        this.type_no = type_no;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "Bk{" +
                ", type_no=" + type_no +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                '}';
    }
}
