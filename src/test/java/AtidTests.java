import Utilities.CommonOps;
import WorkFlows.WebFlows;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AtidTests extends CommonOps {
    @Test(priority = 1)
    public  void performSearch() {
        String searchCriteria = "ATID";
        Assert.assertTrue(WebFlows.search(searchCriteria), "search failed");
    }

    @Test(priority = 2)
    public  void addProductToCart() {
        String sortBy = "Sort by popularity";
        Assert.assertTrue(WebFlows.addProductE2E(sortBy), "E2E flow failed, check the log");
    }

    @Test(priority = 3)
    public  void contactUsFillForm() {
        String name = "Alexey";
        String subject = "Automated submitting of form";
        String email = "myEmail@automation.com";
        String message = "Lorem ipsum dolor sit amet, you know the rest...";
        Assert.assertTrue(WebFlows.contactUs(name,subject,email,message));
    }
}
