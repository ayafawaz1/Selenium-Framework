package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Parent {
//allure serve E:\LambdaTest\Grad_PROJ\allure-results
        protected WebDriver driver;
    Parent(WebDriver driver)
        {
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        public static void Clicking(WebElement element)
        {
            element.click();
        }

        public static void SentText(WebElement element,String Text)
        {
            element.sendKeys(Text);
        }

        public void ScrollTo(String script)
        {
            //  String script="window.scrollBy(0,1800)";
            JavascriptExecutor js =(JavascriptExecutor) driver;
            js.executeScript(script);
        }


}
