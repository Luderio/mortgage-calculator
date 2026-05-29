package dev.luderiosanchez.mortgage;

public class ConsoleLogger implements Logger{
    public enum LogType {INFO, WARNING, ERROR}

    @Override
    public void info(String message, Object data) {
        System.out.println(formatMessage(LogType.INFO, message, data));
    }

    public void info(String message) {
        System.out.println(formatMessage(LogType.INFO, message));
    }


    @Override
    public void warning(String message, Object data) {
        System.out.println(formatMessage(LogType.WARNING, message, data));
    }

    public void warning(String message) {
        System.out.println(formatMessage(LogType.WARNING, message));
    }

    @Override
    public void error(String message, Object data) {
        throw new RuntimeException(formatMessage(LogType.ERROR, message, data));
    }

    public void error(String message) {
        throw new RuntimeException(formatMessage(LogType.ERROR, message));
    }

    private static String formatMessage(LogType type, String message, Object data) {
        if (data != null) {
            return "[" + type + "] " + message + ". | " + "{" + "type: " + type + ", " + "data: " + data + "}";
        } else {
            return formatMessage(type, message);
        }

    }

    private static String formatMessage(LogType type, String message) {
        return "[" + type + "] " + message + ".";
    }
}
