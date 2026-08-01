package pageObjects;

public interface loginSignupElements {

    String signupHeading = "//h2[contains(text(),'New User Signup!')]";
    String signupName = "//input[@data-qa='signup-name']";
    String signupEmail = "//input[@data-qa='signup-email']";
    String signupButton = "//button[@data-qa='signup-button']";

    String loginHeading = "//h2[contains(text(),'Login to your account')]";
    String loginEmail = "//input[@data-qa='login-email']";
    String loginPassword = "//input[@data-qa='login-password']";
    String loginButton = "//button[@data-qa='login-button']";
    String loginError = "//p[contains(text(),'Your email or password is incorrect!')]";

    String emailAlreadyExistError = "//p[contains(text(),'already exist')]";

    String accountInfoHeading = "//b[contains(text(),'Enter Account Information')]";

    String titleMr = "//input[@id='id_gender1']";
    String titleMrs = "//input[@id='id_gender2']";
    String password = "//input[@id='password']";
    String days = "//select[@id='days']";
    String months = "//select[@id='months']";
    String years = "//select[@id='years']";
    String newsletter = "//input[@id='newsletter']";
    String offers = "//input[@id='optin']";

    String firstName = "//input[@id='first_name']";
    String lastName = "//input[@id='last_name']";
    String company = "//input[@id='company']";
    String address1 = "//input[@id='address1']";
    String address2 = "//input[@id='address2']";
    String country = "//select[@id='country']";
    String state = "//input[@id='state']";
    String city = "//input[@id='city']";
    String zipcode = "//input[@id='zipcode']";
    String mobileNumber = "//input[@id='mobile_number']";
    String createAccountButton = "//button[@data-qa='create-account']";

    String accountCreatedHeading = "//b[contains(text(),'Account Created!')]";
    String accountDeletedHeading = "//b[contains(text(),'Account Deleted!')]";
    String continueButton = "//a[contains(text(),'Continue')]";

}
