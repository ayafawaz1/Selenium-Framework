package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class RegisterPage extends Parent{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-firstname")
    protected WebElement txt_FirstName;

    public void setTxt_FirstName(String FirstName)
    {
        SentText(txt_FirstName,FirstName);
    }

    @FindBy(id="input-lastname")
    protected WebElement txt_LastName;
    public void setTxt_LastName(String lastName)
    {
        SentText(txt_LastName,lastName);
    }

    @FindBy(id="input-email")
    protected WebElement email_Field;
    public void setEmail_Field(String email)
    {
        SentText(email_Field,email);
    }

    @FindBy(id="input-telephone")
    protected WebElement telephone_Field;
    public void set_Telephone(String telephone)
    {
        SentText(telephone_Field,telephone);
    }

    @FindBy(id="input-password")
    protected WebElement password_Field;
    public void set_password(String password)
    {
        SentText(password_Field,password);
    }

    @FindBy(id="input-confirm")
    protected WebElement confirmPassword_Field;
    public void confirm_password(String confirmPassword)
    {
        SentText(confirmPassword_Field,confirmPassword);
    }

    @FindBy(xpath="//div[@class='float-right']/div")
    protected WebElement privacyPolicyCheckBox;
    public void checkPrivacyPolicyBox()
    {
        Clicking(privacyPolicyCheckBox);
    }

    @FindBy(xpath="//div[@class='float-right']/input")
    protected WebElement continueButton;
    public void checkContinueButton()
    {
        Clicking(continueButton);
    }

    @FindBy(xpath ="//div/div/a[@class='btn btn-primary']")
    private WebElement  ContinueButton2;
    public void ClickContinueToNaviToAcc()
    {
        Clicking(ContinueButton2);
    }

    @FindBy(xpath = "//div/div/figure[@class='figure']")
    private WebElement LogoElement;
    public HomePage ClickOnLOGO()
    {
        Clicking(LogoElement);
        return new HomePage(driver);
    }

    public void TestSuccessCreating_Account()
    {
        String actualmessage=driver.findElement(By.xpath("//div/div/h1[contains(@class,'page-title my-3')]")).getText();
        String expected_ConfirmationMessage="Your Account Has Been Created!";

        Assert.assertTrue(actualmessage.contains(expected_ConfirmationMessage));
        // System.out.println(actualmessage);
    }
}
