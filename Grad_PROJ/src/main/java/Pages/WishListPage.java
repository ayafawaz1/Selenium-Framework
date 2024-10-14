package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//allure serve E:\LambdaTest\Grad_PROJ\allure-results

public class WishListPage extends Parent{
    WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id=\"content\"]/p")
    private WebElement wishlistEmptyMessage;
    public String GetWishListEmptyMessage()
    {
        return wishlistEmptyMessage.getText();
    }


    @FindBy(xpath = "//td[@class='text-left'][2]")
    private WebElement ProductModel;
    public String GetProductModel()
    {
        return ProductModel.getText();

    }

}
