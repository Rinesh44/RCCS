package com.brilltech.rccs.realm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Donor extends RealmObject {
    @PrimaryKey
    String donorId;
    String title;
    String firstName;
    String lastName;
    String sufhebrew;
    String lastNameHebrew;
    String firstNameHebrew;
    String spouseTitle;
    String spouseFirstName;

}
