package enums;


public enum Url {

  BASE_URL("http://www.amazon.com"),
  PRODUCT_SECTION("/gp/product"),
  SIGNOUT("/gp/flex/sign-out.html");

  String url;

  Url(String url) {
    this.url = url;
  }

  public String getURL() {
    return url;
  }

}

