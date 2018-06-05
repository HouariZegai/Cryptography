package com.houarizegai.main;

import com.houarizegai.crypto.Feistel;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Feistel().encrypt("01001001", "1010", 4));
        
    }
    
    
    
}
