package com.example.myapplication;

import java.io.Serializable;

public class AddressVO implements Serializable {
    private String gu;
    private int count;

    public AddressVO(String gu, int count) {
        this.gu = gu;
        this.count = count;
    }

    public String getGu() {
        return gu;
    }

    public int getCount() {
        return count;
    }
}
