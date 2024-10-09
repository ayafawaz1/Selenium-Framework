package Lambda;

import Pages.*;
import io.opentelemetry.api.logs.Severity;
import org.checkerframework.checker.fenum.qual.SwingVerticalOrientation;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SmokeTest extends Base {
    private HomePage homePage;
    private LoginPage loginPage;

    @Test()
    public void IsLogoISVisible() {
        // extentReports.createTest("VisibilityOfLogo");
        homePage = new HomePage(driver);
        homePage.TestVisibilityOfLogo();
    }

//
//    @Test(dataProvider = "LoginTest",priority = 1)
//    public void Login(String email, String password)
//    {
//        homePage=new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        loginPage =homePage.MyAccount_LoginButton();
//        loginPage.EnterMailAddress(email);
//        loginPage.EnterPassword(password);
//        loginPage.Click_Submit();
//    }
//
//    @Test(dependsOnMethods ="Login")
//    public void LogOutFunction()
//    {
//      // extentReports.createTest("LogOut");
//       loginPage.Click_Logout();
//        String actual=driver.findElement(By.xpath("//div/h1")).getText();
//        String expected="Account Logout";
//        Assert.assertTrue(actual.contains(expected));
//        homePage=loginPage.ClickContinueToGoToHome();
//    }

    @Test()
    public void testSearchFunctionality()
    {
        homePage=new HomePage(driver);
        homePage.searchFor("samsung");
    }
}


