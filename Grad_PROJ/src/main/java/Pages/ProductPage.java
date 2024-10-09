package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class ProductPage extends Parent{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="entry_216843")
    private WebElement BuyNowButtonElement;
    public CheckoutPage BuyNow()
    {
        Clicking(BuyNowButtonElement);
        return new CheckoutPage(driver);
    }

    @FindBy(xpath="(//div/div/button[@class='btn btn-wishlist wishlist-36'])[1]")
    private WebElement WishListButton;
    public void AddProductToWishList()
    {
        Clicking(WishListButton);
    }

    @FindBy(xpath = "//div/div/button[@class='ml-2 mb-1 close']")
    private WebElement CloseWishlistButton;
    public void CloseWishList()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(CloseWishlistButton));
        Clicking(CloseWishlistButton);
    }

//    public void clickCloseMessage(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.elementToBeClickable(closeMessage));
//        driver.findElement(closeMessage).click();
//    }


   @FindBy(id = "entry_216842")  //add to cart button
    private WebElement AddToCartButton;
    public void AddToCartShopping()
    {
        Clicking(AddToCartButton);
    }


    @FindBy(xpath="//div/a[@class='btn btn-primary btn-block']")
    private WebElement ViewCartButton;
    public CartPage ViewCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ViewCartButton));
        Clicking(ViewCartButton);
        return new CartPage(driver);
    }

    @FindBy(xpath="//div/a[@class='btn btn-secondary btn-block']")
    private WebElement CheckoutButton;
    public CheckoutPage CheckingOut()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(CheckoutButton));
        Clicking(CheckoutButton);
        return new CheckoutPage(driver);
    }


}
