package pageEvents;

import base.BaseTest;
import pageObjects.loginSignupElements;

public class loginSignupEvents extends BaseTest {

    public void verifySignupPageVisible() {
        logger.info("Verify New User Signup! is visible");
        assertElementIsDisplayed(loginSignupElements.signupHeading);
    }

    public void enterSignupName(String name) {
        logger.info("Enter name: " + name);
        sendKeys(loginSignupElements.signupName, name);
    }

    public void enterSignupEmail(String email) {
        logger.info("Enter email: " + email);
        sendKeys(loginSignupElements.signupEmail, email);
    }

    public void clickSignupButton() {
        logger.info("Click Signup button");
        click(loginSignupElements.signupButton);
    }

    public void signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

    public void verifyLoginPageVisible() {
        logger.info("Verify Login to your account is visible");
        assertElementIsDisplayed(loginSignupElements.loginHeading);
    }

    public void enterLoginEmail(String email) {
        logger.info("Enter login email: " + email);
        sendKeys(loginSignupElements.loginEmail, email);
    }

    public void enterLoginPassword(String password) {
        logger.info("Enter login password");
        sendKeys(loginSignupElements.loginPassword, password);
    }

    public void clickLoginButton() {
        logger.info("Click login button");
        click(loginSignupElements.loginButton);
    }

    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    public void verifyLoginError() {
        logger.info("Verify error message 'Your email or password is incorrect!'");
        assertElementIsDisplayed(loginSignupElements.loginError);
    }

    public void verifyAccountInfoVisible() {
        logger.info("Verify ENTER ACCOUNT INFORMATION is visible");
        assertElementIsDisplayed(loginSignupElements.accountInfoHeading);
    }

    public void selectTitleMr() {
        logger.info("Select title Mr");
        click(loginSignupElements.titleMr);
    }

    public void selectTitleMrs() {
        logger.info("Select title Mrs");
        click(loginSignupElements.titleMrs);
    }

    public void enterPassword(String password) {
        logger.info("Enter password");
        sendKeys(loginSignupElements.password, password);
    }

    public void selectDOB(String day, String month, String year) {
        logger.info("Select Date of Birth: " + day + "/" + month + "/" + year);
        selectElementByValue(loginSignupElements.days, day);
        selectElementByValue(loginSignupElements.months, month);
        selectElementByValue(loginSignupElements.years, year);
    }

    public void selectNewsletter() {
        logger.info("Select newsletter checkbox");
        click(loginSignupElements.newsletter);
    }

    public void selectOffers() {
        logger.info("Select offers checkbox");
        click(loginSignupElements.offers);
    }

    public void enterAddressDetails(String fName, String lName, String company, String addr1, String addr2, String country, String state, String city, String zip, String mobile) {
        logger.info("Fill address details");
        clear(loginSignupElements.firstName);
        sendKeys(loginSignupElements.firstName, fName);

        clear(loginSignupElements.lastName);
        sendKeys(loginSignupElements.lastName, lName);

        clear(loginSignupElements.company);
        sendKeys(loginSignupElements.company, company);

        clear(loginSignupElements.address1);
        sendKeys(loginSignupElements.address1, addr1);

        clear(loginSignupElements.address2);
        sendKeys(loginSignupElements.address2, addr2);

        selectElementByVisibleText(loginSignupElements.country, country);

        clear(loginSignupElements.state);
        sendKeys(loginSignupElements.state, state);

        clear(loginSignupElements.city);
        sendKeys(loginSignupElements.city, city);

        clear(loginSignupElements.zipcode);
        sendKeys(loginSignupElements.zipcode, zip);

        clear(loginSignupElements.mobileNumber);
        sendKeys(loginSignupElements.mobileNumber, mobile);
    }

    public void clickCreateAccount() {
        logger.info("Click Create Account button");
        click(loginSignupElements.createAccountButton);
    }

    public void verifyAccountCreated() {
        logger.info("Verify ACCOUNT CREATED! is visible");
        assertElementIsDisplayed(loginSignupElements.accountCreatedHeading);
    }

    public void verifyAccountDeleted() {
        logger.info("Verify ACCOUNT DELETED! is visible");
        assertElementIsDisplayed(loginSignupElements.accountDeletedHeading);
    }

    public void clickContinue() {
        logger.info("Click Continue button");
        click(loginSignupElements.continueButton);
    }

    public void verifyEmailAlreadyExist() {
        logger.info("Verify error 'Email Address already exist!'");
        assertElementIsDisplayed(loginSignupElements.emailAlreadyExistError);
    }

    public void completeRegistration(String name, String email, String password, String day, String month, String year,
                                      String fName, String lName, String company, String addr1, String addr2,
                                      String country, String state, String city, String zip, String mobile) {
        signup(name, email);
        verifyAccountInfoVisible();
        selectTitleMr();
        enterPassword(password);
        selectDOB(day, month, year);
        selectNewsletter();
        selectOffers();
        enterAddressDetails(fName, lName, company, addr1, addr2, country, state, city, zip, mobile);
        clickCreateAccount();
        verifyAccountCreated();
        clickContinue();
    }

}
