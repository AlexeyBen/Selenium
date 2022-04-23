package Utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends CommonOps{

    public static void init()
    {
        homePage = PageFactory.initElements(driver,PageObjects.HomePage.class);
        mensPage = PageFactory.initElements(driver,PageObjects.MenPage.class);
        searchResultPage = PageFactory.initElements(driver,PageObjects.SearchResultPage.class);
    }
}
