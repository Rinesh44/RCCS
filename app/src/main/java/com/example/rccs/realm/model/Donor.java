package com.example.rccs.realm.model;

import java.util.List;

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
    String
}
