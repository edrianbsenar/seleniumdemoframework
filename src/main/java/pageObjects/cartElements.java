package pageObjects;

public interface cartElements {

    String cartHeading = "//li[contains(text(),'Shopping Cart')]";
    String cartItems = "//table[@id='cart_info_table']//tbody//tr";
    String cartProductName = "//td[@class='cart_description']//a";
    String cartPrice = "//td[@class='cart_price']";
    String cartQuantity = "//td[@class='cart_quantity']";
    String cartTotal = "//td[@class='cart_total']";
    String cartRemoveButton = "//a[contains(@class,'cart_quantity_delete')]";

    String proceedToCheckoutButton = "//a[contains(text(),'Proceed To Checkout')]";

}
