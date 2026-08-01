package pageObjects;

public interface productsElements {

    String allProductsHeading = "//h2[contains(text(),'All Products')]";
    String productItems = "//div[@class='productinfo text-center']";
    String productImage = "//div[@class='productinfo text-center']//img";
    String viewProductLink = "//a[contains(text(),'View Product')]";

    String searchInput = "//input[@id='search_product']";
    String searchButton = "//button[@id='submit_search']";
    String searchedProductsHeading = "//h2[contains(text(),'Searched Products')]";

    String productCard = "//div[@class='productinfo text-center']";
    String addToCartButton = "//div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']";
    String continueShoppingButton = "//button[contains(text(),'Continue Shopping')]";
    String viewCartLink = "//u[contains(text(),'View Cart')]";

    String productNames = "//div[@class='productinfo text-center']//p";

}
