package dev.luderiosanchez.mortgage;

import dev.luderiosanchez.mortgage.Logger;

public class Log implements Logger{
    @Override
    public void info(Logger.LogType type, String message, Object data) {
        System.out.println(formatMessage(type, message, data));
    }

    public void info(LogType type, String message) {
        System.out.println(formatMessage(type, message));
    }


    @Override
    public void warning(LogType type, String message, Object data) {
        System.out.println(formatMessage(type, message, data));
    }

    public void warning(LogType type, String message) {
        System.out.println(formatMessage(type, message));
    }

    @Override
    public void error(LogType type, String message, Object data) {
        throw new RuntimeException(formatMessage(type, message, data));
    }

    public void error(LogType type, String message) {
        throw new RuntimeException(formatMessage(type, message));
    }

    private static String formatMessage(LogType type, String message, Object data) {
        if (data != null) {
            return "[" + type + "] " + message + ". | " + "{" + "type: " + type + "," + "data: " + data + "}";
        } else {
            return formatMessage(type, message);
        }

    }

    private static String formatMessage(LogType type, String message) {
        return "[" + type + "] " + message + ".";
    }
}
