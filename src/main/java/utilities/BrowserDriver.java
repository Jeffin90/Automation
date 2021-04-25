package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    public static WebDriver driver;

    @Before
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.matalan.co.uk/");
        WebElement uniquePageElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[1]/div/h2"));
        Assert.assertTrue(uniquePageElement.isDisplayed());
    }

    @After
    public void afterTest()
    {
        driver.quit();
    }
}
