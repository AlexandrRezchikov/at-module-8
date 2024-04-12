package org.example.framework.utils;

public class Regex {

    public static int regexForNumberOfTours(String count) {

        return Integer.parseInt(count.replaceAll("\\D", ""));
    }
}
