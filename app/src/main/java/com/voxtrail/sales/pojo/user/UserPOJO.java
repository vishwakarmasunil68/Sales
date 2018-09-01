package com.voxtrail.sales.pojo.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPOJO {
    @SerializedName("sno")
    @Expose
    private String sno;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private Object dob;
    @SerializedName("mobileno")
    @Expose
    private String mobileno;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("usersrole")
    @Expose
    private String usersrole;
    @SerializedName("userdesignation")
    @Expose
    private String userdesignation;
    @SerializedName("previous_companyname")
    @Expose
    private Object previousCompanyname;
    @SerializedName("DOJ")
    @Expose
    private Object dOJ;
    @SerializedName("ipaddress")
    @Expose
    private String ipaddress;
    @SerializedName("registrationtime")
    @Expose
    private String registrationtime;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("verifyby")
    @Expose
    private String verifyby;
    @SerializedName("homeaddress")
    @Expose
    private Object homeaddress;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("cur_address")
    @Expose
    private Object curAddress;
    @SerializedName("pincode")
    @Expose
    private Object pincode;
    @SerializedName("skype")
    @Expose
    private Object skype;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("linkedin")
    @Expose
    private Object linkedin;
    @SerializedName("personalemail")
    @Expose
    private String personalemail;
    @SerializedName("alternatecontactno")
    @Expose
    private Object alternatecontactno;
    @SerializedName("maritalstatus")
    @Expose
    private Object maritalstatus;
    @SerializedName("imgpath")
    @Expose
    private String imgpath;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDob() {
        return dob;
    }

    public void setDob(Object dob) {
        this.dob = dob;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsersrole() {
        return usersrole;
    }

    public void setUsersrole(String usersrole) {
        this.usersrole = usersrole;
    }

    public String getUserdesignation() {
        return userdesignation;
    }

    public void setUserdesignation(String userdesignation) {
        this.userdesignation = userdesignation;
    }

    public Object getPreviousCompanyname() {
        return previousCompanyname;
    }

    public void setPreviousCompanyname(Object previousCompanyname) {
        this.previousCompanyname = previousCompanyname;
    }

    public Object getdOJ() {
        return dOJ;
    }

    public void setdOJ(Object dOJ) {
        this.dOJ = dOJ;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(String registrationtime) {
        this.registrationtime = registrationtime;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getVerifyby() {
        return verifyby;
    }

    public void setVerifyby(String verifyby) {
        this.verifyby = verifyby;
    }

    public Object getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(Object homeaddress) {
        this.homeaddress = homeaddress;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getCurAddress() {
        return curAddress;
    }

    public void setCurAddress(Object curAddress) {
        this.curAddress = curAddress;
    }

    public Object getPincode() {
        return pincode;
    }

    public void setPincode(Object pincode) {
        this.pincode = pincode;
    }

    public Object getSkype() {
        return skype;
    }

    public void setSkype(Object skype) {
        this.skype = skype;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Object getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(Object linkedin) {
        this.linkedin = linkedin;
    }

    public String getPersonalemail() {
        return personalemail;
    }

    public void setPersonalemail(String personalemail) {
        this.personalemail = personalemail;
    }

    public Object getAlternatecontactno() {
        return alternatecontactno;
    }

    public void setAlternatecontactno(Object alternatecontactno) {
        this.alternatecontactno = alternatecontactno;
    }

    public Object getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(Object maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
