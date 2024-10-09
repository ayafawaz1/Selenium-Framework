package Lambda;

import Pages.HomePage;
import Pages.ProductPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends Base{
    private HomePage homepage;
    private ProductPage productPage;

    @Test
    public void AddProducts()  {
        homepage=new HomePage(driver);
        String scriptofproducts="window.scrollBy(0,1800)";
        homepage.ScrollTo(scriptofproducts);
        productPage=homepage.SelectProduct2();
        productPage.BuyNow();

    }
}
