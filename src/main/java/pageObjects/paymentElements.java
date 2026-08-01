package pageObjects;

public interface paymentElements {

    String nameOnCard = "//input[@data-qa='name-on-card']";
    String cardNumber = "//input[@data-qa='card-number']";
    String cvc = "//input[@data-qa='cvc']";
    String expiryMonth = "//input[@data-qa='expiry-month']";
    String expiryYear = "//input[@data-qa='expiry-year']";
    String payButton = "//button[@data-qa='pay-button']";

    String orderPlacedHeading = "//h2[@data-qa='order-placed']";
    String orderConfirmedText = "//p[contains(text(),'Your order has been confirmed')]";
    String downloadInvoiceButton = "//a[contains(@href,'download_invoice')]";
    String continueButtonAfterPayment = "//a[contains(text(),'Continue')]";

}
