package Lambda;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class LoginTest extends Base{
    private HomePage homePage;
    private LoginPage loginpage;

    @Test(dataProvider = "getLoginData",dataProviderClass = Base.class)
    public void Verify_Login_Credentials(String email,String password) {
        homePage=new HomePage(driver);
        loginpage=homePage.MyAccount_LoginButton();
        loginpage.EnterMailAddress(email);
        loginpage.EnterPassword(password);
        loginpage.Click_Submit();
        try
        {
            Assert.assertTrue(driver.getCurrentUrl().contains("account"),"Login failed for user:"+email);
            WebDriverWait waitForLogOut = new WebDriverWait(driver, Duration.ofSeconds(5));
            waitForLogOut.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//aside//div/a)[14]")));
            loginpage.Click_Logout();
            WebDriverWait waitForConitnue = new WebDriverWait(driver, Duration.ofSeconds(5));
            waitForConitnue.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@class='btn btn-primary']")));
            homePage=loginpage.ClickContinueToGoToHome();
        }
        catch (Exception e)
        {
            WebDriverWait errorMessage = new WebDriverWait(driver, Duration.ofSeconds(5));
            errorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed(),
                    "Error message should be displayed for invalid login");
        }
    }

    }

