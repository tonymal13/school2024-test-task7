package ru.mal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;

    private static final String PROPERTIES_PATH = "src/main/resources/path.properties";

    public PropertiesReader(String propertiesFilePath) throws IOException {
        properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            properties.load(input);
        }
    }

    public static String getProperty(String propertyName) {
        try {
            PropertiesReader settingsReader = new PropertiesReader(PROPERTIES_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return properties.getProperty(propertyName);
    }

}
