package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonOps extends Base{

    private static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


    @BeforeClass(alwaysRun = true)
    public void StartSession() {
        driver = initChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atid.store");
        wait = new WebDriverWait(driver, 20);
        ManagePages.init();
        action = new Actions(driver);
    }

    @AfterClass(alwaysRun = true)
    public void CloseSession() {
        driver.quit();
    }

}
