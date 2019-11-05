package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private static Properties prop = new Properties();
    private static PropertiesRead propertiesReadInstance = null;
    private String path = "src/test/java/resource/config.properties";

    /**
     * конструктор с определением конфиг файла
     */
    private PropertiesRead(){
        try{
            InputStream input = new FileInputStream(path);
            prop.load(input);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Инициализация Singleton
     * @return propertiesReadInstance
     */
    public static PropertiesRead getInstance(){
        if(propertiesReadInstance == null){
            propertiesReadInstance = new PropertiesRead();
        }
        return propertiesReadInstance;
    }

    /**
     * чтение параметров из config
     * @param key передаваемое название параметра
     * @return prop.getProperty(key)
     */
    public static String readFromPropertiesFile(String key) {
        return prop.getProperty(key);
    }
}
