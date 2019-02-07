package com.houarizegai.main;

import com.houarizegai.crypto.Feistel;

public class Main {
    public static void main(String[] args) {
        String plainText = "01001001";
        String key = "1010";
        int round = 4;

        Feistel feistel = new Feistel();
        System.out.println(feistel.encrypt(plainText, key, round));
        
    }
}
