package com.houarizegai.cryptography.symmetric.crypto_algo1;

import java.util.Scanner;

public class Crypto1 {

    private final static String[][] POLYBE = {
        {"A", "B", "C", "D", "E"},
        {"F", "G", "H", "IJ", "K"},
        {"L", "M", "N", "O", "P"},
        {"Q", "R", "S", "T", "U"},
        {"V", "W", "X", "Y", "Z"}
    };
    
    public static void main(String[] args) {
        
        Scanner mScanner = new Scanner(System.in);
        System.out.print("Type Plain Message: ");
        String msgPlain = mScanner.nextLine();
        
        String msgCrypte = getMsgCrypte(msgPlain);
        System.out.println("Msg ctypte : " + msgCrypte);
    }
    
    private static String getMsgCrypte(String msgPlain) {
        String msgCrypte = "";
        
        for(char c : msgPlain.toCharArray()) {
            loopTable:
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(POLYBE[i][j].contains(String.valueOf(c).toUpperCase())) {
                        msgCrypte += i;
                        msgCrypte += j;
                        break loopTable;
                    }
                }
            }
        }
        
        return msgCrypte;
    }    
}
