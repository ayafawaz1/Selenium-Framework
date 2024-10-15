package Lambda;

import Pages.CartPage;
import Pages.HomePage;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends Base{
    private HomePage homePage;
    private CartPage cartpage;
    @Test
    public void testShoppingCart() {
        homePage=new HomePage(driver);
        cartpage=new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartpage =homePage.ClickShoppingCart();
        cartpage.GoToShoppingCart();
        cartpage.GetCartEmptyMessage();
        cartpage.ContinueShoppingForEmptyCart();

    }
}
