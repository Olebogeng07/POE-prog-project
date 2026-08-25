/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class POEpart1 {

    public static void main(String[] args) {
         // TODO code application logic here
         
        Login register = new Login();
        Scanner scan =new Scanner(System.in);
        
        System.out.println("\n===== Register =====");
        
        //Username input and checker
        
        System.out.println("Please enter the username: ");
        String name = scan.nextLine();
       
      
        
        System.out.println("Enter password");
        String password = scan.nextLine();
        
         System.out.println("Enter cellphone");
        String cellphone = scan.nextLine();
        
        System.out.println(register.registerUser(name, password, cellphone ));
        
        if(!register.registerstatus(name, password, cellphone)){
            return;
        }
     System.out.println("\n===== Log In =====");
      System.out.println("Please enter the username: ");
        String userName = scan.nextLine();
       
      
        
        System.out.println("Enter password");
        String passWord = scan.nextLine();
        System.out.println(register.LoginUser(userName, passWord));
    }
}
