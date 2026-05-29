package dev.luderiosanchez.mortgage;

public interface Logger {
    void info(String message, Object data);

    void warning(String message, Object data);

    void error(String message, Object data);

}