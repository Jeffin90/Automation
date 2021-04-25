package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class CheckOutProduct extends BrowserDriver {

    @Test
    public void productCheckout()
    {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTextLoginPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/h3"));
        Assert.assertTrue(uniqueTextLoginPage.isDisplayed());
        driver.findElement(By.id("account_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_password")).sendKeys("Grg@Lyn123");
        driver.findElement(By.id("recaptcha_disabled_btn")).click();
        WebElement uniqueText = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[1]/h1"));
        Assert.assertTrue(uniqueText.isDisplayed());
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/input")).sendKeys("Mens Jeans");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/div/button")).click();

        //user reached mens jeans page//
        WebElement uniqueMensJeans = driver.findElement(By.xpath("/html/body/div[6]/ul/li[3]"));
        Assert.assertTrue(uniqueMensJeans.isDisplayed());

        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 500)");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //select particular product//
        driver.findElement(By.linkText("View")).click();

        //user reach particular product page//
        WebElement uniqueParticularProduct = driver.findElement(By.xpath("/html/body/div[7]/ul/li[5]"));
        Assert.assertTrue(uniqueParticularProduct.isDisplayed());

        //select black colour//
        driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[3]/div[2]/div/ul/li[2]/a")).click();
        //select size//

        new Select(driver.findElement(By.xpath("//*[@id=\"new_line_item\"]/div[1]/div[1]/div/div/a/span[1]"))).selectByIndex(3);
        //select Qty//
        new Select(driver.findElement(By.xpath("//*[@id=\"new_line_item\"]/div[3]/div[1]/div/div/a/span[1]"))).selectByIndex(0);
        //add to bag//
        driver.findElement(By.id("gtm-add")).click();
        //view bag//
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/a[1]")).click();
        WebElement uniqueMyBag = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[2]/div[1]/h1"));
        Assert.assertTrue(uniqueMyBag.isDisplayed());
        driver.findElement(By.linkText("Continue To Checkout")).click();




    }
}
