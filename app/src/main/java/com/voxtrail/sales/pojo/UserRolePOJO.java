package com.voxtrail.sales.pojo;

import com.google.gson.annotations.SerializedName;

public class UserRolePOJO {
    @SerializedName("sno")
    String sno;
    @SerializedName("role")
    String role;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
