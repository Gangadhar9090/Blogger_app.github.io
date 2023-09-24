package com.myblog.blogapp.payload;

import java.util.Date;

public class Errordetails {
    private Date timestamp;
    private String message;
    private  String details;

    public Errordetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;


    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
