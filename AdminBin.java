package com.example.projectlogin1;

public class AdminBin {

    private String bid;

    public AdminBin(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return bid;
    }
}
