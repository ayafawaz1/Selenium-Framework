package Lambda;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
@Test

public class testexcel {

        public void getData() throws IOException {
            FileInputStream fis=new FileInputStream("E://Testing-track-iti//usersData.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheetAt(0);
            int rowCount=sheet.getPhysicalNumberOfRows();
            XSSFRow row=sheet.getRow(0);
            int colCount=  row.getLastCellNum();
            Object data[][]=new Object[rowCount-1][colCount];
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
                           // data[i][j]=values;
                            System.out.println(values);
                        }
                    }
                }
            }
            // return data;
        }}
