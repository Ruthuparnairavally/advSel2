package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Load the location o the file
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: getSheet
		Sheet sheet = wb.getSheet("Organization");
		
		//Step 4: get row
		Row row = sheet.getRow(1);
		
		//Step 5: get cell
		Cell cell = row.getCell(2);
		
		//Step 6: read value from cell
		String value = cell.getStringCellValue();
		System.out.println(value);
	}
}
