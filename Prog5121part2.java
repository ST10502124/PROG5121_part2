/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.prog5121part2.Message;
import java.util.ArrayList;
import java.util.Scanner;

public class Prog5121part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Login> users = new ArrayList<>();
        ArrayList<Message> messages = new ArrayList<>();

        users.add(new Login("kyl_1", "Password1!"));

        System.out.println("Welcome to QuickChat.");

        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (Login user : users) {

                if (user.getUsername().equals(username)
                        && user.loginUser(password)) {

                    loggedIn = true;
                    System.out.println("Login successful!");
                }
            }

            if (!loggedIn) {
                System.out.println("Invalid login.");
            }
        }

        System.out.print("How many messages do you want to send? ");
        int totalMessages = scanner.nextInt();
        scanner.nextLine();

        boolean running = true;
        int sentCount = 0;

        while (running) {

            System.out.println("\n1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    for (int i = 0; i < totalMessages; i++) {

                        System.out.println("\nMessage " + (i + 1));

                        System.out.print("Enter recipient: ");
                        String recipient = scanner.nextLine();

                        System.out.print("Enter message: ");
                        String text = scanner.nextLine();

                        Message msg =
                                new Message(recipient, text, i);

                        System.out.println(
                                msg.checkRecipientCell());

                        if (text.length() > 250) {

                            System.out.println(
                                    "Message exceeds 250 characters.");

                            continue;
                        }

                        System.out.println(
                                "Message ready to send.");

                        System.out.println(
                                "Message ID: "
                                + msg.getMessageID());

                        System.out.println(
                                "Message Hash: "
                                + msg.createMessageHash());

                        System.out.println("\n1. Send");
                        System.out.println("2. Disregard");
                        System.out.println("3. Store");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(
                                msg.SentMessage(choice));

                        if (choice == 1) {

                            messages.add(msg);

                            sentCount++;

                            msg.storeMessage();
                        }

                        System.out.println(
                                msg.printMessages());
                    }

                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println(
                "\nTotal sent messages: " + sentCount);

        System.out.println("Goodbye.");
    }
}