package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BrowserDriver;

import java.util.concurrent.TimeUnit;

public class Registration extends BrowserDriver {

    @Test
    public void validRegistration() {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTestRegPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[3]/h3"));
        Assert.assertTrue(uniqueTestRegPage.isDisplayed());
        driver.findElement(By.id("account_form_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.xpath("//*[@id=\"new_account_form\"]/button")).click();
        WebElement uniqueTestCreateAccountPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/h3"));
        Assert.assertTrue(uniqueTestCreateAccountPage.isDisplayed());
        driver.manage().window().maximize();
        driver.findElement(By.id("account_form_meta_attributes[first_name][value]")).sendKeys("Lynn");
        driver.findElement(By.id("account_form_meta_attributes[last_name][value]")).sendKeys("George");
        driver.findElement(By.id("account_form_email")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_form_email_confirmation")).sendKeys("Lynngeorge@sample.com");
        driver.findElement(By.id("account_form_password")).sendKeys("Grg@Lyn123");
        driver.findElement(By.id("account_form_password_confirmation")).sendKeys("Grg@Lyn123");
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("recaptcha_disabled_btn")).click();
    }

    @Test
    public void inValidRegistration() {
        driver.findElement(By.linkText("My Account")).click();
        WebElement uniqueTestRegPage = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[3]/h3"));
        Assert.assertTrue(uniqueTestRegPage.isDisplayed());
        driver.findElement(By.id("account_form_email")).sendKeys("Lynngeorge");
        driver.findElement(By.xpath("//*[@id=\"new_account_form\"]/button")).click();
        String expectedText = "Please enter a valid email address";
        String actualText = driver.findElement(By.xpath("//*[@id=\"new_account_form\"]/div/span")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}