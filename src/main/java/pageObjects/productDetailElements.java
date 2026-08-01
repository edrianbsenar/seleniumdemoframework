package pageObjects;

public interface productDetailElements {

    String productName = "//div[@class='product-information']//h2";
    String productCategory = "//div[@class='product-information']//p[contains(text(),'Category')]";
    String productPrice = "//div[@class='product-information']//span[contains(text(),'Rs.')]";
    String productAvailability = "//div[@class='product-information']//b[contains(text(),'Availability')]";
    String productCondition = "//div[@class='product-information']//b[contains(text(),'Condition')]";
    String productBrand = "//div[@class='product-information']//b[contains(text(),'Brand')]";

    String quantityInput = "//input[@id='quantity']";
    String addToCartButton = "//button[contains(@class,'cart')]";

    String reviewHeading = "//a[contains(text(),'Write Your Review')]";
    String reviewName = "//input[@id='name']";
    String reviewEmail = "//input[@id='email']";
    String reviewTextarea = "//textarea[@id='review']";
    String reviewSubmitButton = "//button[@id='button-review']";
    String reviewSuccessMessage = "//div[@id='review-section']//div[contains(@class,'alert-success')]";

}
