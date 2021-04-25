package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

public class SavedListValidation extends BrowserDriver {
    @Test
    public void savedInWishList()
    {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTextLoginPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/h3"));
        Assert.assertTrue(uniqueTextLoginPage.isDisplayed());
        driver.findElement(By.id("account_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_password")).sendKeys("Grg@Lyn123");
        driver.findElement(By.id("recaptcha_disabled_btn")).click();
        WebElement uniqueText = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[1]/h1"));
        Assert.assertTrue(uniqueText.isDisplayed());

        //search item Mens Jeans//
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/input")).sendKeys("Mens Jeans");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/form/div/div/div/button")).click();
        WebElement uniqueTextJeans = driver.findElement(By.xpath("/html/body/div[6]/ul/li[3]"));
        Assert.assertTrue(uniqueTextJeans.isDisplayed());

        //maximize screen//
        driver.manage().window().maximize();

        //click on product to add saved list//
        WebElement uniqueProductSelect = driver.findElement(By.xpath("/html/body/div[6]/form/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[2]/a[1]/div"));
        driver.findElement(By.xpath("/html/body/div[6]/form/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[2]/a[1]/div")).click();

        //Reached product page//
        WebElement uniqueImage = driver.findElement(By.xpath("//*[@id=\"cascade-slider\"]/div/div/figure[3]/a/img"));
        Assert.assertTrue(uniqueImage.isDisplayed());

        //click on "heart" button near to product inside that particular product page and added to saved list//
        driver.findElement(By.xpath("//*[@id=\"new_line_item\"]/div[3]/div[3]/a")).click();

        //open saved list from Top RH header//
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/a[2]")).click();

        //reach saved list page//
        WebElement uniqueTestWishPage = driver.findElement(By.xpath("/html/body/div[6]/div[1]/ul/li[3]"));
        Assert.assertTrue(uniqueTestWishPage.isDisplayed());

        //clicking the saved product in saved list page
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div/div/div[1]/a")).click();

        //confirms same product was found//
        WebElement expectedProduct = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[3]/div[1]/div[1]/h1"));

        //comparing both//
        Assert.assertEquals(expectedProduct,uniqueProductSelect);
    }
}
