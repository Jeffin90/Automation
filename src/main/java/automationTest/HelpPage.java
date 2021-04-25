package automationTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BrowserDriver;

public class HelpPage extends BrowserDriver {
    @Test
    public void contactHelp()
    {
        driver.findElement(By.linkText("Contact")).click();
        String expectedText = "HERE TO HELP";
        String actualText = driver.findElement(By.xpath("/html/body/div[7]/div/div/h1")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
}
