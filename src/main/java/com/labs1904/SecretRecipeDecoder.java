package com.labs1904;

import java.util.HashMap;
import java.util.Map;

public class SecretRecipeDecoder {
    private static Map<String, String> ENCODING = new HashMap<String, String>() {
        {
            put("y", "a");
            put("h", "b");
            put("v", "c");
            put("x", "d");
            put("k", "e");
            put("p", "f");
            put("z", "g");
            put("s", "h");
            put("a", "i");
            put("b", "j");
            put("e", "k");
            put("w", "l");
            put("u", "m");
            put("q", "n");
            put("n", "o");
            put("l", "p");
            put("m", "q");
            put("f", "r");
            put("o", "s");
            put("i", "t");
            put("g", "u");
            put("j", "v");
            put("t", "w");
            put("d", "x");
            put("r", "y");
            put("c", "z");
            put("3", "0");
            put("8", "1");
            put("4", "2");
            put("0", "3");
            put("2", "4");
            put("7", "5");
            put("5", "6");
            put("9", "7");
            put("1", "8");
            put("6", "9");
        }
    };

    //Best I can tell this function works is a keyvalue pair from a hashmap.
    //So maybe the best way to implement is string->hashmap->convert->string

    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        String encodedString = str; //changing for readability
        StringBuilder decodedString = new StringBuilder();

        for (int i = 0; i < encodedString.length(); i++) {
            //loop thru string, then swap for correct letter.
            String encodedLetter = String.valueOf(encodedString.charAt(i)); //loops thru the letters in string
            String decodedLetter = "";

            if(ENCODING.containsKey(encodedLetter)){ //behavior should just pass letter along if its not in cypher
                decodedLetter = ENCODING.get(i);
            } else {
                decodedLetter = encodedLetter;
            }
            decodedString.append(decodedLetter);
        }

        System.out.println(decodedString.toString());
        return decodedString.toString();
    }

    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement reading from text line maybe? need to look at table because data has #'s in it, but focus on getting basic functionality first then iron this out
        Ingredient x = new Ingredient("8 vgl", "hgiikf"); //use for test

        String y = decodeString(x.getAmount());
        String z = decodeString(x.getDescription());

        return new Ingredient(y, z);
    }

    public static void main(String[] args) {
        // TODO: implement me
        Ingredient secretrecipe = new Ingredient("8 vgl", "#hgiikf");  //use this for testing, need to implement reading this from file
        System.out.println(decodeString("8 vgl"));

    }
}
