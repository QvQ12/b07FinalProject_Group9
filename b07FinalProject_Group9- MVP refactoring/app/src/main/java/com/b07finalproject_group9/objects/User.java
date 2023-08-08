package com.b07finalproject_group9.objects;

public class User {
    private String username;
    private String password;

    public User(String username){
        this.username = username;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }
}
