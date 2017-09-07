package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestException;
import utils.CommonFunctions;
import java.util.concurrent.TimeUnit;

import java.util.List;


public class MyCartPage extends CommonFunctions {

  private final By DELETE_BUTTONS = By.cssSelector("input[value='Delete']");

  public void verifyOnMyCartPage() {
    String url = getCurrentURL();
    System.out.println("SHOPPING_CART_PAGE: Verifying that we are on MY_CART_PAGE.");
    if (!url.contains("cart")) {
      throw new TestException("ERROR: We are not on MY_CART_PAGE, current URL: " + url + "!");
    }
  }

  public void deleteAllItemsInCart() {
    List<WebElement> deleteButtons = getElements(DELETE_BUTTONS);

    System.out.println("size of delete button"+deleteButtons.size());
    for (WebElement button : deleteButtons) {
     button.click();
     driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    }

   // for(int i=0;i<deleteButtons.size();i++){
    //  click(DELETE_BUTTONS);
   //   driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
   // }

  }

}
