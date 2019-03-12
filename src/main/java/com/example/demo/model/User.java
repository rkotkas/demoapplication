package com.example.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "user_name", length = 36)
    @NotNull
    private String userName;

    @Column(name = "encrypted_password", length = 128)
    @NotNull
    private String encryptedPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String toString() {
        return "LoginForm(UserName: " + this.userName + ", Password: " + this.encryptedPassword + ")";
    }
}
