package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import PageObjects.ContactUs;
import PageObjects.HomePage;
import PageObjects.MenPage;
import PageObjects.SearchResultPage;
import Utilities.CommonOps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        } else {
            log.info("couldn't navigate to desired page");
        }
        return success;
    }

    public static boolean changeSorting(String selectBy) {
        boolean success = false;
        UIActions.selectByVisibleText(MenPage.sort_dropDown, selectBy);
        if (Verifications.verifySelect(MenPage.sort_dropDown, selectBy)) {
            success = true;
            log.info("Successfully changed the value of the dropdown");
        } else {
            log.info("Couldn't change the sorting value");
        }
        return success;
    }

    public static boolean search(String searchCriteria) {
        boolean searchPerformed = false;
        int counter = 0;
        UIActions.click(HomePage.search_icon);
        UIActions.input(HomePage.search_input, searchCriteria);
        UIActions.inputKeys(HomePage.search_input, Keys.ENTER);
        int relevantSearchElements = SearchResultPage.results.size() - 3;
        for (int i = 0; i < relevantSearchElements; i++) {
            if (SearchResultPage.results.get(i).getText().contains(searchCriteria)) {
                log.info(i + 1 + "th search result contains the search criteria");
                counter++;
            }
        }
        if (counter == relevantSearchElements) {
            searchPerformed = true;
            log.info("All the results contained the search criteria");
        } else {
            log.info("only " + counter + " out of " + relevantSearchElements + " contained the search criteria");
        }
        return searchPerformed;
    }

    public static boolean goToProductPage() {
        boolean choseProduct = false;
        Random ran = new Random();
        // Purposely want it to be random (instead of choosing the same product each test,
        //  it now can cover more products each time it runs)
        int productNum = ran.nextInt(10);
        log.info("product number " + productNum + " is chosen");
        UIActions.click(MenPage.products.get(productNum));
        if (driver.getCurrentUrl().contains("https://atid.store/product/")) {
            choseProduct = true;
            log.info("product added successfully to the cart");
        } else {
            log.info("the url is: " + driver.getCurrentUrl());
        }
        return choseProduct;
    }

    public static boolean addToCart() {
        boolean addedToCart = false;
        Random ran = new Random();
        int numOfProduct = ran.nextInt(4);
        log.info("the chosen number of product is " + numOfProduct);
        double productPrice = getPrice(MenPage.price.get(1).getText());
        UIActions.deleteInput(MenPage.quantity_input);
        UIActions.input(MenPage.quantity_input, String.valueOf(numOfProduct));
        double cartValueBeforeAdding = getPrice(MenPage.price.get(0).getText());
        UIActions.click(MenPage.addToCart_btn);
        double cartValueAfterAdding = getPrice(MenPage.price.get(0).getText());
        if ((productPrice * numOfProduct) + cartValueBeforeAdding == cartValueAfterAdding) {
            addedToCart = true;
            log.info("the values of the cart equal, product added");
        } else {
            log.info("the values of the cart arent equal");
        }
        return addedToCart;
    }

    public static double getPrice(String toConvert) {
        String[] splitedPriceText = toConvert.split(" ₪");
        return Double.parseDouble(splitedPriceText[0]);
    }

    public static boolean addProductE2E(String selectBy) {
        boolean passed = false;
        if (navigateToMen()) {
            if (changeSorting(selectBy)) {
                if (goToProductPage()) {
                    if (addToCart()) {
                        passed = true;
                    }
                }
            }
        }
        return passed;
    }

    public static boolean contactUs(String name, String subject, String email, String message) {
        boolean success = false;
        UIActions.click(HomePage.contactUs_link);
        UIActions.input(ContactUs.name_input, name);
        UIActions.input(ContactUs.subject_input, subject);
        UIActions.input(ContactUs.email_input, email);
        UIActions.input(ContactUs.message_input, message);
        ContactUs.message_input.submit();
        try {
            wait.until(ExpectedConditions.visibilityOf(ContactUs.afterSend_txt));
            if (ContactUs.afterSend_txt.getText().equals("Thanks for contacting us! We will be in touch with you shortly."))
                success = true;
            log.info("Contact us form was filled successfully");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("expected element wasn't found");
        }
        return success;
    }
}
