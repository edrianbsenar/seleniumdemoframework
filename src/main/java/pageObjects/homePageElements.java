package pageObjects;

public interface homePageElements {

    String navLogo = "//div[@class='logo pull-left']";
    String navSignupLogin = "//a[contains(text(),'Signup / Login')]";
    String navProducts = "//a[contains(text(),'Products')]";
    String navCart = "//a[contains(text(),'Cart')]";
    String navContactUs = "//a[contains(text(),'Contact us')]";
    String navTestCases = "//a[contains(text(),'Test Cases')]";
    String navDeleteAccount = "//a[contains(text(),'Delete Account')]";
    String navLogout = "//a[contains(text(),'Logout')]";
    String navLoggedInAs = "//a[contains(text(),'Logged in as')]";

    String heroSlider = "//div[@id='slider-carousel']";
    String heroBannerText = "//h2[contains(text(),'Full-Fledged practice website')]";

    String categoryWomen = "//a[@href='#Women']";
    String categoryMen = "//a[@href='#Men']";
    String categoryKids = "//a[@href='#Kids']";
    String categoryDress = "//a[@href='/category_products/1']";
    String categoryTshirts = "//a[@href='/category_products/3']";

    String brandSidebar = "//h2[contains(text(),'Brands')]";

    String recommendedItems = "//h2[contains(text(),'recommended items')]";

    String subscriptionFooter = "//h2[contains(text(),'Subscription')]";
    String subscriptionEmail = "//input[@id='susbscribe_email']";
    String subscriptionButton = "//button[@id='subscribe']";
    String subscriptionSuccess = "//div[contains(@class,'alert-success')]";

    String scrollUpArrow = "//a[@id='scrollUp']";

    String footerSection = "//footer";

}
