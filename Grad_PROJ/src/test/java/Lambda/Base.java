package Lambda;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--incognito");
            driver=new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        }

    @AfterClass
    public void TearOut()
    {
        driver.quit();
    }

    //download apache common io  repository for screenshot
     public static String TakeScreenShot(String TcName,WebDriver driver) throws IOException {
            TakesScreenshot ts=(TakesScreenshot)driver ;
            File Source=ts.getScreenshotAs(OutputType.FILE);
            File file=new File(System.getProperty("user.dir")+"//ScreenShots//"+TcName+".png");
            FileUtils.copyFile(Source,file);
            InputStream isfile=new FileInputStream(file);
            Allure.addAttachment("Screenshots",isfile);
            return System.getProperty("user.dir")+"//reports//"+TcName+".png";
        }


    @DataProvider
    public static Object[][] getLoginData() throws IOException {
        String excelsheetpath = "E:\\Testing-track-iti\\usersData.xlsx";
        DataFormatter formatter = new DataFormatter();
        FileInputStream fis = new FileInputStream(excelsheetpath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                data[i - 1][0] = formatter.formatCellValue(row.getCell(0)); // Email
                data[i - 1][1] = formatter.formatCellValue(row.getCell(1)); // Password
            }
        }
        workbook.close();
        fis.close();
        return data;
    }

    }

