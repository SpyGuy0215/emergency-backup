package com.spyguy.astralturrets.util;

public class Logger {
    // Small little class to make customized logs

    static String RESET = "\u001B[0m";
    static String WHITE = "\u001B[37m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String BLUE = "\u001B[36m";
    public static void log(Object message){
        message = convertToString(message);
        System.out.println(WHITE + "[LOG] " + message + RESET);
    }
    public static void error(Object message){
        message = convertToString(message);
        System.out.println(RED + "[ERROR] " + message + RESET);
    }
    public static void warn(Object message){
        message = convertToString(message);
        System.out.println(YELLOW + "\u001B[33m" + "[WARN] " + message + RESET);
    }
    public static void debug(Object message){
        message = convertToString(message);
        System.out.println(BLUE + "[DEBUG] " + message + RESET);
    }

    private static String convertToString(Object object){
        return object.toString();
    }
}
