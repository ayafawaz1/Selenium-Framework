package Lambda;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base {
        protected WebDriver driver;

        @BeforeClass
        public void SetUp()
        {
            //driver=new EdgeDriver();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        }

    @AfterClass
    public void TearOut()
    {
        //driver.quit();
    }

     public static String TakeScreenShot(String TcName,WebDriver driver) throws IOException {
            TakesScreenshot ts=(TakesScreenshot)driver ;
            File Source=ts.getScreenshotAs(OutputType.FILE);
            File file=new File(System.getProperty("user.dir")+"//ScreenShots//"+TcName+".png");
            //download apache common io  repository for screenshot
            FileUtils.copyFile(Source,file);
            InputStream isfile=new FileInputStream(file);
            Allure.addAttachment("Screenshots",isfile);
            return System.getProperty("user.dir")+"//reports//"+TcName+".png";
        }

    @DataProvider(name="LoginTestData")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\Testing-track-iti\\usersData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object data[][] = new Object[rowCount - 1][colCount];
        for(int i=0;i<rowCount-1;i++)
        {
            row=sheet.getRow(i+1);
            for(int j=0;j<colCount;j++)
            {
                if (row==null)
                    data[i][j]="";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    if(cell==null)
                        data[i][j]="";
                    else
                    {
                        // String d= (data[i][j]="").toString();
                        String values= cell.toString();
                        data[i][j]=values;
                        //System.out.println(values);
                    }
                }
            }
        }
        return data;
    }

        @DataProvider(name="LoginTest")
        public static Object [][] userData()
        {
            return new Object[][]
                    {
//                            {"aya12gmail.com","123456"},//not valid email not have @
//                            {"111@gmail.com",""},//empty pass
                           // {"","12345"},
                            {"Aya@gmail.com","12345"} //right data to login
                    };
        }
    }

