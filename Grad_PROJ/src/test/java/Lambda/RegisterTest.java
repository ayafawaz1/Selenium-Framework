package Lambda;

import Pages.HomePage;
import Pages.RegisterPage;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class RegisterTest extends Base{
        private HomePage homePage;
        private RegisterPage registerPage;
        @Test
        public void Register()  {
            homePage=new HomePage(driver);
            registerPage=new RegisterPage(driver);
            registerPage=homePage.MyAccount_RegisterButton();
            registerPage.setTxt_FirstName("Aya");
            registerPage.setTxt_LastName("fawaz");
            Random random=new Random();
            int i=random.nextInt();
            registerPage.setEmail_Field("ayafawaz"+i+"@gmail.com");
            registerPage.set_Telephone("+201142180274");
            registerPage.set_password("12345678");
            registerPage.confirm_password("12345678");
            registerPage.checkPrivacyPolicyBox();
            registerPage.checkContinueButton();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

           registerPage.TestSuccessCreating_Account();

            registerPage.ClickContinueToNaviToAcc();
            homePage=registerPage.ClickOnLOGO();

        }
    }


