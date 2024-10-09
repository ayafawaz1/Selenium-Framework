package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Parent{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="input-email")
    private WebElement Email_Element;
    @FindBy(id="input-password")
    private WebElement Password_Element;
    public void EnterMailAddress(String mail)
    {
        SentText(Email_Element,mail);
    }
    public void EnterPassword(String pass)
    {
        SentText(Password_Element,pass);
    }
    @FindBy(xpath="//input[@type='submit']")
    private WebElement SubmitButton_element;
    public void Click_Submit()
    {
        Clicking(SubmitButton_element);
    }

    @FindBy(xpath = "(//aside//div/a)[14]")
    private WebElement LogOutButton;
    @FindBy(xpath = "//div/a[@class='btn btn-primary']")
    WebElement continueButton;
    public void Click_Logout()
    {
        Clicking(LogOutButton);

    }
    public HomePage ClickContinueToGoToHome()
    {
        Clicking(continueButton);
        return new HomePage(driver);
    }

}
