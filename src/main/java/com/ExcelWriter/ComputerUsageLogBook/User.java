package com.ExcelWriter.ComputerUsageLogBook;

import java.util.Date;

public class User {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    private String firstName;
    private String lastName;
    private String email;

    //Default constructor
    public User(){}

    //parameterized constructor
    public User(int ID, String firstName, String lastName, String email, Date datetime) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.datetime = datetime;
    }

    private Date datetime;


}
