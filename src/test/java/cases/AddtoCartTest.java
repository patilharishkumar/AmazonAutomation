package cases;

import actions.*;
import base.LoadCredentials;
import enums.Products;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ShoppingCartReviewPage;
import pojo.Device;
import utils.DriverUtils;

import static org.testng.Assert.assertEquals;


public class AddtoCartTest {

  public WebDriver driver;
  Products testDevice = Products.SAMSUNGMOBILEDEVICE;
  Products testDevice2 = Products.SONYMOBILEDEVICE;
  String username = LoadCredentials.user.getProperty("test.username");
  String password = LoadCredentials.user.getProperty("test.password");
  AddtoCartActions shoppingActions = new AddtoCartActions();
  ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();

  @BeforeClass
  public void setUp() {
    driver = DriverUtils.getDriver();
  }

  @Test(description="Launches the  Amazon site", priority = 1)
  public void testLaunchSite() {
    shoppingActions.initializeLogin();
    shoppingActions.navigateToHomePage();
  }

  @Test(description="Logs in", priority = 2)
  public void testLogIn() {
    shoppingActions.logInAs(username, password);
  }

  @Test(description = "Navigates to the shopping cart and makes sure it is empty", priority = 3)
  public void testInitializeShoppingCart() {
    shoppingActions.prepareCart();
  }

  @Test(description = "Adds one item to the shopping cart", priority = 4)
  public void testAddProductToShoppingCart() {
    shoppingActions.addProductToShoppingCartReview(testDevice);
    shoppingActions.addProductToShoppingCartReview(testDevice2);
  }

  @Test(description = "Compares the cart subtotal versus the item price", priority = 5)
  public void testVerifyPrices() {
    String actualCartSubtotalPrice = shoppingCartReviewPage.getCartSubtotal();
    System.out.println(actualCartSubtotalPrice);
    Device deviceProductPage = shoppingActions.loadProductPageDataIntoProductObject(testDevice);
    Device deviceProductPage2 = shoppingActions.loadProductPageDataIntoProductObject(testDevice2);
    String expectedDevicePrice = deviceProductPage.getOfferPrice();
    expectedDevicePrice = expectedDevicePrice.replaceAll("[^\\d.]","");
    String expectedDevicePrice2 = deviceProductPage2.getOfferPrice();
       expectedDevicePrice2 = expectedDevicePrice2.replaceAll("[^\\d.]","");
     System.out.println(expectedDevicePrice);
    System.out.println(expectedDevicePrice2);
      Long val=Long.parseLong(expectedDevicePrice.trim());
      System.out.println(val);
      Long val2= Long.parseLong(expectedDevicePrice2.trim());
      System.out.println(val2);
         Long finalExpectedDevicePrice=val+val2;
         System.out.println(finalExpectedDevicePrice);

   // Integer finalExpectedDevicePrice=Integer.parseInt(expectedDevicePrice)+Integer.parseInt(expectedDevicePrice);
     String totalExpectedPrice=Long.toString(finalExpectedDevicePrice);
    shoppingActions.checkMatchingValues("*** Verifying the actual price listed for the device: ***",
            actualCartSubtotalPrice, totalExpectedPrice);
    assertEquals(actualCartSubtotalPrice, totalExpectedPrice,
            "ERROR in SHOPPING_CART_REVIEW: The shopping cart subtotal is not what was expected!");
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

}

