package com.example.projectlogin1;

public class Admin_Driver {
    private String id;

    public Admin_Driver(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
