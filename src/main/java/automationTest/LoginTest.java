package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

public class LoginTest extends BrowserDriver {

    @Test
    public void validLogin()
    {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTextLoginPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/h3"));
        Assert.assertTrue(uniqueTextLoginPage.isDisplayed());
        driver.findElement(By.id("account_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_password")).sendKeys("Grg@Lyn123");
        driver.findElement(By.id("recaptcha_disabled_btn")).click();
        String expectedText = "My Account";
        String actualText = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[1]/h1")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void invalidLogin()
    {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTextLoginPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/h3"));
        Assert.assertTrue(uniqueTextLoginPage.isDisplayed());
        driver.findElement(By.id("account_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_password")).sendKeys("Grg@Lyn1987");
        driver.findElement(By.id("recaptcha_disabled_btn")).click();
        String expectedText = "The password you have entered does not match the criteria";
        String actualText = driver.findElement(By.xpath("//*[@id=\"new_account\"]/div[2]/span")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void forgottenPassword()
    {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTextLoginPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[1]/h3"));
        Assert.assertTrue(uniqueTextLoginPage.isDisplayed());
        driver.findElement(By.linkText("Forgotten your password?")).click();
        String expectedText = "Forgotten your password?";
        String actualText = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/h3")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
