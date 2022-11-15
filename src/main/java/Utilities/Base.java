package Utilities;

import PageObjects.ContactUs;
import PageObjects.HomePage;
import PageObjects.MenPage;
import PageObjects.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;


    public static HomePage homePage;
    public static MenPage mensPage;
    public static SearchResultPage searchResultPage;
    public static ContactUs contactUs;

}