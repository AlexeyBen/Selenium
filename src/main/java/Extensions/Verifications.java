package Extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Verifications {
    public static boolean verifySelect(WebElement we , String expected){
        boolean success = false;
        Select select =  new Select(we);
        String actualText = select.getFirstSelectedOption().getText();
        if(expected.equals(actualText)){
            success = true;
        }
        return success;
    }
}
