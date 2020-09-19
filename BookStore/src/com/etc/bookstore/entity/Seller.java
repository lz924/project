package com.etc.bookstore.entity;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private Integer sell_no;
    private String sell_name;
    private String sell_phone;
    private String sell_address;
    private List<Sale> sales;

    public Seller() {
        sales = new ArrayList<>();
    }

    public Seller(String sell_name, String sell_phone, String sell_address) {
        this.sell_name = sell_name;
        this.sell_phone = sell_phone;
        this.sell_address = sell_address;
        sales = new ArrayList<>();
    }

    public Seller(String sell_name) {
        this.sell_name = sell_name;
        sales = new ArrayList<>();
    }

    public Integer getSell_no() {
        return sell_no;
    }

    public void setSell_no(Integer sell_no) {
        this.sell_no = sell_no;
    }

    public String getSell_name() {
        return sell_name;
    }

    public void setSell_name(String sell_name) {
        this.sell_name = sell_name;
    }

    public String getSell_phone() {
        return sell_phone;
    }

    public void setSell_phone(String sell_phone) {
        this.sell_phone = sell_phone;
    }

    public String getSell_address() {
        return sell_address;
    }

    public void setSell_address(String sell_address) {
        this.sell_address = sell_address;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
