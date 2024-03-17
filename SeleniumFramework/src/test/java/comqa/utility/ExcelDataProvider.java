package comqa.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider(){
		File src=new File(".\\TestData\\TestData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}catch (Exception e) {
		 System.out.println("Unable to read Excel file: "+e.getMessage()); 
		}
	}
	public String getStringData(int sheetNo, int rowNum, int colNum) {
		
		return	wb.getSheetAt(sheetNo).getRow(rowNum).getCell(colNum).getStringCellValue();
			
		}
		public double getNumericData(int sheetNo, int rowNum, int colNum) {
			return wb.getSheetAt(sheetNo).getRow(rowNum).getCell(colNum).getNumericCellValue();
		}
	public String getStringData(String sheetName, int rowNum, int colNum) {
		
	return	wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		
	}
	public double getNumericData(String sheetName, int rowNum, int colNum) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
	}
}
