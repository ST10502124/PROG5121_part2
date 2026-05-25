package com.mycompany.prog5121part2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private int messageNumber;

    public Message(String recipient,
                   String message,
                   int messageNumber) {

        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;

        generateMessageID();
    }

    public void generateMessageID() {

        Random random = new Random();

        long number =
                1000000000L
                + (long)(random.nextDouble()
                * 8999999999L);

        messageID = String.valueOf(number);
    }

    public String getMessageID() {

        return messageID;
    }

    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    public String checkRecipientCell() {

        if (recipient.matches("\\+27[6-8][0-9]{8}")) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number incorrectly formatted.";
    }

    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord =
                words[0].toUpperCase();

        String lastWord =
                words[words.length - 1]
                .toUpperCase();

        String firstTwo =
                messageID.substring(0, 2);

        return firstTwo + ":"
                + messageNumber + ":"
                + firstWord + lastWord;
    }

    public String SentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {

        return "\nMessage ID: " + messageID
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    public int returnTotalMessages() {

        return messageNumber + 1;
    }

    public void storeMessage() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "messages.txt",
                            true);

            writer.write(
                    "Message ID: "
                    + messageID
                    + "\n");

            writer.write(
                    "Recipient: "
                    + recipient
                    + "\n");

            writer.write(
                    "Message: "
                    + message
                    + "\n\n");

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error writing file.");
        }
    }
}