package Utilities;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;


    public static HomePage homePage;
}
