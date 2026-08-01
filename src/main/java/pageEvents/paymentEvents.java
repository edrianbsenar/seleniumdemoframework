package pageEvents;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.paymentElements;

public class paymentEvents extends BaseTest {

    public void enterNameOnCard(String name) {
        logger.info("Enter name on card: " + name);
        sendKeys(paymentElements.nameOnCard, name);
    }

    public void enterCardNumber(String number) {
        logger.info("Enter card number");
        sendKeys(paymentElements.cardNumber, number);
    }

    public void enterCVC(String cvc) {
        logger.info("Enter CVC: " + cvc);
        sendKeys(paymentElements.cvc, cvc);
    }

    public void enterExpiryMonth(String month) {
        logger.info("Enter expiry month: " + month);
        sendKeys(paymentElements.expiryMonth, month);
    }

    public void enterExpiryYear(String year) {
        logger.info("Enter expiry year: " + year);
        sendKeys(paymentElements.expiryYear, year);
    }

    public void clickPayButton() {
        logger.info("Click Pay and Confirm Order button");
        click(paymentElements.payButton);
    }

    public void verifyOrderSuccess() {
        logger.info("Verify order success message");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("/payment_done"));
        assertElementIsDisplayed(paymentElements.orderPlacedHeading);
    }

    public void clickDownloadInvoice() {
        logger.info("Click Download Invoice button");
        click(paymentElements.downloadInvoiceButton);
    }

    public void clickContinueAfterPayment() {
        logger.info("Click Continue button after payment");
        click(paymentElements.continueButtonAfterPayment);
    }

    public void enterPaymentDetails(String name, String number, String cvc, String month, String year) {
        enterNameOnCard(name);
        enterCardNumber(number);
        enterCVC(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);
    }

    public void payAndConfirm(String name, String number, String cvc, String month, String year) {
        enterPaymentDetails(name, number, cvc, month, year);
        clickPayButton();
        verifyOrderSuccess();
    }

}
