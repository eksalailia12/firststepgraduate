package com.project.jadwalsempro.model;

public class Admin {
    private String username, password;

    public Admin(){}

    public Admin(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
