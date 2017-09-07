
package pages;

import enums.Products;
import enums.Url;
import org.openqa.selenium.By;
import org.testng.TestException;
import utils.CommonFunctions;


public class ProductPage extends CommonFunctions {

  private final By PRODUCT_TITLE = By.cssSelector("#productTitle");
  private final By PRODUCT_PRICE = By.cssSelector(".a-span12.a-color-secondary.a-size-base .a-text-strike");
  private final By PRODUCT_DEAL_PRICE=By.cssSelector("#priceblock_ourprice");
  //private final By PRODUCT_DEAL_PRICE_SAVING=By.cssSelector("#dealprice_savings .a-span12.a-color-price.a-size-base");
  private final By ADD_TO_CART = By.cssSelector("#add-to-cart-button");
  private final By CLOSE_POPUP=By.cssSelector("#siNoCoverage-announce");

  public void navigateToProductPage(Products product) {
    String url = Url.BASE_URL.getURL() + Url.PRODUCT_SECTION.getURL() + "/" + product.getProductId();
    System.out.println("PRODUCT_PAGE: Navigating to " + url + "...");
    navigateToURL(url);
  }

  public void verifyProductTitle(String expectedTitle) {
    String actualTitle = getProductTitle();
    System.out.println("PRODUCT_PAGE: Verifying that the product title is '" + expectedTitle + "'...");
    if (!actualTitle.equals(expectedTitle)) {
      throw new TestException("ERROR in PRODUCT_PAGE: The actual product title is '" +
              actualTitle + "', while expected '" + expectedTitle + "'!");
    }
  }

  public void clickAddToCart() {
    System.out.println("PRODUCT_PAGE: Clicking on [ADD_TO_CART] button.\n");
    click(ADD_TO_CART);
   // if(driver.findElements(By.id("siNoCoverage-announce")).size()!=0){
      click(CLOSE_POPUP);
  //  }

      //click(CLOSE_POPUP);


  }

  public String getProductTitle() {
    return getElementText(PRODUCT_TITLE);
  }

  public String getProductPrice() {
    return getElementText(PRODUCT_PRICE);
  }

  public String getProductDealPrice() {
    return getElementText(PRODUCT_DEAL_PRICE);
  }

 // public String getProductPriceSaving() {
   // return getElementText(PRODUCT_DEAL_PRICE_SAVING);
  //}

}
