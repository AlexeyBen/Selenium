package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenPage {

    @FindBy(className = "orderby")
    public static WebElement sort_dropDown;

    @FindAll({@FindBy(xpath = "//ul[@class='products columns-4']/li")})
    public static List<WebElement> products;

    @FindAll({@FindBy(tagName = "bdi")})
    public static List<WebElement>  price;

    @FindBy(name = "add-to-cart")
    public static WebElement addToCart_btn;

    @FindBy(xpath = "//div[@class='quantity']/input")
    public static WebElement quantity_input;

}
