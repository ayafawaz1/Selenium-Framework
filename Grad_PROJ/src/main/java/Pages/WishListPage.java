package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends Parent{
    WishListPage(WebDriver driver) {
        super(driver);
    }

    //add remove from wishlist method..
    @FindBy(xpath="//div[@id=\"content\"]/p")
    private WebElement wishlistEmptyMessage;
    public String GetWishListEmptyMessage()
    {
        return wishlistEmptyMessage.getText();
    }

//    @FindBy(id="content")
//    private  WebElement wishlistTable;
//    public boolean wishlistTableIsDisplayed()
//    {
//        wishlistTable.isDisplayed();
//        return true;
//    }

    @FindBy(xpath = "//td[@class='text-left'][2]")
    private WebElement ProductModel;
    public String GetProductModel()
    {
        return ProductModel.getText();

    }

}
