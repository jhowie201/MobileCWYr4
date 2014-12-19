package com.example.james.gamingnews.DataBase;

//JAMES HOWIE S1310206 MUC GamingNews Application!
/**
 * Created by James on 15/12/2014.
 */
   public class UserInfo{
             // *********************************************
             // Declare variables etc.
             // *********************************************
    private int UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String UserName;

    public UserInfo(){

    }
    public UserInfo(int UserID, String FirstName, String LastName, String Email, String Password, String UserName) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }
      // *********************************************
      // Declare getters and setters etc.
      // *********************************************
       public int getUserID() {
         return UserID;
         }
       public void setUserID(int UserID) {this.UserID = UserID;}
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
       public String getPassword() {
           return LastName;
       }
       public void setPassword(String Password) {
           this.Password = Password;
       }
       public String getEmail() {
            return Email;
            }
       public void setEmail(String Email) {
            this.Email = Email;
            }
       public String getUserName() {
           return UserName;
       }
       public void setUserName(String UserName) {
           this.UserName = UserName;
       }

       @Override
        public String toString() {
           String UserData;
           UserData = "User's Full Name: " + FirstName + " " + LastName + "\n" +
           "User's Email Address: " + Email + "\n" + "And Users ID is: " + UserID; //String for returning User Info to TextView
            return UserData;
            }
       }