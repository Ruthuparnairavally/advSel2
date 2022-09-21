package vtigerGenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the generic methods related to excel
 * @author RUTHUPARNA
 *
 */
public class ExcelUtils {

	/**
	 * This method is used to read the data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();	
		return value;
	}
	
	/**
	 * This method is used to get the tota no of rows in excel sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int rowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet(sheet);
		int r = s.getLastRowNum();	
		
		return r;
		
	}
	
	/**
	 *  This method is used to write the data to excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void rightdataExcel(String sheet, int row, int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstant.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] readMultiDataFromExcel(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet(sheet);
		int r = s.getLastRowNum();
		short c = s.getRow(1).getLastCellNum();
		
		Object [][] obj = new Object[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				obj[i][j] = s.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		
		return obj;
	}
}
