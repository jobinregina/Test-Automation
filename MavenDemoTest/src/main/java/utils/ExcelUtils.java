package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static File src;

	public static ArrayList<Integer> list = null;

	public static XSSFCell excel() {

		try {
			// Import excel sheet.
			src = new File(System.getProperty("user.dir") +"/src/main/java/com/ebgames/saf/testdata/Test.xlsx");   
			// Load the file.
			fis = new FileInputStream(src);
			// Load he workbook.
			workbook = new XSSFWorkbook(fis);
			// Load the sheet in which data is stored.
			sheet= workbook.getSheetAt(0);

			// Import data for catalog.
			cell = sheet.getRow(3).getCell(0);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		return cell;
	}

}
