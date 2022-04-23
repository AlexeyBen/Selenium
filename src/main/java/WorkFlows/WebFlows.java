package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import PageObjects.HomePage;
import PageObjects.MenPage;
import PageObjects.SearchResultPage;
import Utilities.CommonOps;
import org.openqa.selenium.Keys;

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
        UIActions.selectByVisibleText(MenPage.sort_dropDown, selectBy);
        if (Verifications.verifySelect(MenPage.sort_dropDown, selectBy)) {
            success = true;
            log.info("Successfully changed the value of the dropdown");
        }
        return success;
    }

    public static boolean search(String searchCriteria){
        boolean searchPerformed = false;
        int counter = 0;
        UIActions.click(HomePage.search_icon);
        UIActions.input(HomePage.search_input ,searchCriteria);
        UIActions.inputKeys(HomePage.search_input , Keys.ENTER);
        for(int i = 0; i < SearchResultPage.results.size(); i++){
            if (SearchResultPage.results.get(i).getText().contains(searchCriteria)){
                counter++;
            }
        }
        if (counter == SearchResultPage.results.size()){
            searchPerformed = true;
        }
        return searchPerformed;
    }

    public static boolean goToProduct() {
        boolean choseProduct = false;
        Random ran = new Random();
        // Purposely want it to be random (instead of choosing the same product each test,
        //  it now can cover more products each time it runs)
        int productNum = ran.nextInt(10);
        log.info("Chose product number " + productNum);
        UIActions.click(MenPage.products.get(productNum));
        if (driver.getCurrentUrl().contains("https://atid.store/product/")) {
            choseProduct = true;
            log.info("product chosen successfully");
        } else {
            log.info("the url is: " + driver.getCurrentUrl());
        }
        return choseProduct;
    }

    public static boolean addToCart() {
        boolean addedToCart = false;
        Random ran = new Random();
        int numOfProduct = ran.nextInt(3);
        double productPrice = getPrice(MenPage.price.get(2).getText());
        UIActions.deleteInput(MenPage.quantity_input);
        UIActions.input(MenPage.quantity_input, String.valueOf(numOfProduct));
        double cartValueBeforeAdding = getPrice(MenPage.price.get(1).getText());
        UIActions.click(MenPage.addToCart_btn);
        double cartValueAfterAdding = getPrice(MenPage.price.get(1).getText());
        if((productPrice * numOfProduct) + cartValueBeforeAdding == cartValueAfterAdding){
            addedToCart = true;
            log.info("the values of the cart equal, product added");
        } else {
            log.info("the values of the cart arent equal");
        }
        return addedToCart;
    }

    public static double getPrice(String toConvert) {
        return Double.parseDouble(toConvert);
    }
}
