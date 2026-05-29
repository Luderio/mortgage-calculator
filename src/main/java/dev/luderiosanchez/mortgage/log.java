package dev.luderiosanchez.mortgage;

public class log implements logger{
    @Override
    public void info(LogType type, Object data, String message) {
        String output = formatMessage(LogType.WARNING, message);
        if (data != null) {
            output += data.toString();
        }
        System.out.println(output);
    }

    public void info(LogType type, String message) {
        String output = formatMessage(LogType.INFO, message);
        System.out.println(output);
    }


    @Override
    public void warning(LogType type, Object data, String message) {
        String output = formatMessage(LogType.WARNING, message);
        if (data != null) {
            output += data.toString();
        }
        System.out.println(output);
    }

    public void warning(LogType type, String message) {
        String output = formatMessage(LogType.WARNING, message);
        System.out.println(output);
    }

    @Override
    public void error(LogType type, Object data, String message) {
        String output = formatMessage(LogType.ERROR, message);
        if (data != null) {
            output += data.toString() + ".";
        }
        throw new RuntimeException(output);
    }

    public void error(LogType type, String message) {
        String output = formatMessage(LogType.ERROR, message);
        throw new RuntimeException(output);
    }

    private  static String formatMessage(LogType type, String message) {
        return "[" + type + "] " + message + ".";
    }
}
