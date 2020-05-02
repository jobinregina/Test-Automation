package com.ebgames.saf.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ebgames.saf.actions.SearchAction;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(listeners.TestNGlisteners.class)
public class SearchboxTestCase extends TestCase{

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;


	/* this test checks
	 * 
	 * search functionality and navigation*/
	@Test
	public void searchtest() throws IOException{
		String keyword = "ps4 console";
		int test =1;
		String message = "EB Games | The largest video game retailer in Canada. Play. Trade. Save. - EBGames.ca";
		SearchAction sa = new SearchAction(driver);
		Assert.assertEquals(sa.searchfunction(keyword,test), message);
	}

	/*this test checks
	 * 
	 * product inventory is not zero
	 */
	@Test
	public void inventorytest() throws NumberFormatException, IOException {
		String keyword = "ps4 console";
		int test =2;
		SearchAction sa = new SearchAction(driver);
		int out = Integer.parseInt(sa.searchfunction(keyword, test));
		Assert.assertNotEquals(out,0);
	}

	@Test
	public void inventoryinvalidtest() throws NumberFormatException, IOException {
		String keyword = "***";
		int test =0;
		SearchAction sa = new SearchAction(driver);
		int out = Integer.parseInt(sa.searchfunction(keyword, test));
		Assert.assertEquals(out, 0);
	}

	//@Test
	public void totalinventorytest() throws NumberFormatException, IOException, InterruptedException {
		logger = extent.startTest("find inventory of all item");
		// Import excel sheet.
		File src = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\ebgames\\saf\\testdata\\Test.xlsx");   
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(0);

		int i =0;
		String message = "Pass";
		SearchAction sa = new SearchAction(driver);
		ArrayList<Integer> list = sa.datadrivensearch();
		while(i < list.size()) {
			Assert.assertNotEquals(list.get(i),0);
			i++;
			//To write data in the excel
			FileOutputStream fos=new FileOutputStream(src);

			// Create cell where data needs to be written.
			sheet.getRow(i).createCell(1).setCellValue(message);

			// finally write content
			workbook.write(fos);
		}
		logger.log(LogStatus.PASS, "test pass");
	}


}
