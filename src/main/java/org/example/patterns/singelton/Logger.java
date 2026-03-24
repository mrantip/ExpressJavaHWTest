package org.example.patterns.singelton;

public class Logger {
    public String eventsLog = "Success";
    public String errorsLog = "ERROR";
    public String warningsLog = "WARNING";

    private Logger() {
    }

    private static Logger logger;

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
