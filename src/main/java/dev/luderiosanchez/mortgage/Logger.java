package dev.luderiosanchez.mortgage;

public interface Logger {
    public enum LogType {INFO, WARNING, ERROR}
    void info(LogType type, String message, Object data);

    void warning(LogType type, String message, Object data);

    void error(LogType type, String message, Object data);

}