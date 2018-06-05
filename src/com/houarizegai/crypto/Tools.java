package com.houarizegai.crypto;

public class Tools {

    public static String fillBy0(String input, int n) {
        // This function complete the text by 0 until the length of text equal k * n (with n is the length of bloc)

        while (input.length() % n != 0) {
            input += "0";
        }
        return input;
    }

    public static String[] deviseToBloc(String input, int lengthOfBloc) {
        // This function split String to blocs

        String inputArray[] = new String[input.length() / lengthOfBloc];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = input.substring(0, lengthOfBloc);
            input = input.substring(lengthOfBloc);
        }

        return inputArray;
    }

    public static String blocsToBloc(String[] input) {
        // This function convert blocs to one bloc (one String)

        String result = "";
        for (String str : input) {
            result += str;
        }

        return result;
    }

    public static String xor(String txt, String txt2) {
        // This function do the XOR between to list of bits.

        String result = "";
        for (int i = 0; i < txt.length(); i++) {
            result += (txt.charAt(i) == txt2.charAt(i)) ? "0" : "1";
        }
        return result;
    }

    public static String e(String input, String key) {
        char r[] = new char[key.length()];
        int index;
        for (int i = 0; i < r.length; i++) {
            index = Integer.parseInt(String.valueOf(key.charAt(i)));
            r[i] = input.charAt(index - 1);
        }

        return String.valueOf(r);
    }

    public static String d(String input, String key) {

        char r[] = new char[key.length()];
        int index;
        for (int i = 0; i < r.length; i++) {
            index = Integer.parseInt(String.valueOf(key.charAt(i)));
            r[index - 1] = input.charAt(i);
        }

        return String.valueOf(r);
    }

    public static String wordsToBits(String input) {
        int result[] = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = (int) input.charAt(i);
        }
        return Tools.blocsToBloc(decimalToBinary(result));
    }

    public static String bitsToWords(String input) {
        String blocBits[] = Tools.deviseToBloc(input, 8);
        
        return decimalToWord(binaryToDecimal(blocBits));
    }
    
    public static String decimalToWord(int[] input) {
        String result = "";
        for(int i = 0; i < input.length; i++) {
            result += (char) input[i];
        }
        return result;
    }

    public static int[] binaryToDecimal(String[] input) {
        int[] result = new int[input.length];
        
        for(int i = 0; i < input.length; i++) {
            int r = 0;
            for(int j = 0; j < input[i].length(); j++) {
                r += Math.pow(2, j) * Integer.parseInt(input[i].charAt(input[i].length() - j - 1) + "");
            }
            result[i] = r;
        }
        
        return result;
    }
    
    public static String[] decimalToBinary(int[] input) {
        String[] result = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = "";
            while (input[i] != 0) {
                result[i] = input[i] % 2 + result[i];
                input[i] = input[i] / 2;
            }
            result[i] = fillBy0Before(result[i], 8);
        }

        return result;
    }

    public static String fillBy0Before(String input, int n) {
        while (input.length() % n != 0) {
            input = "0" + input;
        }

        return input;
    }
}
