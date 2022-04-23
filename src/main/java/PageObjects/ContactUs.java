package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs {

    @FindBy(xpath = "//input[@placeholder='Name']")
    public static WebElement name_input;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    public static WebElement subject_input;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public static WebElement email_input;

    @FindBy(xpath = "//textarea[@placeholder='Message']")
    public static WebElement message_input;

    @FindBy(xpath = "//div[@class='elementor-shortcode']/div/p")
    public static WebElement afterSend_txt;


}
