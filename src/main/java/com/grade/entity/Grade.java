package com.grade.entity;

public class Grade {
    private Short gid;

    private String gname;

    public Short getGid() {
        return gid;
    }

    public void setGid(Short gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }
}