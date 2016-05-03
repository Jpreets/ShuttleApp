/**
 * Created Date: 4 April 2016
 * Last Modified Date: 26 April 2016
 */
package com.shuttle.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Document(collection = "user")
public class UserBean {

    @Id
    private int userId;
    @Size(min = 3, max = 100, message = "Name must be atleast 3 characters in length and less than 100 characters")
    private String userName;
    @Email
    private String userEmail;
    @NotNull
    @Size(min = 8, max = 100, message = "Password must be atleast 8 characters in length and less than 100 characters")
    private String userPassword;
    @Digits(integer = 10, fraction = 0, message = "Phone number cannot be more than 10 digits")
    private String userContact;
    private String userGender;
    private String userRole = "ROLE_ADMIN";
    private String userChangePassword = "Not Changed";

    public UserBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserChangePassword() {
        return userChangePassword;
    }

    public void setUserChangePassword(String userChangePassword) {
        this.userChangePassword = userChangePassword;
    }

    @Override
    public String toString() {
        return "UserBean{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userContact=" + userContact + ", userGender=" + userGender + ", userRole=" + userRole + ", userChangePassword=" + userChangePassword + '}';
    }
}
