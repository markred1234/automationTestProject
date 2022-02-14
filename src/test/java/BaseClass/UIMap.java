package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIMap {

    Properties properties;

    public UIMap(String filePath) {

        try {
            FileInputStream locator = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(locator);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getData(String valueName) {
        // Read value using the logical name as Key
        return properties.getProperty(valueName);
    }


}
