package dev.luderiosanchez.mortgage;

public interface logger {
    public enum LogType {INFO, WARNING, ERROR}
    void info(LogType type, Object data, String message );
    void warning(LogType type, Object data, String message );
    void error(LogType type, Object data, String message );
}
