package pageEvents;

import base.BaseTest;
import pageObjects.checkoutElements;

public class checkoutEvents extends BaseTest {

    public void verifyAddressDetailsVisible() {
        logger.info("Verify Address Details is visible");
        assertElementIsDisplayed(checkoutElements.addressDetailsHeading);
    }

    public void verifyDeliveryAddressVisible() {
        logger.info("Verify delivery address is visible");
        assertElementIsDisplayed(checkoutElements.deliveryAddress);
    }

    public void verifyBillingAddressVisible() {
        logger.info("Verify billing address is visible");
        assertElementIsDisplayed(checkoutElements.billingAddress);
    }

    public void verifyOrderReviewVisible() {
        logger.info("Verify Review Your Order is visible");
        assertElementIsDisplayed(checkoutElements.orderReviewHeading);
    }

    public void verifyProductInOrderReview(String productName) {
        logger.info("Verify product '" + productName + "' in order review");
        assertTextIsDisplayed(checkoutElements.orderProductName, productName);
    }

    public void enterOrderComment(String comment) {
        logger.info("Enter order comment: " + comment);
        sendKeys(checkoutElements.orderComment, comment);
    }

    public void clickPlaceOrder() {
        logger.info("Click Place Order button");
        click(checkoutElements.placeOrderButton);
    }

    public void clickRegisterLogin() {
        logger.info("Click Register / Login button in checkout modal");
        waitForElement(checkoutElements.registerLoginButton, 10);
        click(checkoutElements.registerLoginButton);
    }

    public void verifyAddressMatchesRegistration(String addressText) {
        logger.info("Verify delivery address matches registration");
        assertElementIsDisplayed(checkoutElements.deliveryAddress);
    }

}
