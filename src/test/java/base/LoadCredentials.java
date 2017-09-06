package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LoadCredentials {

  public static Properties user = loadProperties("src/test/java/properties/userCredentials.properties");

  private static Properties loadProperties(String filePath) {
    Properties properties = new Properties();
    try {
      FileInputStream f = new FileInputStream(filePath);
      properties.load(f);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }

}
