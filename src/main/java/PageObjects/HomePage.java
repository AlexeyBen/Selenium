package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(linkText = "MEN")
    public static WebElement men_link;

    @FindBy(xpath = "//a[@aria-label='Search icon link']")
    public static WebElement search_icon;

    @FindBy(className = "search-field")
    public static WebElement search_input;

    @FindBy(linkText = "CONTACT US")
    public static WebElement contactUs_link;
}
