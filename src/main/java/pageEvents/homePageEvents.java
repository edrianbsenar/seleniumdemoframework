package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest {

    public void verifyHomePageVisible() {
        logger.info("Verify home page is visible successfully");
        waitForElement(homePageElements.heroSlider, 10);
    }

    public void clickSignupLogin() {
        logger.info("Click on Signup / Login button");
        click(homePageElements.navSignupLogin);
    }

    public void clickProducts() {
        logger.info("Click on Products button");
        click(homePageElements.navProducts);
    }

    public void clickCart() {
        logger.info("Click on Cart button");
        click(homePageElements.navCart);
    }

    public void clickContactUs() {
        logger.info("Click on Contact Us button");
        click(homePageElements.navContactUs);
    }

    public void clickTestCases() {
        logger.info("Click on Test Cases button");
        click(homePageElements.navTestCases);
    }

    public void clickDeleteAccount() {
        logger.info("Click on Delete Account button");
        click(homePageElements.navDeleteAccount);
    }

    public void clickLogout() {
        logger.info("Click on Logout button");
        click(homePageElements.navLogout);
    }

    public void verifyLoggedInAs(String username) {
        logger.info("Verify Logged in as " + username);
        assertTextIsDisplayed(homePageElements.navLoggedInAs, username);
    }

    public void verifyLoggedInAsDisplayed() {
        logger.info("Verify Logged in as username is visible");
        assertElementIsDisplayed(homePageElements.navLoggedInAs);
    }

    public void scrollDownToFooter() {
        logger.info("Scroll down to footer");
        scrollToBottom();
    }

    public void verifySubscriptionVisible() {
        logger.info("Verify SUBSCRIPTION is visible");
        assertElementIsDisplayed(homePageElements.subscriptionFooter);
    }

    public void enterSubscriptionEmail(String email) {
        logger.info("Enter email in subscription field");
        clear(homePageElements.subscriptionEmail);
        sendKeys(homePageElements.subscriptionEmail, email);
    }

    public void clickSubscribeButton() {
        logger.info("Click subscribe arrow button");
        click(homePageElements.subscriptionButton);
    }

    public void verifySubscriptionSuccess() {
        logger.info("Verify subscription success message");
        assertTextIsDisplayed(homePageElements.subscriptionSuccess, "You have been successfully subscribed!");
    }

    public void clickScrollUpArrow() {
        logger.info("Click scroll up arrow");
        click(homePageElements.scrollUpArrow);
    }

    public void verifyHeroBannerTextVisible() {
        logger.info("Verify Full-Fledged practice website text is visible");
        assertTextIsDisplayed(homePageElements.heroBannerText, "Full-Fledged practice website");
    }

    public void scrollToBottomSlow() {
        logger.info("Scroll down page to bottom");
        scrollToBottom();
    }

    public void scrollToTopSlow() {
        logger.info("Scroll up page to top");
        scrollToTop();
    }

    public void verifyCategoriesVisible() {
        logger.info("Verify categories are visible on left side bar");
        assertElementIsDisplayed(homePageElements.categoryWomen);
    }

    public void clickWomenCategory() {
        logger.info("Click on Women category");
        click(homePageElements.categoryWomen);
    }

    public void clickMenCategory() {
        logger.info("Click on Men category");
        click(homePageElements.categoryMen);
    }

    public void clickDressSubCategory() {
        logger.info("Click on Dress sub-category");
        click(homePageElements.categoryDress);
    }

    public void clickTshirtsSubCategory() {
        logger.info("Click on Tshirts sub-category");
        click(homePageElements.categoryTshirts);
    }

    public void clickRecommendedAddToCart() {
        logger.info("Click Add To Cart on Recommended product");
        scrollToElement(homePageElements.recommendedItems);
        // The recommended items carousel has add to cart buttons
        String addToCartButton = "(//div[contains(@class,'recommended-items')]//div[@class='productinfo text-center']//button)[1]";
        click(addToCartButton);
    }

    public void clickViewCartFromRecommended() {
        logger.info("Click View Cart button");
        click(homePageElements.navCart);
    }

}
