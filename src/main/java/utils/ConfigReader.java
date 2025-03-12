package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for reading configuration properties from the config.properties file.
 */
public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input != null) {
                System.out.println("Loaded config.properties from classpath.");
            } else {
                // Fallback to loading from the project root
                File file = new File("config.properties");
                if (file.exists()) {
                    input = new FileInputStream(file);
                    System.out.println("Manually loaded config.properties from project root.");
                }
            }

            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath or project root!");
            }

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties!", e);
        }
    }

    /**
     * Retrieves a property value from the config.properties file.
     *
     * @param key The property key to retrieve.
     * @return The property value corresponding to the given key, or null if the key is not found.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}