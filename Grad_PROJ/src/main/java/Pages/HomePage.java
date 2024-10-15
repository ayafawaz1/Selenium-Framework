package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Parent {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    Actions a = new Actions(driver);
    @FindBy(xpath = "//a[@data-toggle='dropdown' and .//span[contains(text(),'My account')]]")
    private WebElement MyAccountElement;

    @FindBy(xpath = "//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")
    private WebElement RegisterButtonElement;

    @FindBy(xpath = "//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']")
    private WebElement LoginButtonElement;

    public RegisterPage MyAccount_RegisterButton() {
        a.moveToElement(MyAccountElement).build().perform();
        Clicking(RegisterButtonElement);
        return new RegisterPage(driver);
    }

    public LoginPage MyAccount_LoginButton() {
        a.moveToElement(MyAccountElement).build().perform();
        Clicking(LoginButtonElement);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//a[@title='Poco Electro']")
    private WebElement logoElement;
    public void TestVisibilityOfLogo()
    {
        boolean status = logoElement.isDisplayed();
        Assert.isTrue(status,"true");
    }

@FindBy(name = "search")
private WebElement searchInput;

    @FindBy(xpath = "(//div/button[@type='submit'])[1]")
    private WebElement searchButton;
    public void searchFor(String query) {
        searchInput.sendKeys(query);
        searchButton.click();
    }


    @FindBy(xpath = "//div[@class='cart-icon'][1]")
    private WebElement cartShoppingElement;
    public CartPage ClickShoppingCart() {
        Clicking(cartShoppingElement);
        return new CartPage(driver);
    }



    @FindBy(xpath = "(//div/div[@class='product-thumb-top'])[15]")  //red watch
    private WebElement Product;

    public ProductPage SelectProduct()
    {
        Clicking(Product);
        return new ProductPage(driver);
    }

    @FindBy(xpath="(//div/div[@class='product-thumb-top'])[11]") //HTC TOUCH HD xpath
    private WebElement Product2;

    public ProductPage SelectProduct2()
    {
        Clicking(Product2);
        return new ProductPage(driver);
    }

    @FindBy(id = "entry_217824")
    private WebElement WishListIcon;
    public WishListPage clickWishList()
    {
        Clicking(WishListIcon);
        return new WishListPage(driver);
    }


}
