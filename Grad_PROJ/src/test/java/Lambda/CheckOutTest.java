package Lambda;

import Pages.CheckoutPage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutTest extends Base{
    private CheckoutPage checkoutpage;
    private ProductPage productPage;
    @Test
    public void CheckoutAsNewCustomer()
    {
        productPage=new ProductPage(driver);
        checkoutpage=new CheckoutPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        checkoutpage=productPage.CheckingOut();
        checkoutpage.enterFirstName("Aya");
        checkoutpage.enterLastName("Fawaz");
        checkoutpage.enterEmail("ayaf1@gmail.com");
        checkoutpage.enterTelephone("01142180274");
        checkoutpage.enterPassword("12345");
        checkoutpage.enterConfirmPassword("12345");
        checkoutpage.enterAddress("luxor-egypt");
        checkoutpage.enterCity("luxor");
        checkoutpage.enterPostcode("7788");
        checkoutpage.selectCountry();
        checkoutpage.selectRegion();
        checkoutpage.checkPrivacyPolicy();
        checkoutpage.checkTermsConditions();
        checkoutpage.clickContinue();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement Actual= driver.findElement(By.xpath("//div/h1"));
        wait.until(ExpectedConditions.visibilityOf(Actual));
        String actual=driver.findElement(By.xpath("//div/h1")).getText();
        String expected="Confirm Order";
        Assert.assertTrue(actual.contains(expected));
    }
}
