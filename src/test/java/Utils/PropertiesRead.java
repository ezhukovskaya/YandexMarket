package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesRead {
    private Properties prop = new Properties();

    public PropertiesRead() throws IOException {
        InputStream input = new FileInputStream("config.properties");
        prop.load(input);
    }

    public String readBrowserFromPropertiesFile() throws IOException {
        return prop.getProperty("browser");
    }

    public String readLogFromPropertiesFile(){
        return prop.getProperty("login");
    }

    public String readPasswordFromPropertiesFile(){
        return prop.getProperty("password");
    }

    public String readPageNameFromPropertiesFile(){
        return prop.getProperty("page");
    }

    public String readFileRootFromPropertiesFile(){
        return prop.getProperty("file");
    }
}
