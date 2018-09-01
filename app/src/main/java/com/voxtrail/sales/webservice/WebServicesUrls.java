package com.voxtrail.sales.webservice;

/**
 * Created by sunil on 20-01-2017.
 */

public class WebServicesUrls {
    public static final String BASE_URL = "http://192.168.122.1/lms/";
//    public static final String BASE_URL = "http://180.151.193.36:8000/lms/";

    public static final String LOGIN_API = BASE_URL + "user/User/login";
    public static final String GET_USER_ROLES = BASE_URL + "user/user/allUsersRole";
    public static final String GET_LEADS = BASE_URL + "lead/Lead/leadList";
    public static final String GET_CONTACTED_LEAD = BASE_URL + "lead/Lead/contactedLeadList";
    public static final String GET_LEAD_INFO = BASE_URL + "lead/Lead/leadInfo";
    public static final String GET_NOTES = BASE_URL + "lead/Lead/getAllNotes";
    public static final String INSERT_NOTE = BASE_URL + "lead/Lead/insertNote";
    public static final String GET_ALL_OUTCOMES = BASE_URL + "lead/Lead/getOutcomes";
}
