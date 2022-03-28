package week5.day1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomateExcel {
	
	public static String[][] excelData(String excelFilePath) throws IOException {
		
		//to open the excel
		XSSFWorkbook book =new XSSFWorkbook(excelFilePath);
		XSSFSheet sheetAt = book.getSheetAt(0);
		int row_count = sheetAt.getLastRowNum(); //to get total active row count
		System.out.println("The row count "+row_count);
		short cell_count = sheetAt.getRow(0).getLastCellNum();//cols will not be morethan 33,000 data 
		System.out.println("The column count "+cell_count);
		//2D String array to store data
		String[][] data=new String[row_count][cell_count];
		//to get data from row
		for (int i =1 ; i <=row_count ; i++)
		{ 										//i=1, ignoring the Header data
			XSSFRow row = sheetAt.getRow(i);
												//to get data from column (cell) inside the row
			for (int j = 0; j <cell_count ; j++) 
			{
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
			}
		}
		book.close();			//to close the Workbook
		return data;
	}
}
