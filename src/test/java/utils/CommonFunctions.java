package utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.util.List;


public abstract class CommonFunctions {

  public static WebDriver driver;
  private static int timeout = 10;
  public WebDriverWait wait;
  public Actions actions;
  public Select select;

  public CommonFunctions() {
    driver = DriverSetup.getDriver();
  }

  public void navigateToURL(String URL) {
    try {
      driver.navigate().to(URL);
    } catch (Exception e) {
      System.out.println(String.format("FAILURE: URL %s did not load!", URL));
      throw new TestException(String.format("FAILURE: URL %s did not load!", URL));
    }
  }

 /* public void scrollToThenClick(By selector) {
    WebElement element = driver.findElement(selector);
    actions = new Actions(driver);
    try {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
        element);
      actions.moveToElement(element).perform();
      actions.click(element).perform();
    } catch (Exception e) {
      throw new TestException(String.format("ERROR: The following element is not clickable: [%s]!",
        element.toString()));
    }
  }
  */

  public void waitForElementToBeVisible(By selector) {
    try {
      wait = new WebDriverWait(driver, timeout);
      wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    } catch (Exception e) {
      throw new NoSuchElementException(String.format("ERROR: The following element is not visible: [%s]!",
        selector));
    }
  }

  public void sendKeys(By selector, String value) {
    WebElement element = getElement(selector);
    clearField(element);
    try {
      element.sendKeys(value);
    } catch (Exception e) {
      throw new TestException(String.format("ERROR: Error in sending [%s] to the following element: [%s]!",
        value, selector.toString()));
    }
  }

  public WebElement getElement(By selector) {
    try {
      return driver.findElement(selector);
    } catch (Exception e) {
      System.out.println(String.format("ERROR: Element [%s] does not exist - proceeding!",
        selector));
    }
    return null;
  }


  public void clearField(WebElement element) {
    try {
      element.clear();
      waitForElementTextToBeEmpty(element);
    } catch (Exception e) {
      System.out.print(String.format("ERROR: The following element could not be cleared: [%s]!",
        element.getText()));
    }
  }

  public void waitForElementTextToBeEmpty(WebElement element) {
    String text;
    try {
      text = element.getText();
      int maxRetries = 10;
      int retry = 0;
      while ((text.length() >= 1) || (retry < maxRetries)) {
        retry++;
        text = element.getText();
      }
    } catch (Exception e) {
      System.out.print(String.format("ERROR: The following element could not be cleared: [%s]!",
        element.getText()));
    }
  }


  public void click(By selector) {
    WebElement element = getElement(selector);
    waitForElementToBeClickable(selector);
    try {
      element.click();
    } catch (Exception e) {
      throw new TestException(String.format("ERROR: The following element is not clickable: [%s]!",
        selector));
    }
  }

  public void waitForElementToBeClickable(By selector) {
    try {
      wait = new WebDriverWait(driver, timeout);
      wait.until(ExpectedConditions.elementToBeClickable(selector));
    } catch (Exception e) {
      throw new TestException(String.format("ERROR: The following element is not clickable: [%s]!",
        selector));
    }
  }

  public String getElementText(By selector) {
    waitUntilElementIsDisplayedOnScreen(selector);
    try {
      return StringUtils.trim(driver.findElement(selector).getText());
    } catch (Exception e) {
      System.out.println(String.format("ERROR: Element [%s] does not exist - proceeding!",
        selector));
    }
    return null;
  }

  public void waitUntilElementIsDisplayedOnScreen(By selector) {
    try {
      wait = new WebDriverWait(driver, timeout);
      wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    } catch (Exception e) {
      throw new NoSuchElementException(String.format("ERROR: The following element is not visible: [%s]!",
        selector));
    }
  }

  public String getCurrentURL() {
    try {
      return driver.getCurrentUrl();
    } catch (Exception e) {
      throw new TestException(String.format("ERROR: Current URL is %s!",
        driver.getCurrentUrl()));
    }
  }

  public List<WebElement> getElements(By Selector) {
    waitForElementToBeVisible(Selector);
    try {
      return driver.findElements(Selector);
    } catch (Exception e) {
      throw new NoSuchElementException(String.format("ERROR: The following element did not display: [%s]!",
        Selector.toString()));
    }
  }

}
