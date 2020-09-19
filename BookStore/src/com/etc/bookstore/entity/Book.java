package com.etc.bookstore.entity;

public class Book {
    private String bno;
    private String bname;
    private String author;
    private double price;
    private String press;

    public Book() {
        super();
    }

    public Book(String bno, String bname, String author, double price, String press) {
        this.bno = bno;
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.press = press;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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
        return "Book{" +
                "bno='" + bno + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                '}';
    }
}
