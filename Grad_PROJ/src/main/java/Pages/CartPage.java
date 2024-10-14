package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends Parent{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="entry_217851")
    private WebElement CheckOutButton;
    public CheckoutPage ProceedToCheckOut()
    {
        Clicking(CheckOutButton);
        return new CheckoutPage(driver);
    }

    @FindBy(id="entry_217850")
    private WebElement editCartButton;
    public CartPage GoToShoppingCart()
    {
        Clicking(editCartButton);
        return new CartPage(driver);
    }


    @FindBy(xpath="//div[@id='content']/p")
    private WebElement shoppingCartEmptyMessage;
    public String GetCartEmptyMessage()
    {
        return shoppingCartEmptyMessage.getText();
    }

    //continue shopping if the cart is empty:
    @FindBy(className = "buttons")
    private WebElement ContinueShopping;
    public HomePage ContinueShoppingForEmptyCart()
    {
        Clicking(ContinueShopping);
        return new HomePage(driver);
    }

    //"  ' swape if there is error.
    //error in path cannot locate element:
    @FindBy(xpath = "//div/input[@style='min-width:3em']")
    private WebElement quantityInput;
    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    @FindBy(xpath = "//div/button[@class='btn btn-primary']")  //it mactch many but mine is first
    private  WebElement upadteCartButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    private  WebElement AlertUpdatingQuantity;
    public String  UpdateProductQuantity()
    {
        upadteCartButton.click();
       return AlertUpdatingQuantity.getText();
    }

    @FindBy(xpath = "//div/button[@class='btn btn-danger']")  //match 2 removes button
    private  WebElement removeProductButton;
    public void RemoveProductFromCart()
    {
        removeProductButton.click();
    }
    //scroll in test to get cart total..
    /* error in path: @FindBy(xpath = "(//tr/td[@class='text-right'])[9]") */
    @FindBy(xpath = "(//tr/td[@class='text-right']/strong)[8]")
    private WebElement cartTotal;

    public String GetCartTotal()
    {
        return cartTotal.getText();
    }

    //if there is any products in cart:
    @FindBy(xpath = "//div/a[@class='btn btn-lg btn-secondary mr-auto']")
    private WebElement ContinueButton;
    public HomePage ClickContinueShopping()
    {
        Clicking(ContinueButton);
        return new HomePage(driver);
    }

    @FindBy (xpath = "//div/a[@class='btn btn-lg btn-primary']")
    private WebElement checkoutButton;
    public CheckoutPage ProceedToCheckout()
    {
        Clicking(checkoutButton);
        return new CheckoutPage(driver);
    }
    public void TestUpdatingQuantity()
    {
        String actualmessage=driver.findElement(By.xpath("//div/div[@class='alert alert-success alert-dismissible']")).getText();
        String expected_UpdatedMessage="Success: You have modified your shopping cart!";
        Assert.assertTrue(actualmessage.contains(expected_UpdatedMessage));
    }

    public  void TestCartISEmptyByMessage()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String actualmessage=driver.findElement(By.xpath("//div[@id='content']/p")).getText();
        String expectedEmptyCart_Message="Your shopping cart is empty!";
        Assert.assertTrue(actualmessage.contains(expectedEmptyCart_Message));
    }

}
