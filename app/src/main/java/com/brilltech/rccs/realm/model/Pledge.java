package com.brilltech.rccs.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pledge extends RealmObject {
    @PrimaryKey
    private String pledgeId;
    private String donorId;
    private String invoice;
    private String category;
    private String campaign;
    private String pledgeDate;
    private String dueDate;
    private String solicitor1;
    private String solicitor2;
    private String collectorSolicitor;
    private String pledgeType;
    private float pledgeAmount;
    private float balanceAmount;
    private String groupSeq;
//        private String List<Payment> paymentList;
    private long pledgeDateTimestamp;
    private long dueDateTimestamp;
}
