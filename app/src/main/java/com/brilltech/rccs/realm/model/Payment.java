package com.brilltech.rccs.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Payment extends RealmObject {
    @PrimaryKey
    private String paymentId;
    private String donorId;
    private String categoty;


}
