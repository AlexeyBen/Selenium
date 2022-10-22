package Extensions;

import Utilities.CommonOps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UIActions extends CommonOps {

    public static void  click (WebElement elem)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    public static void  input (WebElement elem , String Value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(Value);
    }

    public static void  inputKeys (WebElement elem , Keys key)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(key);
    }

    public static void  deleteInput (WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    public static void selectByVisibleText(WebElement we , String desiredText){
        wait.until(ExpectedConditions.elementToBeClickable(we));
        Select select = new Select(we);
        select.selectByVisibleText(desiredText);
    }


}
