package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import PageObjects.HomePage;
import PageObjects.MenPage;
import Utilities.CommonOps;

import java.util.Random;
import java.util.logging.Logger;

public class WebFlows extends CommonOps {
    static Logger log = Logger.getLogger("WebFlows");

    public static boolean navigateToMen() {
        boolean success = false;
        UIActions.click(HomePage.men_link);
        if (driver.getCurrentUrl().equals("https://atid.store/product-category/men/")) {
            success = true;
            log.info("Successfully navigated to Mens`s page");
        }
        return success;
    }

    public static boolean changeSorting(String selectBy) {
        boolean success = false;
        UIActions.selectByVisibleText(MenPage.sort_dropDown , selectBy);
        if (Verifications.verifySelect(MenPage.sort_dropDown , selectBy)) {
            success = true;
            log.info("Successfully changed the value of the dropdown");
        }
        return success;
    }

    public static boolean selectProduct(){
        boolean choseProduct = false;
        Random ran = new Random();
        // Purposely want it to be random (instead of choosing the same product
        // each test, it now can cover more products each time it runs)
        int productNum = ran.nextInt(10);
        UIActions.click(MenPage.products.get(productNum));
        if(driver.getCurrentUrl().contains("https://atid.store/product/")){
            choseProduct = true;
            log.info("product chosen successfully");
        }
        return choseProduct;
    }
}
