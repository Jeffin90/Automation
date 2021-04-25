package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BrowserDriver {

    @Test
    public void searchParticularProductFromList()
    {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/input")).sendKeys("Pants");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/div/button")).click();
        WebElement uniqueTest = driver.findElement(By.xpath("/html/body/div[6]/ul/li[3]"));
        Assert.assertTrue(uniqueTest.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"filter_department\"]/label[4]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//*[@id=\"filter_category\"]/label[4]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"filter_colour\"]/label[1]/div[1]/div")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String expectedSearchResult = "Slim Fit Twill Trousers";
        String actualSearchResult = driver.findElement(By.xpath("/html/body/div[6]/form/div/div[2]/div[1]/div[2]/div/div/div[1]/div[2]/a[1]/div")).getText();
        Assert.assertEquals(expectedSearchResult,actualSearchResult);
    }

}
