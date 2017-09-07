package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class DriverSetup {

  public static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      System.setProperty("webdriver.chrome.driver", "/Users/devlogic/chromedriver");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--kiosk"); // UNIX
      options.addArguments("--start-maximized"); // Windows
      driver = new ChromeDriver(options);
    }
    return driver;
  }

  @BeforeSuite(alwaysRun = true)
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/Users/devlogic/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk"); // UNIX
    options.addArguments("--start-maximized"); // Windows
    driver = new ChromeDriver(options);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.close();
    driver.quit();
  }

}
