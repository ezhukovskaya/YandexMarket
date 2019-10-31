package ConfigRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilsRead {
    Properties prop = new Properties();

    public UtilsRead() throws IOException {
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
}
