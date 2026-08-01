package pageObjects;

public interface contactUsElements {

    String getInTouchHeading = "//h2[contains(text(),'Get In Touch')]";
    String contactName = "//input[@data-qa='name']";
    String contactEmail = "//input[@data-qa='email']";
    String contactSubject = "//input[@data-qa='subject']";
    String contactMessage = "//textarea[@data-qa='message']";
    String contactFileUpload = "//input[@name='upload_file']";
    String contactSubmitButton = "//input[@data-qa='submit-button']";
    String contactSuccessMessage = "//div[contains(@class,'alert-success')]";
    String contactHomeButton = "//a[contains(text(),'Home')]";

}
