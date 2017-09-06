
package enums;


public enum Products {

    SAMSUNGMOBILEDEVICE("B06Y14T5YW", "Samsung Galaxy S8 Unlocked 64GB - US Version (Midnight Black)"),
    SONYMOBILEDEVICE("B01FJT7N4W","Sony Xperia X unlocked smartphone,32GB Black (US Warranty)");


    // The price will always fluctuate, while the product ID and the product title will be, suppose, constant.
    private String id;
    private String productTitle;

    Products(String id, String productTitle) {
        this.id = id;
        this.productTitle = productTitle;
    }

    public String getProductId() {
        return id;
    }

    public String getProductTitle() {
        return productTitle;
    }

}
