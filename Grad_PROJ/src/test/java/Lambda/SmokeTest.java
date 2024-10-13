package Lambda;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SmokeTest extends Base {
    private HomePage homePage;
    private LoginPage loginPage;


    @Description("check the visibility of logo in the top side of the home page")
    @Test()
    public void IsLogoISVisible() {
        // extentReports.createTest("VisibilityOfLogo");
        homePage = new HomePage(driver);
        homePage.TestVisibilityOfLogo();
    }

    @Story("Verify Login Credentials")
    @Description("When I try to Sign in with valid and invalid data")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "getLoginData",priority = 1)
    public void Login(String email, String password)
    {
        homePage=new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage =homePage.MyAccount_LoginButton();
        loginPage.EnterMailAddress(email);
        loginPage.EnterPassword(password);
        loginPage.Click_Submit();
        try
        {
            Assert.assertTrue(driver.getCurrentUrl().contains("account"),"Login failed for user:"+email);
        }
        catch (Exception e)
        {
            WebDriverWait errorMessage = new WebDriverWait(driver, Duration.ofSeconds(5));
            errorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed(),
                    "Error message should be displayed for invalid login");
        }
    }

    @Story("Log Out")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods ="Login")
    public void LogOutFunction()
    {
       loginPage.Click_Logout();
        String actual=driver.findElement(By.xpath("//div/h1")).getText();
        String expected="Account Logout";
        Assert.assertTrue(actual.contains(expected));
        homePage=loginPage.ClickContinueToGoToHome();
    }

    @Story("Search for 'samsung' ")
    @Description("Given i search for exist product, When I am in Home page, Then I should get this product")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void testSearchFunctionality()
    {
        homePage=new HomePage(driver);
        homePage.searchFor("samsung");
    }
}


