package regression;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.homePageElements;
import pageEvents.homePageEvents;
import pageEvents.loginSignupEvents;
import pageEvents.productsEvents;
import pageEvents.productDetailEvents;
import pageEvents.cartEvents;
import pageEvents.checkoutEvents;
import pageEvents.paymentEvents;
import pageEvents.contactUsEvents;

public class AutomationExerciseTestCases extends BaseTest {

    String browser;
    String registeredEmail;
    String registeredPassword = "Password123";

    homePageEvents homePage = new homePageEvents();
    loginSignupEvents loginSignup = new loginSignupEvents();
    productsEvents products = new productsEvents();
    productDetailEvents productDetail = new productDetailEvents();
    cartEvents cart = new cartEvents();
    checkoutEvents checkout = new checkoutEvents();
    paymentEvents payment = new paymentEvents();
    contactUsEvents contactUs = new contactUsEvents();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome") String browser) {
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) {
        registeredEmail = "test" + generate4Digit() + "@mailinator.com";
        initializeBrowser(browser, testMethod);
    }

    // ==================== TEST CASE 1: Register User ====================
    @Test(priority = 1)
    public void tc_01_Register_User() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.verifySignupPageVisible();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.verifyAccountInfoVisible();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.selectNewsletter();
        loginSignup.selectOffers();
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.verifyLoggedInAs("Test User");
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 2: Login User with correct email and password ====================
    @Test(priority = 2)
    public void tc_02_Login_User_Correct_Credentials() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.verifyLoginPageVisible();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.clickLogout();
        homePage.clickSignupLogin();
        loginSignup.enterLoginEmail(registeredEmail);
        loginSignup.enterLoginPassword(registeredPassword);
        loginSignup.clickLoginButton();
        homePage.verifyLoggedInAsDisplayed();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
    }

    // ==================== TEST CASE 3: Login User with incorrect email and password ====================
    @Test(priority = 3)
    public void tc_03_Login_User_Incorrect_Credentials() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.verifyLoginPageVisible();
        loginSignup.enterLoginEmail("wrong@email.com");
        loginSignup.enterLoginPassword("wrongpassword");
        loginSignup.clickLoginButton();
        loginSignup.verifyLoginError();
    }

    // ==================== TEST CASE 4: Logout User ====================
    @Test(priority = 4)
    public void tc_04_Logout_User() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.verifyLoginPageVisible();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.clickLogout();
        homePage.clickSignupLogin();
        loginSignup.enterLoginEmail(registeredEmail);
        loginSignup.enterLoginPassword(registeredPassword);
        loginSignup.clickLoginButton();
        homePage.verifyLoggedInAsDisplayed();
        homePage.clickLogout();
        loginSignup.verifyLoginPageVisible();
    }

    // ==================== TEST CASE 5: Register User with existing email ====================
    @Test(priority = 5)
    public void tc_05_Register_User_Existing_Email() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.clickLogout();
        homePage.clickSignupLogin();
        loginSignup.verifySignupPageVisible();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.verifyEmailAlreadyExist();
    }

    // ==================== TEST CASE 6: Contact Us Form ====================
    @Test(priority = 6)
    public void tc_06_Contact_Us_Form() {
        homePage.verifyHomePageVisible();
        homePage.clickContactUs();
        contactUs.verifyGetInTouchVisible();
        contactUs.enterName("Test User");
        contactUs.enterEmail(registeredEmail);
        contactUs.enterSubject("Test Subject");
        contactUs.enterMessage("This is a test message for the contact form.");
        contactUs.uploadFile(System.getProperty("user.dir") + File.separator + "README.md");
        contactUs.clickSubmitAndAcceptAlert();
        contactUs.verifySuccessMessage();
        contactUs.clickHomeButton();
        homePage.verifyHomePageVisible();
    }

    // ==================== TEST CASE 7: Verify Test Cases Page ====================
    @Test(priority = 7)
    public void tc_07_Verify_Test_Cases_Page() {
        homePage.verifyHomePageVisible();
        homePage.clickTestCases();
        assertTextIsDisplayed("//b[contains(text(),'Test Cases')]", "Test Cases");
    }

    // ==================== TEST CASE 8: Verify All Products and product detail page ====================
    @Test(priority = 8)
    public void tc_08_Verify_All_Products_And_Detail_Page() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.verifyProductListVisible();
        products.clickViewProduct(1);
        productDetail.verifyProductDetailVisible();
        productDetail.verifyProductCategory();
        productDetail.verifyProductPrice();
        productDetail.verifyProductAvailability();
        productDetail.verifyProductCondition();
        productDetail.verifyProductBrand();
    }

    // ==================== TEST CASE 9: Search Product ====================
    @Test(priority = 9)
    public void tc_09_Search_Product() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.searchProduct("blue");
        products.verifySearchedProductsVisible();
        products.verifySearchedProductsContain("blue");
    }

    // ==================== TEST CASE 10: Verify Subscription in home page ====================
    @Test(priority = 10)
    public void tc_10_Verify_Subscription_Home_Page() {
        homePage.verifyHomePageVisible();
        homePage.scrollDownToFooter();
        homePage.verifySubscriptionVisible();
        homePage.enterSubscriptionEmail("test@mailinator.com");
        homePage.clickSubscribeButton();
        homePage.verifySubscriptionSuccess();
    }

    // ==================== TEST CASE 11: Verify Subscription in Cart page ====================
    @Test(priority = 11)
    public void tc_11_Verify_Subscription_Cart_Page() {
        homePage.verifyHomePageVisible();
        homePage.clickCart();
        homePage.scrollDownToFooter();
        homePage.verifySubscriptionVisible();
        homePage.enterSubscriptionEmail("test@mailinator.com");
        homePage.clickSubscribeButton();
        homePage.verifySubscriptionSuccess();
    }

    // ==================== TEST CASE 12: Add Products in Cart ====================
    @Test(priority = 12)
    public void tc_12_Add_Products_In_Cart() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.hoverAndAddToCart(2);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.verifyCartNotEmpty();
        cart.verifyPriceInCart("Blue Top");
        cart.verifyTotalPriceInCart("Blue Top");
    }

    // ==================== TEST CASE 13: Verify Product quantity in Cart ====================
    @Test(priority = 13)
    public void tc_13_Verify_Product_Quantity_In_Cart() {
        homePage.verifyHomePageVisible();
        products.clickViewProduct(1);
        productDetail.verifyProductDetailVisible();
        productDetail.setQuantity("4");
        productDetail.clickAddToCart();
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.verifyCartNotEmpty();
    }

    // ==================== TEST CASE 14: Place Order: Register while Checkout ====================
    @Test(priority = 14)
    public void tc_14_Place_Order_Register_While_Checkout() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.hoverAndAddToCart(2);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.clickProceedToCheckout();
        checkout.clickRegisterLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.selectNewsletter();
        loginSignup.selectOffers();
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.verifyLoggedInAs("Test User");
        homePage.clickCart();
        cart.clickProceedToCheckout();
        checkout.verifyAddressDetailsVisible();
        checkout.verifyOrderReviewVisible();
        checkout.enterOrderComment("Test order comment");
        checkout.clickPlaceOrder();
        payment.enterNameOnCard("Test User");
        payment.enterCardNumber("4111111111111111");
        payment.enterCVC("123");
        payment.enterExpiryMonth("12");
        payment.enterExpiryYear("2030");
        payment.clickPayButton();
        payment.verifyOrderSuccess();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 15: Place Order: Register before Checkout ====================
    @Test(priority = 15)
    public void tc_15_Place_Order_Register_Before_Checkout() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.selectNewsletter();
        loginSignup.selectOffers();
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.verifyLoggedInAs("Test User");
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.hoverAndAddToCart(2);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.clickProceedToCheckout();
        checkout.verifyAddressDetailsVisible();
        checkout.verifyOrderReviewVisible();
        checkout.enterOrderComment("Test order comment");
        checkout.clickPlaceOrder();
        payment.enterNameOnCard("Test User");
        payment.enterCardNumber("4111111111111111");
        payment.enterCVC("123");
        payment.enterExpiryMonth("12");
        payment.enterExpiryYear("2030");
        payment.clickPayButton();
        payment.verifyOrderSuccess();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 16: Place Order: Login before Checkout ====================
    @Test(priority = 16)
    public void tc_16_Place_Order_Login_Before_Checkout() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.clickLogout();
        homePage.clickSignupLogin();
        loginSignup.enterLoginEmail(registeredEmail);
        loginSignup.enterLoginPassword(registeredPassword);
        loginSignup.clickLoginButton();
        homePage.verifyLoggedInAsDisplayed();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.hoverAndAddToCart(2);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.clickProceedToCheckout();
        checkout.verifyAddressDetailsVisible();
        checkout.verifyOrderReviewVisible();
        checkout.enterOrderComment("Test order comment");
        checkout.clickPlaceOrder();
        payment.enterNameOnCard("Test User");
        payment.enterCardNumber("4111111111111111");
        payment.enterCVC("123");
        payment.enterExpiryMonth("12");
        payment.enterExpiryYear("2030");
        payment.clickPayButton();
        payment.verifyOrderSuccess();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 17: Remove Products From Cart ====================
    @Test(priority = 17)
    public void tc_17_Remove_Products_From_Cart() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.hoverAndAddToCart(2);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.removeProductByIndex(2);
        cart.verifyCartNotEmpty();
    }

    // ==================== TEST CASE 18: View Category Products ====================
    @Test(priority = 18)
    public void tc_18_View_Category_Products() {
        homePage.verifyCategoriesVisible();
        homePage.clickWomenCategory();
        homePage.clickDressSubCategory();
        assertTextIsDisplayed("//h2[contains(text(),'Women')]", "Dress");
        homePage.clickMenCategory();
        homePage.clickTshirtsSubCategory();
        assertElementIsDisplayed("//h2[contains(text(),'Men')]");
    }

    // ==================== TEST CASE 19: View & Cart Brand Products ====================
    @Test(priority = 19)
    public void tc_19_View_Cart_Brand_Products() {
        homePage.clickProducts();
        assertElementIsDisplayed(homePageElements.brandSidebar);
        String firstBrand = "(//div[@class='brands-name']//a)[1]";
        click(firstBrand);
        assertElementIsDisplayed("//h2[contains(text(),'Brand')]");
        String secondBrand = "(//div[@class='brands-name']//a)[3]";
        click(secondBrand);
        assertElementIsDisplayed("//h2[contains(text(),'Brand')]");
    }

    // ==================== TEST CASE 20: Search Products and Verify Cart After Login ====================
    @Test(priority = 20)
    public void tc_20_Search_Products_Verify_Cart_After_Login() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.searchProduct("blue");
        products.verifySearchedProductsVisible();
        products.verifySearchedProductsContain("blue");
        products.hoverAndAddToCart(1);
        products.clickContinueShopping();
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.verifyCartNotEmpty();
        homePage.clickSignupLogin();
        loginSignup.enterLoginEmail(registeredEmail);
        loginSignup.enterLoginPassword(registeredPassword);
        loginSignup.clickLoginButton();
        homePage.clickCart();
        cart.verifyCartPageVisible();
        cart.verifyCartNotEmpty();
    }

    // ==================== TEST CASE 21: Add review on product ====================
    @Test(priority = 21)
    public void tc_21_Add_Review_On_Product() {
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.clickViewProduct(1);
        productDetail.verifyWriteYourReviewVisible();
        productDetail.enterReviewName("Test User");
        productDetail.enterReviewEmail("test@mailinator.com");
        productDetail.enterReview("Great product! Would buy again.");
        productDetail.clickReviewSubmit();
        productDetail.verifyReviewSuccess();
    }

    // ==================== TEST CASE 22: Add to cart from Recommended items ====================
    @Test(priority = 22)
    public void tc_22_Add_To_Cart_From_Recommended_Items() {
        homePage.verifyHomePageVisible();
        homePage.scrollToBottomSlow();
        homePage.verifySubscriptionVisible();
        String recommendedAddToCart = "(//div[contains(@class,'recommended_items')]//a[contains(@class,'add-to-cart')])[1]";
        if (isElementPresent(recommendedAddToCart)) {
            click(recommendedAddToCart);
            products.clickViewCart();
            cart.verifyCartPageVisible();
            cart.verifyCartNotEmpty();
        }
    }

    // ==================== TEST CASE 23: Verify address details in checkout page ====================
    @Test(priority = 23)
    public void tc_23_Verify_Address_Details_In_Checkout() {
        homePage.verifyHomePageVisible();
        homePage.clickSignupLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.selectNewsletter();
        loginSignup.selectOffers();
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.verifyLoggedInAs("Test User");
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.clickProceedToCheckout();
        checkout.verifyDeliveryAddressVisible();
        checkout.verifyBillingAddressVisible();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 24: Download Invoice after purchase order ====================
    @Test(priority = 24)
    public void tc_24_Download_Invoice_After_Purchase() {
        homePage.verifyHomePageVisible();
        homePage.clickProducts();
        products.verifyProductsPageVisible();
        products.hoverAndAddToCart(1);
        products.clickViewCart();
        cart.verifyCartPageVisible();
        cart.clickProceedToCheckout();
        checkout.clickRegisterLogin();
        loginSignup.enterSignupName("Test User");
        loginSignup.enterSignupEmail(registeredEmail);
        loginSignup.clickSignupButton();
        loginSignup.selectTitleMr();
        loginSignup.enterPassword(registeredPassword);
        loginSignup.selectDOB("1", "1", "1995");
        loginSignup.selectNewsletter();
        loginSignup.selectOffers();
        loginSignup.enterAddressDetails("Test", "User", "TestCo", "123 Test St", "Apt 1", "India", "Maharashtra", "Mumbai", "400001", "9876543210");
        loginSignup.clickCreateAccount();
        loginSignup.verifyAccountCreated();
        loginSignup.clickContinue();
        homePage.verifyLoggedInAs("Test User");
        homePage.clickCart();
        cart.clickProceedToCheckout();
        checkout.verifyAddressDetailsVisible();
        checkout.verifyOrderReviewVisible();
        checkout.enterOrderComment("Test order comment");
        checkout.clickPlaceOrder();
        payment.enterNameOnCard("Test User");
        payment.enterCardNumber("4111111111111111");
        payment.enterCVC("123");
        payment.enterExpiryMonth("12");
        payment.enterExpiryYear("2030");
        payment.clickPayButton();
        payment.verifyOrderSuccess();
        payment.clickDownloadInvoice();
        payment.clickContinueAfterPayment();
        homePage.clickDeleteAccount();
        loginSignup.verifyAccountDeleted();
        loginSignup.clickContinue();
    }

    // ==================== TEST CASE 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality ====================
    @Test(priority = 25)
    public void tc_25_Verify_Scroll_Up_With_Arrow_Button() {
        homePage.verifyHomePageVisible();
        homePage.scrollDownToFooter();
        homePage.verifySubscriptionVisible();
        homePage.clickScrollUpArrow();
        homePage.verifyHeroBannerTextVisible();
    }

    @Test(priority = 26)
    public void tc_26_Verify_Scroll_Up_Without_Arrow_Button() {
        homePage.verifyHomePageVisible();
        homePage.scrollDownToFooter();
        homePage.verifySubscriptionVisible();
        homePage.scrollToTopSlow();
        homePage.verifyHeroBannerTextVisible();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }

}
