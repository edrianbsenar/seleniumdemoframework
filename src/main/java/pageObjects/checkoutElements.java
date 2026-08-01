package pageObjects;

public interface checkoutElements {

    String addressDetailsHeading = "//h2[contains(text(),'Address Details')]";
    String deliveryAddress = "//ul[@id='address_delivery']";
    String billingAddress = "//ul[@id='address_invoice']";

    String orderReviewHeading = "//h2[contains(text(),'Review Your Order')]";
    String orderProductName = "//td[@class='cart_description']//a";
    String orderTotalPrice = "//td[@class='cart_total']";

    String orderComment = "//textarea[@class='form-control']";
    String placeOrderButton = "//a[contains(text(),'Place Order')]";

    String registerLoginButton = "//div[@id='checkoutModal']//a[contains(.,'Register')]";

}
