package com.voxtrail.sales.pojo.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadOutcomePOJO {

    @SerializedName("sno")
    @Expose
    private String sno;
    @SerializedName("outcome")
    @Expose
    private String outcome;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
