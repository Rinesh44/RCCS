package com.example.rccs.api;

public interface Endpoints {
    String CONTENT_TYPE = "Content-Type: application/protobuf";
    String AUTHORIZATION = "authorization";

    String API_BASE_URL = "https://rccs-api.brilltech.com";

    String LOGIN = "/account/login";
    String LOGOUT = "/account/logout";
    String ADD_USER = "/user";
    String DELETE_USER = "/user/";
    String FETCH_ALL_USERS = "/users";
    String PASSWORD_RESET = "/user/password/update";
    String PASSWORD_RESET_ADMIN = "/user/password/reset";
    String FETCH_REPORT_MASTER = "/";
    String FETCH_PHONES = "/phone";
    String FETCH_ADDRESS = "/address";
    String FETCH_PLEDGE = "/pledge";
    String FETCH_PAYMENTS = "/payment";
    String FETCH_EVENTS = "/event";
    String FETCH_MASTER = "/master";
    String FETCH_REPORT_SINGLE_DONOR = "/master/";
    String FETCH_NOTES = "/note";
    String FETCH_ASSOCIATIONS = "/association";
    String FETCH_AGGREGRATE_REPORT = "/report/aggregate";

}
