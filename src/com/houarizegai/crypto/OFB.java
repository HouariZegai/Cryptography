package com.houarizegai.crypto;

public class OFB {

    private String[] I, O, t, m, c;

    public String encrypt(String M, String key, String v, int r) {
        M = Tools.wordsToBits(M);
        M = Tools.fillBy0(M, key.length());
        m = Tools.deviseToBloc(M, r);

        I = new String[m.length + 1]; // i make +1 for evite the Exception out of bound
        O = new String[m.length];
        t = new String[m.length];
        c = new String[m.length];

        I[0] = v;

        for (int i = 0; i < m.length; i++) {
            O[i] = Tools.e(I[i], key);
            t[i] = O[i].substring(0, r);
            c[i] = Tools.xor(t[i], m[i]);
            I[i + 1] = O[i];
        }

        return Tools.bitsToWords(Tools.blocsToBloc(c));
    }

}
