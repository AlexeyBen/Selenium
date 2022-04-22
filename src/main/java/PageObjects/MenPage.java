package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenPage {

    @FindBy(name = "orderby")
    public static WebElement sort_dropDown;

    @FindAll({@FindBy(xpath = "//ul[@class='products columns-4']/li[2]")})
    public static List<WebElement> products;
}
