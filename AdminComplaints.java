package com.example.projectlogin1;

public class AdminComplaints {

    private String cid;

    public AdminComplaints(String cid) {
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString(){
        return cid;
    }
}
