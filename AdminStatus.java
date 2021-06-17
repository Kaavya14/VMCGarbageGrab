package com.example.projectlogin1;

public class AdminStatus {
    private String ststus;

    public AdminStatus(String ststus) {
        this.ststus = ststus;
    }

    public String getStstus() {
        return ststus;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }

    @Override
    public String toString(){
        return ststus;
    }
}
