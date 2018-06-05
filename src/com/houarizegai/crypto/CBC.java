package com.houarizegai.crypto;

/* Cipher Bloc Chaining */
public class CBC {

    public String encrypt(String M, String key, String vi) {
        // C[j] = E(C[j-1] XOR m[j]) with: C[0] = vi
        
        M = Tools.wordsToBits(M);
        M = Tools.fillBy0(M, vi.length());
        String[] m = Tools.deviseToBloc(M, vi.length());
        String[] c = new String[m.length];
        c[0] = Tools.e(Tools.xor(m[0], vi), key);

        for (int i = 1; i < m.length; i++) {
            c[i] = Tools.e(Tools.xor(c[i - 1], m[i]), key);
        }
        
        return Tools.bitsToWords(Tools.blocsToBloc(c));
    }

    public String decrypt(String C, String key, String vi) {
        // m[j] = C[j-1] XOR D(c[j]) with: C[0] = vi

        C = Tools.wordsToBits(C);
        C = Tools.fillBy0(C, vi.length());
        String[] c = Tools.deviseToBloc(C, vi.length());
        
        String[] m = new String[c.length];
        m[0] = Tools.xor(vi, Tools.d(c[0], key));

        for (int i = 1; i < c.length; i++) {
            m[i] = Tools.xor(c[i - 1], Tools.d(c[i], key));
        }
        
        return Tools.bitsToWords(Tools.blocsToBloc(m));
    }

}
