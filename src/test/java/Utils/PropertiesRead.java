package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private Properties prop = new Properties();

    /**
     * конструктор с определением конфиг файла
     * @throws IOException
     */
    public PropertiesRead() throws IOException {
        InputStream input = new FileInputStream("src/test/java/Resource/config.properties");
        prop.load(input);
    }

    /**
     * чтение названия браузера
     * @return название браузера
     * @throws IOException
     */
    public String readBrowserFromPropertiesFile() throws IOException {
        return prop.getProperty("browser");
    }

    /**
     * чтение логина
     * @return логин
     */
    public String readLogFromPropertiesFile(){
        return prop.getProperty("login");
    }

    /**
     * чтение пароля
     * @return пароль
     */
    public String readPasswordFromPropertiesFile(){
        return prop.getProperty("password");
    }

    /**
     * чтение адреса веб-страницы
     * @return адрес веб-страницы
     */
    public String readPageNameFromPropertiesFile(){
        return prop.getProperty("page");
    }

    /**
     * чтение адреса csv файла
     * @return адрес csv файла
     */
    public String readFileRootFromPropertiesFile(){
        return prop.getProperty("file");
    }
}
