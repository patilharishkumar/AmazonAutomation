package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestException;
import utils.CommonUtils;

import java.util.List;


public class ShoppingCartPage extends CommonUtils {

  private final By DELETE_BUTTONS = By.cssSelector("input[value='Delete']");

  public void verifyOnShoppingCartPage() {
    String url = getCurrentURL();
    System.out.println("SHOPPING_CART_PAGE: Verifying that we are on SHOPPING_CART_PAGE.");
    if (!url.contains("cart")) {
      throw new TestException("ERROR: We are not on SHOPPING_CART_PAGE, current URL: " + url + "!");
    }
  }

  public void deleteAllItemsInCart() {
    List<WebElement> deleteButtons = getElements(DELETE_BUTTONS);
    for (WebElement button : deleteButtons) {
      button.click();
    }
  }

}
