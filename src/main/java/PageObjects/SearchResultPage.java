package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage {
    @FindBy(xpath = "//h1[@class='page-title ast-archive-title']/span")
    public static WebElement searchResult_Title;

    @FindAll(@FindBy(xpath = "//h2[@class='entry-title']/a"))
    public static List<WebElement> results;

}
