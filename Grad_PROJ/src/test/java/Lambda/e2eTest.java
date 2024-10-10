package Lambda;

import Pages.*;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class e2eTest extends Base {

    private HomePage homePage;
    private RegisterPage registerPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ProductPage productPage;
    private ConfirmOrderPage confirmOrderPage1;

    @Owner("Aya Fawaz")
    @Story("Register")
    @Description("Create New Account with valid data")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void RegisterSuccessfully() throws IOException {
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);//1- Navigate to register page
        homePage.MyAccount_RegisterButton();
        registerPage.setTxt_FirstName("Aya");
        registerPage.setTxt_LastName("Fawaz");
        Random random = new Random();
        int i = random.nextInt();
        registerPage.setEmail_Field("ayafawaz" + i + "@gmail.com");
        registerPage.set_Telephone("01142180274");
        registerPage.set_password("12345");
        registerPage.confirm_password("12345");
        registerPage.checkPrivacyPolicyBox();
        registerPage.checkContinueButton();
        //assert for SuccessCreating_Account:
       registerPage.TestSuccessCreating_Account();
        registerPage.ClickContinueToNaviToAcc();
        homePage = registerPage.ClickOnLOGO();

    }

    @Description("Given i try to add one product in my cart, When I am in home page, " +
            "Then I should be able to edit cart by updating product's quantity then remove it successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void RemoveProduct() throws IOException {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        String scriptofproducts = "window.scrollBy(0,1800)";
        homePage.ScrollTo(scriptofproducts);
        productPage = homePage.SelectProduct();  // to be removed
   //add scroll here:
        productPage.AddProductToWishList();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //new
        TakeScreenShot("AddProductToWishListSuccessfully",driver);
        productPage.CloseWishList();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        productPage.AddToCartShopping();
        cartPage = productPage.ViewCart();
        cartPage.setQuantity("4");
       cartPage.UpdateProductQuantity();  //i return text inside it so u can remove assert
        cartPage.TestUpdatingQuantity();
       // System.out.println("Cart Total: " +cartPage.GetCartTotal());
        cartPage.GetCartTotal();
        cartPage.RemoveProductFromCart();
       // System.out.println(cartPage.GetCartEmptyMessage());
      cartPage.TestCartISEmptyByMessage();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Given i try to add one product in my cart, When I am in home page, " +
            "Then I should be able to checkout directly")
    public void AddProduct() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        String scriptofproducts = "window.scrollBy(0,1800)";
        WebDriverWait waitForContinueShopping = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForContinueShopping.until(ExpectedConditions.presenceOfElementLocated(By.className(( "buttons"))));
        homePage = cartPage.ContinueShoppingForEmptyCart();
        //add assert for navigate:
        homePage.ScrollTo(scriptofproducts);
        productPage = homePage.SelectProduct2();
        checkoutPage = productPage.BuyNow();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Given i try to complete purchase process, When I used a registered account," +
            "Then I should be asked to complete only Billing Address form and submit order successfully")
    public void SubmitOrder() throws IOException {
        checkoutPage = new CheckoutPage(driver);
        confirmOrderPage1 = new ConfirmOrderPage(driver);
        checkoutPage.AddFirstNameinBillingAdd("Aya");
        checkoutPage.AddLsstNameinBillingAdd("Fawaz");
        checkoutPage.AddAddressinBillingAdd("Luxor");
        checkoutPage.AddCityInBillingAdd("Esna");
        checkoutPage.selectCountryInBillingAdd();
        checkoutPage.selectRegionInBillingAdd();
        //add scrol here
        checkoutPage.checkTermsConditionsInBillingAdd();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        confirmOrderPage1 = checkoutPage.clickContinue();
        confirmOrderPage1.TESTNavigateToConfirm();
        confirmOrderPage1.lastConfirmOrder();
        confirmOrderPage1.TESTNavigateToSuccessConfirm();
        TakeScreenShot("SubmitOrder",driver);
    }

}



















