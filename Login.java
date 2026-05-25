/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author joshua
 */
public class Login {

    private String username;
    private String password;

    public Login(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public boolean loginUser(String enteredPassword) {

        return password.equals(enteredPassword);
    }
}