

package actions;

import enums.Products;
import pages.*;
import pojo.Device;


public class AddtoCartActions {

    public void initializeLogin() {
        System.out.println("\n*** TEST_SUITE_BEGIN ***\n");
        System.out.println("INITIALIZING: Trying to sign out--maybe the session is open...");
        signOut();
    }


    public void signOut() {
        HomePage homePage = new HomePage();
        homePage.signOutWithSignOutLink();
    }

    public void navigateToHomePage() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
    }

    public void logInAs(String username, String password) {
        HomePage homePage = new HomePage();
        SignInPage signIn = new SignInPage();
        homePage.navigateToSignInPage();
        signIn.enterUsername(username);
        signIn.enterPassword(password);
        signIn.clickSignInButton();
    }

    public void prepareCart() {
        System.out.println("INITIALIZING: Preparing the shopping cart...");
        deleteAllItemsIfAnyFromCart();
    }

    public void deleteAllItemsIfAnyFromCart() {
        HomePage homePage = new HomePage();
        MyCartPage myCartPage = new MyCartPage();
        String itemsInCart = homePage.getNumberOfItemsListedInShoppingCartIcon();
        if (!itemsInCart.equals("0")) {
            homePage.selectShoppingCartIcon();
            myCartPage.verifyOnMyCartPage();
            System.out.println("*** Deleting the found item(s) out from the shopping cart. ***\n");
            myCartPage.deleteAllItemsInCart();
        } else {
            System.out.println("*** Nothing to delete - the shopping cart appears to be empty. ***\n");
        }
    }

    public Device loadProductPageDataIntoProductObject(Products product) {
        System.out.println("*** Loading information about " + product + ": ***");
        ProductPage productPage = new ProductPage();
        Device device = new Device();
        productPage.navigateToProductPage(product);
        productPage.verifyProductTitle(product.getProductTitle());
        device.loadInfoFromProductPage();
//        System.out.println(device);
        return device;
    }

    public void addProductToShoppingCartReview(Products product) {
        ShoppingCartReviewPage shoppingCartReviewPage = new ShoppingCartReviewPage();
        System.out.println("*** Adding " + product + " to the shopping cart: ***");
        ProductPage productPage = new ProductPage();
        productPage.navigateToProductPage(product);
        productPage.verifyProductTitle(product.getProductTitle());
        productPage.clickAddToCart();
        HomePage homepage=new HomePage();
        homepage.selectShoppingCartIcon();
        shoppingCartReviewPage.verifyOnShoppingCartReviewPage();
    }

    public boolean checkMatchingValues(String testHeading, Object actualValue, Object expectedValue) {
        String successMessage = "PASS: The expected and actual prices do match! :-)";
        String failureMessage = "FAIL: The expected and actual prices do not match! ;-(";
        boolean doesPriceMatch; // Default value is false

        System.out.println(testHeading);
        System.out.println("\t* The expected price is " + expectedValue);
        System.out.println("\t* The actual price is " + actualValue);

        if (actualValue.equals(expectedValue)) {
            System.out.println(successMessage);
            doesPriceMatch = true;
        } else {
            System.out.println(failureMessage);
            doesPriceMatch = false;
        }

        System.out.println("\n*** TEST_SUITE_END ***\n");

        return doesPriceMatch;
    }

}
