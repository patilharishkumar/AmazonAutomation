package pages;

import enums.Url;
import org.openqa.selenium.By;
import utils.CommonFunctions;


public class HomePage extends CommonFunctions {

  private final By YOUR_ACCOUNT = By.id("nav-link-accountList");
  private final By SHOPPING_CART_ICON = By.cssSelector("#nav-cart > span.nav-line-2");
  private final By SHOPPING_CART_COUNT = By.cssSelector(".nav-right #nav-tools #nav-cart #nav-cart-count");

  public HomePage() {
  }

  public void signOutWithSignOutLink() {
    String url = Url.BASE_URL.getURL() + Url.SIGNOUT.getURL();
    navigateToURL(url);
  }

  public void navigateToHomePage() {
    String url = Url.BASE_URL.getURL();
    System.out.println("INITIALIZING: Navigating to Amazon.com: " + url + "...\n");
    navigateToURL(url);
  }

  public void navigateToSignInPage() {
    System.out.println("HOME_PAGE: Selecting [YOUR_ACCOUNT] in navigation bar.");
    click(YOUR_ACCOUNT);
    System.out.println("HOME_PAGE: Navigating to the [SIGNIN_PAGE]...\n");
  }

  public String getNumberOfItemsListedInShoppingCartIcon() {
    return getElementText(SHOPPING_CART_COUNT);
  }

  public void selectShoppingCartIcon() {
    click(SHOPPING_CART_ICON);
  }

}
