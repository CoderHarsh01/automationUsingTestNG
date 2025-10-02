package org.example.actions;

import java.util.Random;

public class RandomEmailGenerator {

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Generate random 8-character username
        for (int i = 0; i < 8; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString() + "@gmail.com";  // you can replace with gmail.com, etc.
    }

//    public static void main(String[] args) {
//        System.out.println(generateRandomEmail());
//        System.out.println(generateRandomEmail());
//    }
}
