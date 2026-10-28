/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

//import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 *
 * @author Student
 */
public class POEpart1 {

    public static void main(String[] args) {
         // TODO code application logic here
         
        Login register = new Login();
//        Scanner scan = new Scanner(System.in);
        Messages msg = new Messages();

        JOptionPane.showMessageDialog(null,
                "=====Register=====",
                "Registration",
                JOptionPane.INFORMATION_MESSAGE
             );
        
        
       String name = JOptionPane.showInputDialog(null, "Please enter username: ");
                
        
       String password = JOptionPane.showInputDialog(null,"Please enter pasword: ");

        
      String cellphone = JOptionPane.showInputDialog(null, "Please enter your cellphone number: ");
        

        JOptionPane.showMessageDialog(null,register.registerUser(name,password, cellphone));

        
        System.out.println(register.registerUser(name,
                password, cellphone));

        if (!register.registerstatus(name,
                password, cellphone)) {
            return;
        }
        
        JOptionPane.showMessageDialog(null," ===== Login ===== " , "Login",JOptionPane.INFORMATION_MESSAGE); 
        
       String  loginUsername =JOptionPane.showInputDialog(null , " Enter Username to Login");
       String  loginPassword =JOptionPane.showInputDialog(null , " Enter Password to Login");

        

       

        boolean status = register.LoginUser(loginUsername, loginPassword);

        JOptionPane.showMessageDialog(null ,register.returnLoginStatus(status));
        
        

        if (status == true) {

            int option;

            do {
                String menu = "===== Select any of the option below =====" + 
                        "1. Send message" +
                        "2. Message Management" +
                        "3. Exit" + 
                        "Select an option";
                        
               String input = JOptionPane.showInputDialog(null , menu , "Main Menu" , JOptionPane.QUESTION_MESSAGE);
               
               
               if(input == null){
                   
                   option = 3;
                   
               }else{
                   
                  
                   
                   try{
                       
                       option = Integer.parseInt(input);
                        switch (option) {
                    case 1 ->
                        msg.sendingMessages();
                    case 2 ->
                       msg.messageManagementMenu();
                    case 3 ->
                        JOptionPane.showMessageDialog(null ,"Good bye" );
                        
                    default ->
                        JOptionPane.showMessageDialog(null ,"Invalid option!!" ,"Error" ,JOptionPane.ERROR_MESSAGE  );
                        
                }
                   }catch(NumberFormatException e){
                       option = 0;
                       JOptionPane.showMessageDialog(null , "Please enter a valid number ", "Input Error", JOptionPane.WARNING_MESSAGE);
                       
                   }
                   
               }

               
             
            } while (option != 3);
        }

    }

}
