package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
//import org.testng.Assert;


public class ConfirmOrderPage extends Parent{
    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//div/button[@id='button-confirm']")
    WebElement ConfirmOrderButton;
    public void lastConfirmOrder()
    {
        ConfirmOrderButton.click();
    }

    public void TESTNavigateToConfirm()
    {
        String actual=driver.findElement(By.xpath("//div/h1")).getText();
        String expected="Confirm Order";
        Assert.assertTrue(actual.contains(expected));
    }

    public void TESTNavigateToSuccessConfirm()
    {
        String actualmessage=driver.findElement(By.xpath("//div/div/h1[contains(@class,'page-title my-3')]")).getText();
        String expected_ConfirmationMessage="Your order has been placed!";
        Assert.assertTrue(actualmessage.contains(expected_ConfirmationMessage));
       // System.out.println(actualmessage);
    }
}
