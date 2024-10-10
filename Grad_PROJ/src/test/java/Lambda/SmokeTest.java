package Lambda;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.checkerframework.checker.fenum.qual.SwingVerticalOrientation;
import org.openqa.selenium.By;
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

    @Story("Log In")
    @Description("When I try to Sign in with valid and invalid data")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginTest",priority = 1)
    public void Login(String email, String password)
    {
        homePage=new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage =homePage.MyAccount_LoginButton();
        loginPage.EnterMailAddress(email);
        loginPage.EnterPassword(password);
        loginPage.Click_Submit();
    }

    @Story("Log Out")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods ="Login")
    public void LogOutFunction()
    {
      // extentReports.createTest("LogOut");
       loginPage.Click_Logout();
        String actual=driver.findElement(By.xpath("//div/h1")).getText();
        String expected="Account Logout";
        Assert.assertTrue(actual.contains(expected));
        homePage=loginPage.ClickContinueToGoToHome();
    }
    @Story("Search")
    @Description("Given i search for exist product, When I am in Home page, Then I should get this product")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void testSearchFunctionality()
    {
        homePage=new HomePage(driver);
        homePage.searchFor("samsung");
    }
}


