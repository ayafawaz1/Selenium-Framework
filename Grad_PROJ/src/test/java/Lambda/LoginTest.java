package Lambda;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends Base{
    private HomePage homePage;
    private LoginPage loginpage;

    @Test(dataProvider = "LoginTest")
    public void Login(String email,String password)  {
       // extentReports.createTest("Login");
        homePage=new HomePage(driver);
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginpage=homePage.MyAccount_LoginButton();
        loginpage.EnterMailAddress(email);
        loginpage.EnterPassword(password);
        loginpage.Click_Submit();
        WebDriverWait waitForLogOut = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForLogOut.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//aside//div/a)[14]")));
       loginpage.Click_Logout();
        WebDriverWait waitForConitnue = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForConitnue.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@class='btn btn-primary']")));
       homePage=loginpage.ClickContinueToGoToHome();
       //extentReports.flush();
       //error:
       /* WebDriverWait waitForSearchBox = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForSearchBox.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div/div[@class='flex-fill'])[1]")));
       homePage.searchFor("samsung");
       homePage.clickSearch();*/
    }
}
