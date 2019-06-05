
package com.houarizegai.cryptography.symmetric;

public class CFB {
    
    private String[] I, O, t, m, c;
            
    public String encrypt(String M, String key, String v, int r) {
        M = Tools.wordsToBits(M);
        M = Tools.fillBy0(M, r);
        m = Tools.deviseToBloc(M, r);
        
        I = new String[m.length + 1]; // i make +1 for evite the Exception out of bound
        O = new String[m.length];
        t = new String[m.length];
        c = new String[m.length];
        
        I[0] = v;
        
        for(int i = 0; i < m.length; i++) {
            O[i] = Tools.e(I[i], key);
            t[i] = O[i].substring(0, r);
            c[i] = Tools.xor(t[i], m[i]);
            I[i + 1] = I[i].substring(r) + c[i];
        }
        return Tools.bitsToWords(Tools.blocsToBloc(c));
    }
    
    public String decrypt(String C, String key, String v, int r) {
        C = Tools.wordsToBits(C);
        C = Tools.fillBy0(C, r);
        c = Tools.deviseToBloc(C, r);
        
        I = new String[c.length + 1]; // i make +1 for evite the Exception out of bound
        O = new String[c.length];
        t = new String[c.length];
        m = new String[c.length];
        
        I[0] = v;
        
        for(int i = 0; i < c.length; i++) {
            O[i] = Tools.e(I[i], key);
            t[i] = O[i].substring(0, r);
            m[i] = Tools.xor(t[i], c[i]);
            I[i + 1] = I[i].substring(r) + c[i];
        }
        return Tools.bitsToWords(Tools.blocsToBloc(m));
    }
    
}
