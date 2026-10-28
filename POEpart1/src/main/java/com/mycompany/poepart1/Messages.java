/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.awt.Font;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
//import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Student
 */
public class Messages {

    ArrayList<String> sentMessages = new ArrayList<>();
    ArrayList<String> messageIdsList = new ArrayList<>();
    HashSet<String> messageIds = new HashSet<>();
    ArrayList<String> msgHash = new ArrayList<>();
    ArrayList<String> recipientNumber = new ArrayList<>();
    ArrayList<String> messageStatus = new ArrayList<>();
    ArrayList<String> disregardedMessages = new ArrayList<>();
    ArrayList<String> storedMessages = new ArrayList<>();
    ArrayList<String> senders = new ArrayList<>();

    Random random = new Random();

    int numMessageSent = 0;

    public static void main(String[] args) {
        Messages app = new Messages();

        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    "1. Send messages"
                  + "\n2. Message management menu"
                  + "\n3. Exit"
                  + "\n\nChoose an option (1-3):",
                    "Main Menu", JOptionPane.QUESTION_MESSAGE);

            if (choice == null) {
                break;
            }

            switch (choice.trim()) {
                case "1" -> app.sendingMessages();
                case "2" -> app.messageManagementMenu();
                case "3" -> {
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null,
                        "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void sendingMessages() {

        int numberOfMessages = 0;

        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    "How many messages do you want to send?",
                    "Send Messages", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                return;
            }

            try {
                numberOfMessages = Integer.parseInt(input.trim());
                if (numberOfMessages < 1) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a number greater than 0.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        for (int i = 1; i <= numberOfMessages; i++) {

            String messageID = generateMessageID();

            String recipient;
            while (true) {
                recipient = JOptionPane.showInputDialog(null,
                        "MESSAGE " + i + " of " + numberOfMessages
                      + "\n\nEnter recipient cell number:",
                        "Recipient", JOptionPane.QUESTION_MESSAGE);

                if (recipient == null) {
                    return;
                }

                String recipientResult = checkRecipientCell(recipient.trim());

                if (recipientResult.equals("Valid number")) {
                    recipient = recipient.trim();
                    break;
                }

                JOptionPane.showMessageDialog(null, recipientResult,
                        "Invalid number", JOptionPane.ERROR_MESSAGE);
            }

            String messageText;
            while (true) {
                messageText = JOptionPane.showInputDialog(null,
                        "Enter your message (1 to 250 characters):",
                        "Message", JOptionPane.QUESTION_MESSAGE);

                if (messageText == null) {
                    return;
                }

                if (messageText.length() > 250 || messageText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a message of 1 to 250 characters.",
                            "Invalid message", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            int messageNumber = sentMessages.size() + 1;

            String messageHash = createMessageHash(messageID, messageNumber, messageText);

            msgHash.add(messageHash);
            sentMessages.add(messageText);
            messageIdsList.add(messageID);
            messageIds.add(messageID);
            recipientNumber.add(recipient);

            String sender = JOptionPane.showInputDialog(null,
                    "Enter sender name:", "Sender", JOptionPane.QUESTION_MESSAGE);

            if (sender == null || sender.trim().isEmpty()) {
                sender = "Unknown";
            }
            senders.add(sender.trim());

            String status = SentMessage();

            messageStatus.add(status);

            if (status.equals("Sent")) {
                numMessageSent++;
            }
        }

        printMessages();

        JOptionPane.showMessageDialog(null,
                "Total messages sent: " + returnTotalMessages(),
                "Total", JOptionPane.INFORMATION_MESSAGE);
    }

    public int returnTotalMessages() {
        return numMessageSent;
    }

    public String createMessageHash(String messageID, int messageNumber, String messageText) {

        String firstTwoNumbers = messageID.substring(0, 2);

        String cleanMessage = messageText.trim();

        String[] words = cleanMessage.split("\\s+");

        String firstWord = words[0];

        String lastWord = words[words.length - 1];

        String hash = firstTwoNumbers + ":" + messageNumber + ":" + firstWord + lastWord;

        return hash.toUpperCase();
    }

    public String generateMessageID() {

        String messageID;

        do {
            long number = 1000000000L + random.nextLong(9000000000L);
            messageID = String.valueOf(number);
        } while (messageIds.contains(messageID));

        return messageID;
    }

    public String checkRecipientCell(String cellphone) {

        if (cellphone.matches("^\\+27[0-9]{9}$") || cellphone.matches("^0[0-9]{9}$")) {
            return "Valid number";
        } else {
            return "Invalid number";
        }
    }

    public String SentMessage() {

        Object[] options = {"Send", "Disregard", "Store"};

        int choice = JOptionPane.showOptionDialog(null,
                "Choose what you want to do with this message!",
                "Message Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {

            case 0 -> {
                JOptionPane.showMessageDialog(null, "Message successfully sent",
                        "Sent", JOptionPane.INFORMATION_MESSAGE);
                return "Sent";
            }

            case 1 -> {

                int deleteChoice = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this message?",
                        "Disregard Message", JOptionPane.YES_NO_OPTION);

                if (deleteChoice == JOptionPane.YES_OPTION) {

                    JOptionPane.showMessageDialog(null, "Message deleted",
                            "Deleted", JOptionPane.INFORMATION_MESSAGE);

                    int lastIndex = sentMessages.size() - 1;

                    String messageID = messageIdsList.get(lastIndex);
                    messageIds.remove(messageID);

                    recipientNumber.remove(lastIndex);
                    sentMessages.remove(lastIndex);
                    msgHash.remove(lastIndex);
                    messageIdsList.remove(lastIndex);
                    senders.remove(lastIndex);

                    return "Disregarded";

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid option!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return "Disregarded";
                }
            }

            case 2 -> {
                JOptionPane.showMessageDialog(null, "Message successfully stored",
                        "Stored", JOptionPane.INFORMATION_MESSAGE);
                return "Stored";
            }

            default -> {
                JOptionPane.showMessageDialog(null, "Invalid option",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return "Disregarded";
            }
        }
    }

    public String printMessages() {

        StringBuilder allMessages = new StringBuilder();

        if (sentMessages.isEmpty()) {
            allMessages.append("No messages have been sent yet.");
        } else {
            for (int i = 0; i < sentMessages.size(); i++) {

                int messageNumber = i + 1;

                allMessages.append("\n==============================\n");
                allMessages.append("Message Number: ").append(messageNumber).append("\n");
                allMessages.append("Message ID: ").append(messageIdsList.get(i)).append("\n");
                allMessages.append("Recipient: ").append(recipientNumber.get(i)).append("\n");
                allMessages.append("Message: ").append(sentMessages.get(i)).append("\n");
                allMessages.append("Message Hash: ").append(msgHash.get(i)).append("\n");
                allMessages.append("Status: ").append(messageStatus.get(i)).append("\n");
            }
        }

        showMessageArea(allMessages.toString(), "All Messages");

        return allMessages.toString();
    }

    public void messageManagementMenu() {

        while (true) {

            String option = JOptionPane.showInputDialog(null, """
                                                              1. Show disregarded messages
                                                              2. Show all stored messages
                                                              3. Delete a message by Hash ID
                                                              4. Display full report
                                                              5. Search for a message
                                                              6. Display the longest message
                                                              7. Back to main menu
                                                              
                                                              Choose an option (1-7):""",
                    "Message Management", JOptionPane.QUESTION_MESSAGE);

            if (option == null) {
                return;
            }

            switch (option.trim()) {
                case "1" -> showDisregardedMessages();
                case "2" -> showAllStoredMessages();
                case "3" -> deleteMessageByHash();
                case "4" -> displayFullReport();
                case "5" -> searchMessageByHashId();
                case "6" -> findLongestMessage();
                case "7" -> {
                    return;
                }
                default -> JOptionPane.showMessageDialog(null,
                        "Invalid choice.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void findLongestMessage() {

        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No sent message to analyze the longest",
                    "Longest Message", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int maxLength = -1;
        int index = -1;

        for (int i = 0; i < sentMessages.size(); i++) {

            int currentLength = sentMessages.get(i).length();

            if (currentLength > maxLength) {
                maxLength = currentLength;
                index = i;
            }
        }

        if (index != -1) {

            StringBuilder details = new StringBuilder();
            details.append("========== LONGEST MESSAGE SENT ==========\n\n");
            details.append("Length: ").append(maxLength).append(" characters long\n");
            details.append("Message ID: ").append(messageIdsList.get(index)).append("\n");
            details.append("Sender: ").append(senders.get(index)).append("\n");
            details.append("Recipient: ").append(recipientNumber.get(index)).append("\n");
            details.append("Message: ").append(sentMessages.get(index));

            showMessageArea(details.toString(), "Longest Message Sent");
        }
    }

    public void searchMessageByHashId() {

        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No sent messages to search",
                    "Search", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String hashId = JOptionPane.showInputDialog(null,
                "Enter the Hash ID to search:",
                "Search Message", JOptionPane.QUESTION_MESSAGE);

        if (hashId == null) {
            return;
        }

        if (hashId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Hash ID cannot be empty.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = msgHash.indexOf(hashId.trim());

        if (index == -1) {
            JOptionPane.showMessageDialog(null,
                    "No message exists with this Hash ID: " + hashId,
                    "Not Found", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder details = new StringBuilder();
        details.append("========== Message Details ==========\n\n");
        details.append("Hash ID: ").append(msgHash.get(index)).append("\n");
        details.append("Message ID: ").append(messageIdsList.get(index)).append("\n");
        details.append("From: ").append(senders.get(index)).append("\n");
        details.append("To: ").append(recipientNumber.get(index)).append("\n");
        details.append("Message: ").append(sentMessages.get(index)).append("\n");
        details.append("Length: ").append(sentMessages.get(index).length())
              .append(" characters long");

        showMessageArea(details.toString(), "Message Details");
    }

    public void displayFullReport() {

        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No sent messages to display.",
                    "Full Report", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder report = new StringBuilder();
        report.append("========== Full Message Report ==========\n\n");

        report.append(String.format("| %-5s | %-15s | %-15s | %-20s | %-12s | %-10s |%n",
                "No.", "Sender", "Recipient", "Message", "Message ID", "Hash ID"));

        for (int i = 0; i < sentMessages.size(); i++) {

            String message = sentMessages.get(i);

            if (message.length() > 20) {
                message = message.substring(0, 17) + "...";
            }

            report.append(String.format("| %-5d | %-15s | %-15s | %-20s | %-12s | %-10s |%n",
                    i + 1,
                    senders.get(i),
                    recipientNumber.get(i),
                    message,
                    messageIdsList.get(i),
                    msgHash.get(i)));
        }

        report.append("\nTotal Sent Messages: ").append(sentMessages.size()).append("\n");
        report.append("Total Disregarded Messages: ").append(disregardedMessages.size()).append("\n");
        report.append("Total Stored Messages: ").append(storedMessages.size());

        showMessageArea(report.toString(), "Full Message Report");
    }

    public void deleteMessageByHash() {

        String hash = JOptionPane.showInputDialog(null,
                "Enter Hash ID to delete:",
                "Delete Message", JOptionPane.QUESTION_MESSAGE);

        if (hash == null) {
            return;
        }

        if (hash.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Hash ID cannot be empty.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int index = msgHash.indexOf(hash.trim());

        if (index != -1) {
            disregardedMessages.add(sentMessages.get(index));
            messageIds.remove(messageIdsList.get(index));
            sentMessages.remove(index);
            senders.remove(index);
            recipientNumber.remove(index);
            messageIdsList.remove(index);
            msgHash.remove(index);
            messageStatus.remove(index);

            JOptionPane.showMessageDialog(null,
                    "Message deleted and moved to disregarded",
                    "Deleted", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Message not found",
                    "Not Found", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void showAllStoredMessages() {

        if (storedMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No stored messages to display",
                    "Stored Messages", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder list = new StringBuilder();
        list.append("========== All Stored Messages ==========\n\n");

        for (int i = 0; i < storedMessages.size(); i++) {
            list.append(i + 1).append(". ").append(storedMessages.get(i)).append("\n");
        }

        showMessageArea(list.toString(), "Stored Messages");
    }

    public void showDisregardedMessages() {

        if (disregardedMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No deleted messages yet.",
                    "Disregarded Messages", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder list = new StringBuilder();
        list.append("========== DELETED MESSAGES ==========\n\n");

        for (int i = 0; i < disregardedMessages.size(); i++) {
            list.append(i + 1).append(". ").append(disregardedMessages.get(i)).append("\n");
        }

        showMessageArea(list.toString(), "Disregarded Messages");
    }

    private void showMessageArea(String text, String title) {
        JTextArea area = new JTextArea(text, 20, 45);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, title, JOptionPane.INFORMATION_MESSAGE);
    }
}

    

