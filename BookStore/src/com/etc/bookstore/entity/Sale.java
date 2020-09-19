package com.etc.bookstore.entity;

import java.util.Date;

public class Sale {
    private Integer sale_no;
    private Orde order_no;
    private Seller sell_no;
    private String sale_name;
    private Date sale_date;

    public Sale() {
    }

    public Sale(Orde order_no, Seller sell_no, String sale_name, Date sale_date) {
        this.order_no = order_no;
        this.sell_no = sell_no;
        this.sale_name = sale_name;
        this.sale_date = sale_date;
        this.order_no.getSales().add(this);
        this.sell_no.getSales().add(this);
    }

    public Integer getSale_no() {
        return sale_no;
    }

    public void setSale_no(Integer sale_no) {
        this.sale_no = sale_no;
    }

    public Orde getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Orde order_no) {
        this.order_no = order_no;
    }

    public Seller getSell_no() {
        return sell_no;
    }

    public void setSell_no(Seller sell_no) {
        this.sell_no = sell_no;
    }

    public String getSale_name() {
        return sale_name;
    }

    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }
}
