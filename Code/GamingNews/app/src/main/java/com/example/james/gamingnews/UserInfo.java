package com.example.james.gamingnews;

/**
 * Created by James on 15/12/2014.
 */

import java.io.Serializable;



   public class UserInfo implements Serializable {

             // *********************************************
             // Declare variables etc.
             // *********************************************

    private int UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String UserName;



           private static final long serialVersionUID = 0L;

             // *********************************************
             // Declare getters and setters etc.
           // *********************************************


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
           return Email;
       }

       public void setUserName(String UserName) {
           this.UserName = UserName;
       }




       @Override
        public String toString() {
           String UserData;
            UserData = "UserInfo [UserID=" +UserID;
             UserData = ", FirstName= " + FirstName;
             UserData = ", LastName= " + LastName;
             UserData = ", Password= " + Password;
             UserData = ", Email= " + Email;


            return UserData;
            }

                }