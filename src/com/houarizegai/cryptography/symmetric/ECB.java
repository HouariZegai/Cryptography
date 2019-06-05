
package com.houarizegai.cryptography.symmetric;

/* Electronic Code Book */

public class ECB {

    public String encrypt(String input, String key) {
        // This function receive bits and encrypt
        input = Tools.wordsToBits(input);
        input = Tools.fillBy0(input, key.length());
        
        String blocs[] = Tools.deviseToBloc(input, key.length());
        
        for(int i=0; i < blocs.length; i++) {
            blocs[i] = Tools.e(blocs[i], key);
        }
        
        String result = "";
        
        for(String str : blocs)
            result += str;
        
        return Tools.bitsToWords(result);
    }
    
    public String decrypt(String input, String key) {
        // This function receive bits and decrypt
        input = Tools.wordsToBits(input);
        input = Tools.fillBy0(input, key.length());
        
        String blocs[] = Tools.deviseToBloc(input, key.length());
        
        for(int i=0; i < blocs.length; i++) {
            blocs[i] = Tools.d(blocs[i], key);
        }
        
        String result = "";
        
        for(String str : blocs)
            result += str;
        
        return Tools.bitsToWords(result);
    }
    
}
