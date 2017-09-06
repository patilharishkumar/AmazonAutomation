
package pages;

import org.openqa.selenium.By;
import org.testng.TestException;
import utils.CommonUtils;


public class ShoppingCartReviewPage extends CommonUtils {

  private final By PRICE = By.cssSelector("[class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']");

  public void verifyOnShoppingCartReviewPage() {
    String url = getCurrentURL();
    System.out.println("SHOPPING_CART_REVIEW_PAGE: Verifying that we are on SHOPPING_CART_REVIEW_PAGE...");
    if (!url.contains("view")) {
      throw new TestException("ERROR: We are not on SHOPPING_CART_REVIEW_PAGE, current URL: " + url + "!");
    }
  }

  public String getCartSubtotal() {
    return getElementText(PRICE);
  }

}
