package utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
    /**
     * Create a single logger instance for the project
     */
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    /**
     * Info Level Logging
     * Accepts a custom info level message and outputs it both to the console and the Cucumber report
     *
     * @param message
     */
    public static void info(String message) {
        logger.info(message);
    }

    /**
     * Warn Level Logging
     * Accepts a custom warning level message and outputs it both to the console and the Cucumber report
     *
     * @param message
     */
    public static void warn(String message) {
        logger.warn(message);
    }

    /**
     * Error Level Logging
     * Accepts a custom error level message and outputs it both to the console and the Cucumber report
     *
     * @param message
     */
    public static void error(String message) {
        logger.error(message);
    }

    /**
     * Debug Level Logging
     * Accepts a custom debug level message and outputs it both to the console and the Cucumber report
     *
     * @param message
     */
    public static void debug(String message) {
        logger.debug(message);
    }
}//Class
