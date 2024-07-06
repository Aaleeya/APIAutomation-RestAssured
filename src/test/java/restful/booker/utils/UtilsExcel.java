package restful.booker.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsExcel {

    //It will be used by DataProvider of the TestNG
    //Object[][]

    public static String FILE_NAME = "";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetname){
        FileInputStream file = null;
        try{
            file = new FileInputStream(FILE_NAME);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            book = WorkbookFactory.create(file);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = book.getSheet(sheetname);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }

        return data;
    }

    @DataProvider
    public Object[][] getData(){
        //In future I can write logic  to select which sheet I want to open
        //Ask user which sheet to open
        //data.properties ->sheet 1 or sheet2
        //sheet1 ->u/p for QA
        //sheet2 ->U/P for prod
        return getTestData("Sheet1");
    }
}
