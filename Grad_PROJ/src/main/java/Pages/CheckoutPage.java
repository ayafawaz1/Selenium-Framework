package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Parent{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-payment-firstname")
    WebElement FirstNameinBillingAdd;
    public void AddFirstNameinBillingAdd(String Fname)
    {
        SentText(FirstNameinBillingAdd,Fname);
    }

    @FindBy(id="input-payment-lastname")
    WebElement LastNameinBillingAdd;
    public void AddLsstNameinBillingAdd(String Lname)
    {
        SentText(LastNameinBillingAdd,Lname);
    }

    @FindBy(id="input-payment-address-1")
    WebElement AddressinBillingAdd;
    public void AddAddressinBillingAdd(String Address)
    {
        SentText(AddressinBillingAdd,Address);
    }

    @FindBy(id="input-payment-city")
    WebElement CityInBillingAdd;
    public void AddCityInBillingAdd(String city)
    {
        SentText(CityInBillingAdd,city);
    }

//    @FindBy(id="input-payment-postcode")
//    WebElement PostCodeInBillingAdd;
//    public void AddPostCodeInBillingAdd(String code)
//    {
//        SentText(PostCodeInBillingAdd,code);
//    }

    @FindBy(id ="input-payment-country")
    private WebElement countryDropdownInBillingAdd;
    public void selectCountryInBillingAdd()
    {
        // Add code to select country from dropdown
        Select countryselect = new Select(countryDropdownInBillingAdd);
        countryselect.selectByVisibleText("Egypt");
    }

    @FindBy(id = "input-payment-zone")
    private WebElement regionDropdownInBillingAdd;
    public void selectRegionInBillingAdd() {
        // Add code to select region from dropdown
        Select regionselect = new Select(regionDropdownInBillingAdd);
        regionselect.selectByValue("1007");
    }

    @FindBy(xpath = "(//div/label[@class='custom-control-label'])[6]")
    private  WebElement TermsCheckerInBillingAdd;

    public void checkTermsConditionsInBillingAdd()
    {
        Clicking(TermsCheckerInBillingAdd);
    }


    //for register in last step:
    @FindBy(id ="input-payment-firstname")
    private WebElement firstNameField;
    public void enterFirstName(String firstName)
    {
        firstNameField.sendKeys(firstName);
    }

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameField;
    public void enterLastName(String lastName)
    {
        lastNameField.sendKeys(lastName);
    }

    @FindBy(id = "input-payment-email")
    private WebElement emailField;
    public void enterEmail(String email)
    {
        emailField.sendKeys(email);
    }

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneField;
    public void enterTelephone(String telephone)
    {
        telephoneField.sendKeys(telephone);
    }

    @FindBy(id = "input-payment-password")
    private WebElement passwordField;
    public void enterPassword(String pass)
    {
        passwordField.sendKeys(pass);
    }

    @FindBy(id = "input-payment-confirm")
    private WebElement confirmPasswordField;
    public void enterConfirmPassword(String confirmPass)
    {
        confirmPasswordField.sendKeys(confirmPass);
    }

    @FindBy(id = "input-payment-address-1")
    private WebElement addressField;
    public void enterAddress(String address)
    {
        addressField.sendKeys(address);
    }

    @FindBy(id = "input-payment-city")
    private WebElement cityField;
    public void enterCity(String city)
    {
        cityField.sendKeys(city);
    }

    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeField;
    public void enterPostcode(String postcode)
    {
        postcodeField.sendKeys(postcode);
    }

    @FindBy(id = "input-payment-country")
    private WebElement countryDropdown;
    public void selectCountry()
    {
        // Add code to select country from dropdown
        Select countryselect = new Select(countryDropdown);
        countryselect.selectByVisibleText("Egypt");
    }

    @FindBy(id = "input-payment-zone")
    private WebElement regionDropdown;
    public void selectRegion() {
        // Add code to select region from dropdown
        Select regionselect = new Select(regionDropdown);
        regionselect.selectByValue("1001");
    }

    @FindBy(xpath = "(//div/label[@class='custom-control-label'])[9]")
    private  WebElement checkbox_1;
    public void checkPrivacyPolicy()
    {
        checkbox_1.click();
    }

    @FindBy(xpath = "(//div/label[@class='custom-control-label'])[10]")
    private  WebElement checkbox_2;

    public void checkTermsConditions()
    {
        Clicking(checkbox_2);
    }

    @FindBy(xpath = "//button[@id='button-save']")
    private WebElement continueButton;

    public  ConfirmOrderPage clickContinue()
    {
        continueButton.click();
        return new ConfirmOrderPage(driver);


    }

}
