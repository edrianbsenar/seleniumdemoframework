package pageEvents;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.BaseTest;
import pageObjects.productsElements;

public class productsEvents extends BaseTest {

    public void verifyProductsPageVisible() {
        logger.info("Verify ALL PRODUCTS page is visible");
        assertElementIsDisplayed(productsElements.allProductsHeading);
    }

    public void verifyProductListVisible() {
        logger.info("Verify products list is visible");
        List<WebElement> products = ele.getXPATHWebElements(productsElements.productCard);
        assert products.size() > 0 : "Product list is not visible";
    }

    public void clickViewProduct(int index) {
        logger.info("Click View Product of product at index " + index);
        String viewProductLink = "(//a[contains(text(),'View Product')])[" + index + "]";
        click(viewProductLink);
    }

    public void searchProduct(String productName) {
        logger.info("Search product: " + productName);
        clear(productsElements.searchInput);
        sendKeys(productsElements.searchInput, productName);
        click(productsElements.searchButton);
    }

    public void verifySearchedProductsVisible() {
        logger.info("Verify SEARCHED PRODUCTS is visible");
        assertElementIsDisplayed(productsElements.searchedProductsHeading);
    }

    public void verifySearchedProductsContain(String keyword) {
        logger.info("Verify searched products contain: " + keyword);
        List<WebElement> productNames = ele.getXPATHWebElements(productsElements.productNames);
        for (WebElement name : productNames) {
            assert name.getText().toLowerCase().contains(keyword.toLowerCase()) :
                "Product '" + name.getText() + "' does not contain search keyword '" + keyword + "'";
        }
    }

    public void hoverAndAddToCart(int index) {
        logger.info("Add product at index " + index + " to cart");
        scrollToElement(productsElements.productCard);
        String addToCart = "(//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart'])[" + index + "]";
        scrollToElement(addToCart);
        click(addToCart);
    }

    public void clickContinueShopping() {
        logger.info("Click Continue Shopping button");
        click(productsElements.continueShoppingButton);
    }

    public void clickViewCart() {
        logger.info("Click View Cart button");
        click(productsElements.viewCartLink);
    }

}
