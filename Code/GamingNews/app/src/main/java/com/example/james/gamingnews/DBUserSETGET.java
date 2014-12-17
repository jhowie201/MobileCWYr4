package com.example.james.gamingnews;

/**
 * Created by James on 15/12/2014.
 */
public class DBUserSETGET {

    private int UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String UserName;

    public DBUserSETGET() {

    }

    public DBUserSETGET(int UserID, String FirstName, String LastName, String Email, String Password, String UserName) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;

    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}