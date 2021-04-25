package automationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserDriver;

public class StoreFinder extends BrowserDriver {

    @Test
    public void findStoreLocation()
    {

        driver.findElement(By.linkText("Store Finder")).click();
        WebElement uniqueFinderPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/h3"));
        Assert.assertTrue(uniqueFinderPage.isDisplayed());
        driver.findElement(By.id("addressEntry")).sendKeys("S5 7AE");
        driver.findElement(By.id("findStore")).click();
       String expectedText = "Stores";
       String actualText = driver.findElement(By.xpath("//*[@id=\"storeFinderContainer\"]/div/div/div[1]/h5")).getText();
       Assert.assertEquals(expectedText,actualText);
    }

}
