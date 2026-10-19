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
        Scanner scan = new Scanner(System.in);
        Messages msg = new Messages();

        System.out.println("\n===== Register =====");

        System.out.println("Please enter the username: ");
        String name = scan.nextLine();

        System.out.println("Enter password");
        String password = scan.nextLine();

        System.out.println("Enter cellphone");
        String cellphone = scan.nextLine();

        System.out.println(register.registerUser(name,
                password, cellphone));

        if (!register.registerstatus(name,
                password, cellphone)) {
            return;
        }

        System.out.println("\n===== Login =====");

        System.out.print("Enter username: ");
        String loginUsername = scan.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scan.nextLine();

        boolean status = register.LoginUser(loginUsername, loginPassword);

        System.out.println(register.returnLoginStatus(status));

        if (status == true) {

            int option;

            do {
                System.out.println("\n===== Select any of the option below =====");
                System.out.println("1. Send message");
                System.out.println("2. Coming soon");
                System.out.println("3. Exit");

                option = scan.nextInt();

                switch (option) {
                    case 1 ->
                        msg.sendingMessage();
                    case 2 ->
                       System.out.println("Coming Soon");
                    case 3 ->
                        System.out.println("Good bye");
                    default ->
                        System.out.println("Invalid option!!");
                }

            } while (option != 3);
        }

    }

}
