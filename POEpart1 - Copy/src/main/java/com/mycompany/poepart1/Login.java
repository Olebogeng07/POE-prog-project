/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author Student
 */
public class Login extends Registration{
    
    public boolean LoginUser(String name, String password){
            if(name.equals(userName) && password.equals(passWord)){
                return true;
            }else{
                return false;
            }
            
    }
    public String returnLoginStatus(boolean loginStatus){
        if(loginStatus){
            return "Login success";
        }else{
        return "Login failed";
    }
                 
    }}
