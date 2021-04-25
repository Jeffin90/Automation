package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class ReturnPage extends BrowserDriver {
    @Test
    public void returnPageFinder()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.linkText("Returns")).click();
        String expectedText = "RETURNS & CANCELLATIONS";
        String actualText = driver.findElement(By.xpath("/html/body/div[7]/div/div/h1")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
