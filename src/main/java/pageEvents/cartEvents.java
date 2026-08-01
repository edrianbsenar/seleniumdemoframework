package pageEvents;

import base.BaseTest;
import pageObjects.cartElements;

public class cartEvents extends BaseTest {

    public void verifyCartPageVisible() {
        logger.info("Verify cart page is displayed");
        assertElementIsDisplayed(cartElements.cartHeading);
    }

    public void verifyProductInCart(String productName) {
        logger.info("Verify product '" + productName + "' is in cart");
        assertTextIsDisplayed(cartElements.cartProductName, productName);
    }

    public void verifyCartNotEmpty() {
        logger.info("Verify cart is not empty");
        assertElementIsDisplayed(cartElements.cartItems);
    }

    public void verifyProductQuantity(String productName, String quantity) {
        logger.info("Verify quantity of '" + productName + "' is " + quantity);
        // Get the row containing the product and check its quantity
        String quantityXPath = "//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_quantity']";
        assertTextIsDisplayed(quantityXPath, quantity);
    }

    public void verifyPriceInCart(String productName) {
        logger.info("Verify price of '" + productName + "' is displayed");
        String priceXPath = "//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_price']";
        assertElementIsDisplayed(priceXPath);
    }

    public void verifyTotalPriceInCart(String productName) {
        logger.info("Verify total price of '" + productName + "' is displayed");
        String totalXPath = "//a[contains(text(),'" + productName + "')]/ancestor::tr//td[@class='cart_total']";
        assertElementIsDisplayed(totalXPath);
    }

    public void removeProductFromCart(String productName) {
        logger.info("Remove product '" + productName + "' from cart");
        String removeButton = "//a[contains(text(),'" + productName + "')]/ancestor::tr//a[@class='cart_quantity_delete']";
        click(removeButton);
    }

    public void removeProductByIndex(int index) {
        logger.info("Remove product at index " + index + " from cart");
        String removeButton = "(//a[@class='cart_quantity_delete'])[" + index + "]";
        click(removeButton);
    }

    public void verifyProductNotInCart(String productName) {
        logger.info("Verify product '" + productName + "' is NOT in cart");
        boolean isPresent = isElementPresent("//a[contains(text(),'" + productName + "')]");
        assert !isPresent : "Product '" + productName + "' is still present in cart";
    }

    public void clickProceedToCheckout() {
        logger.info("Click Proceed To Checkout button");
        click(cartElements.proceedToCheckoutButton);
    }

}
