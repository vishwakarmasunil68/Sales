package com.voxtrail.sales.pojo.lead;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadPOJO {

    @SerializedName("sno")
    @Expose
    private String sno;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("leadstage")
    @Expose
    private String leadstage;
    @SerializedName("jobtitle")
    @Expose
    private String jobtitle;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("unqualifiedreason")
    @Expose
    private String unqualifiedreason;
    @SerializedName("leadid")
    @Expose
    private String leadid;
    @SerializedName("compname")
    @Expose
    private String compname;
    @SerializedName("compaddress")
    @Expose
    private String compaddress;
    @SerializedName("compcity")
    @Expose
    private String compcity;
    @SerializedName("compstate")
    @Expose
    private String compstate;
    @SerializedName("compzipcode")
    @Expose
    private String compzipcode;
    @SerializedName("compcountry")
    @Expose
    private String compcountry;
    @SerializedName("compwebsite")
    @Expose
    private String compwebsite;
    @SerializedName("compphone")
    @Expose
    private String compphone;
    @SerializedName("contactperson")
    @Expose
    private String contactperson;
    @SerializedName("noofemp")
    @Expose
    private String noofemp;
    @SerializedName("comprevenue")
    @Expose
    private String comprevenue;
    @SerializedName("industrytype")
    @Expose
    private String industrytype;
    @SerializedName("businesstype")
    @Expose
    private String businesstype;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLeadstage() {
        return leadstage;
    }

    public void setLeadstage(String leadstage) {
        this.leadstage = leadstage;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnqualifiedreason() {
        return unqualifiedreason;
    }

    public void setUnqualifiedreason(String unqualifiedreason) {
        this.unqualifiedreason = unqualifiedreason;
    }

    public String getLeadid() {
        return leadid;
    }

    public void setLeadid(String leadid) {
        this.leadid = leadid;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getCompaddress() {
        return compaddress;
    }

    public void setCompaddress(String compaddress) {
        this.compaddress = compaddress;
    }

    public String getCompcity() {
        return compcity;
    }

    public void setCompcity(String compcity) {
        this.compcity = compcity;
    }

    public String getCompstate() {
        return compstate;
    }

    public void setCompstate(String compstate) {
        this.compstate = compstate;
    }

    public String getCompzipcode() {
        return compzipcode;
    }

    public void setCompzipcode(String compzipcode) {
        this.compzipcode = compzipcode;
    }

    public String getCompcountry() {
        return compcountry;
    }

    public void setCompcountry(String compcountry) {
        this.compcountry = compcountry;
    }

    public String getCompwebsite() {
        return compwebsite;
    }

    public void setCompwebsite(String compwebsite) {
        this.compwebsite = compwebsite;
    }

    public String getCompphone() {
        return compphone;
    }

    public void setCompphone(String compphone) {
        this.compphone = compphone;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getNoofemp() {
        return noofemp;
    }

    public void setNoofemp(String noofemp) {
        this.noofemp = noofemp;
    }

    public String getComprevenue() {
        return comprevenue;
    }

    public void setComprevenue(String comprevenue) {
        this.comprevenue = comprevenue;
    }

    public String getIndustrytype() {
        return industrytype;
    }

    public void setIndustrytype(String industrytype) {
        this.industrytype = industrytype;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }
}
