package pageEvents;

import base.BaseTest;
import pageObjects.productDetailElements;

public class productDetailEvents extends BaseTest {

    public void verifyProductDetailVisible() {
        logger.info("Verify product detail is visible");
        assertElementIsDisplayed(productDetailElements.productName);
    }

    public String getProductName() {
        logger.info("Get product name");
        return ele.getXPATHWebElement(productDetailElements.productName).getText();
    }

    public void verifyProductCategory() {
        logger.info("Verify product category is visible");
        assertElementIsDisplayed(productDetailElements.productCategory);
    }

    public void verifyProductPrice() {
        logger.info("Verify product price is visible");
        assertElementIsDisplayed(productDetailElements.productPrice);
    }

    public void verifyProductAvailability() {
        logger.info("Verify product availability is visible");
        assertElementIsDisplayed(productDetailElements.productAvailability);
    }

    public void verifyProductCondition() {
        logger.info("Verify product condition is visible");
        assertElementIsDisplayed(productDetailElements.productCondition);
    }

    public void verifyProductBrand() {
        logger.info("Verify product brand is visible");
        assertElementIsDisplayed(productDetailElements.productBrand);
    }

    public void verifyAllProductDetails() {
        verifyProductCategory();
        verifyProductPrice();
        verifyProductAvailability();
        verifyProductCondition();
        verifyProductBrand();
    }

    public void setQuantity(String quantity) {
        logger.info("Set quantity to " + quantity);
        clear(productDetailElements.quantityInput);
        sendKeys(productDetailElements.quantityInput, quantity);
    }

    public void clickAddToCart() {
        logger.info("Click Add to cart button");
        click(productDetailElements.addToCartButton);
    }

    public void verifyWriteYourReviewVisible() {
        logger.info("Verify Write Your Review is visible");
        assertElementIsDisplayed(productDetailElements.reviewHeading);
    }

    public void enterReviewName(String name) {
        logger.info("Enter review name: " + name);
        sendKeys(productDetailElements.reviewName, name);
    }

    public void enterReviewEmail(String email) {
        logger.info("Enter review email: " + email);
        sendKeys(productDetailElements.reviewEmail, email);
    }

    public void enterReview(String review) {
        logger.info("Enter review text");
        sendKeys(productDetailElements.reviewTextarea, review);
    }

    public void clickReviewSubmit() {
        logger.info("Click Submit review button");
        click(productDetailElements.reviewSubmitButton);
    }

    public void verifyReviewSuccess() {
        logger.info("Verify review success message 'Thank you for your review.'");
        assertTextIsDisplayed(productDetailElements.reviewSuccessMessage, "Thank you for your review.");
    }

    public void submitReview(String name, String email, String review) {
        enterReviewName(name);
        enterReviewEmail(email);
        enterReview(review);
        clickReviewSubmit();
        verifyReviewSuccess();
    }

}
