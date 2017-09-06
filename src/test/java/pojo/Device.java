
package pojo;

import org.testng.TestException;
import pages.ProductPage;


public class Device {

  private String productTitle = "";
  private String productPrice="";
  private String productDealPrice = "";


  public Device() {
  }

  public void loadInfoFromProductPage() {
    ProductPage productPage = new ProductPage();
    String currentURL = productPage.getCurrentURL();
    if (!currentURL.contains("product")) {
      throw new TestException("LOAD_INFO ERROR: Product data should only be loaded from the [PRODUCT_PAGE]!\n" +
              "Current URL: " + currentURL + ".");
    } else {
      System.out.println("LOAD_INFO: Loading data from the Amazon...");
      this.productTitle = productPage.getProductTitle();
      this.productPrice = productPage.getProductPrice();
      this.productDealPrice = productPage.getProductDealPrice();
//      this.productPriceSaving = productPage.getProductPriceSaving();
    }
  }

  @Override
  public String toString() {
    return String.format(
            "\t* Product Title: " + this.productTitle + "\n"
                    + "\t* Product Price: " + this.productPrice + "\n"
                    + "\t* Product Deal Price: " + this.productDealPrice + "\n"
                  //  + "\t* Product Price Saving: " + this.productPriceSaving + "\n"
    );
  }


  public String getOfferPrice() {
    return productDealPrice;
  }

}
