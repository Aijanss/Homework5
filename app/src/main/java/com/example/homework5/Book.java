package com.example.homework5;

import java.util.Date;

public class Book {
    private int image;
    private Date data;
    private String dataStr = null;

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    public Book(Date data, int image) {

        this.image = image;
        this.data = data;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}