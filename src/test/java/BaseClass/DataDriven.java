package BaseClass;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class DataDriven {

    @DataProvider(name = "Product Search")
    public static Object[][] provideTestParam(ITestContext context) {

        Object[][] retObjArr = {{}};


        File path = new File("");
        String fullExcelFilePath = path.getAbsolutePath() + "/Excel/Products.xlsx";
        try {
            FileInputStream file = new FileInputStream(new File(fullExcelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0); // Login
            sheet.iterator();

            retObjArr = new Object[sheet.getPhysicalNumberOfRows() - 1][1];

            for (int rownum = 0; rownum < sheet.getPhysicalNumberOfRows() - 1; rownum++) {
                Row row = sheet.getRow(rownum + 1);

                retObjArr[rownum][0] = row.getCell(0).getStringCellValue(); // Product

            }

            file.close();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        return (retObjArr);
    }
}
