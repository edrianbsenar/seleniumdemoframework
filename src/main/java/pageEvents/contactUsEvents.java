package pageEvents;

import base.BaseTest;
import pageObjects.contactUsElements;

public class contactUsEvents extends BaseTest {

    public void verifyGetInTouchVisible() {
        logger.info("Verify GET IN TOUCH is visible");
        assertElementIsDisplayed(contactUsElements.getInTouchHeading);
    }

    public void enterName(String name) {
        logger.info("Enter name: " + name);
        sendKeys(contactUsElements.contactName, name);
    }

    public void enterEmail(String email) {
        logger.info("Enter email: " + email);
        sendKeys(contactUsElements.contactEmail, email);
    }

    public void enterSubject(String subject) {
        logger.info("Enter subject: " + subject);
        sendKeys(contactUsElements.contactSubject, subject);
    }

    public void enterMessage(String message) {
        logger.info("Enter message: " + message);
        sendKeys(contactUsElements.contactMessage, message);
    }

    public void uploadFile(String filePath) {
        logger.info("Upload file: " + filePath);
        uploadFile(contactUsElements.contactFileUpload, filePath);
    }

    public void clickSubmit() {
        logger.info("Click Submit button");
        click(contactUsElements.contactSubmitButton);
    }

    public void verifySuccessMessage() {
        logger.info("Verify success message 'Success! Your details have been submitted successfully.'");
        assertTextIsDisplayed(contactUsElements.contactSuccessMessage, "Success! Your details have been submitted successfully.");
    }

    public void clickSubmitAndAcceptAlert() {
        logger.info("Click Submit button");
        click(contactUsElements.contactSubmitButton);
        handleAlertAccept();
    }

    public void clickHomeButton() {
        logger.info("Click Home button");
        click(contactUsElements.contactHomeButton);
    }

    public void submitContactForm(String name, String email, String subject, String message) {
        enterName(name);
        enterEmail(email);
        enterSubject(subject);
        enterMessage(message);
        clickSubmit();
    }

}
