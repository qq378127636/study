package com.demo;

import java.io.Serializable;

public class Demo implements Serializable{

    private String name;

    private String address;

    private String[] date;

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
            this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        System.out.println("a");
    }
}
