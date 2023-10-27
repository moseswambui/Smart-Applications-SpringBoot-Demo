package com.SpringJpa.Entities;

import org.springframework.data.annotation.Id;

public class BasicAuthUser {

    @Id
    private int userId;

    private String username;

    private String passwordHash;

    private String salt;

    private String displayName;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return this.username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPasswordHash() {
        return this.passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return this.salt;
    }


    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
