package vtiger.Practice;

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
		
		//Step 1: load the location of the file to file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		
		//Step 2: create a work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get into sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: get into the row
		Row row = sh.getRow(4);
		
		//Step 5: get into the cell
		Cell cel = row.getCell(2);
		
		//Step 6: read the value present in the cell
		String value = cel.getStringCellValue();
		System.out.println(value);
		
	}

}
