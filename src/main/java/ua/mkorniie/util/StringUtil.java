package ua.mkorniie.util;

import java.util.ArrayList;

public class StringUtil {

    //TODO: to tests
//    public static void main(String[] args) {
//        String abc = "abc";
//        System.out.println(capitalize(abc));
//    }

    public static String capitalize(String input) {
         return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static ArrayList<String> wrapInQuotes(ArrayList<String> input) {
        ArrayList<String> result = new ArrayList<>();
        for (String item : input) {
            result.add("'" + item + "'");
        }
        return result;
    }
}
