package com.houarizegai.crypto;

/* Schéma de Feistel */

public class Feistel {

    public String encrypt(String plainText, String key, int round) {
        plainText = Tools.fillBy0(plainText, key.length() * 2);
        
        for (int i = 0; i < round - 1; i++) {
            plainText = firstRound(plainText, key);
        }
        
        return lastRound(plainText, key);
    }

    private String firstRound(String plainText, String key) {
        String left = plainText.substring(0, key.length());
        String right = plainText.substring(key.length(), key.length() * 2);
        String rs = "";
        for (int i = 0; i < key.length(); i++) {
            rs += (right.charAt(i) == key.charAt(i)) ? "0" : "1";
        }

        String rs2 = "";
        for (int i = 0; i < rs.length(); i++) {
            rs2 += (rs.charAt(i) == left.charAt(i)) ? "0" : "1";
        }
        left = right;
        right = rs2;

        return left + right;
    }

    private String lastRound(String plainText, String key) {
        String left = plainText.substring(0, key.length());
        String right = plainText.substring(key.length(), key.length() * 2);
        String rs = "";
        for (int i = 0; i < key.length(); i++) {
            rs += (right.charAt(i) == key.charAt(i)) ? "0" : "1";
        }

        String rs2 = "";
        for (int i = 0; i < rs.length(); i++) {
            rs2 += (rs.charAt(i) == left.charAt(i)) ? "0" : "1";
        }
        left = rs2;

        return left + right;
    }
    
}