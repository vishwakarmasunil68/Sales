package com.voxtrail.sales.pojo.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadNotePOJO {

    @SerializedName("sno")
    @Expose
    private String sno;
    @SerializedName("leadid")
    @Expose
    private String leadid;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("commentdatetime")
    @Expose
    private String commentdatetime;
    @SerializedName("commentby")
    @Expose
    private String commentby;
    @SerializedName("commentby_id")
    @Expose
    private String commentbyId;
    @SerializedName("commentby_email")
    @Expose
    private String commentbyEmail;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getLeadid() {
        return leadid;
    }

    public void setLeadid(String leadid) {
        this.leadid = leadid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentdatetime() {
        return commentdatetime;
    }

    public void setCommentdatetime(String commentdatetime) {
        this.commentdatetime = commentdatetime;
    }

    public String getCommentby() {
        return commentby;
    }

    public void setCommentby(String commentby) {
        this.commentby = commentby;
    }

    public String getCommentbyId() {
        return commentbyId;
    }

    public void setCommentbyId(String commentbyId) {
        this.commentbyId = commentbyId;
    }

    public String getCommentbyEmail() {
        return commentbyEmail;
    }

    public void setCommentbyEmail(String commentbyEmail) {
        this.commentbyEmail = commentbyEmail;
    }
}
