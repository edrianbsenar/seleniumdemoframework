package pageEvents;

import base.BaseTest;
import pageObjects.homePageElements;

public class homePageEvents extends BaseTest{

    public void Verify_that_home_page_is_visible_successfully(){
        logger.info("Verify that home page is visible successfully");
        assertElementIsDisplayed(homePageElements.navHome);

    }

}

