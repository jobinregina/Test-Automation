package com.ebgames.saf.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ebgames.saf.actions.SearchAction;
import utils.ExcelUtils;

@Listeners(listeners.TestNGlisteners.class)
public class SearchboxTestCase extends TestCase{

	


	/* this test checks
	 * 
	 * search functionality and navigation*/
	//@Test
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
	//@Test
	public void inventorytest() throws NumberFormatException, IOException {
		String keyword = "ps4 console";
		int test =2;
		SearchAction sa = new SearchAction(driver);
		int out = Integer.parseInt(sa.searchfunction(keyword, test));
		Assert.assertNotEquals(out,0);
	}

	//@Test
	public void inventoryinvalidtest() throws NumberFormatException, IOException {
		String keyword = "***";
		int test =0;
		SearchAction sa = new SearchAction(driver);
		int out = Integer.parseInt(sa.searchfunction(keyword, test));
		Assert.assertEquals(out, 0);
	}

	@Test
	public void totalinventorytest(){
		
		String message = "Pass";
		SearchAction sa = new SearchAction(driver);
		Assert.assertNotEquals(sa.datadrivensearch(),0);
		try {
		//To write data in the excel
		FileOutputStream fos=new FileOutputStream(ExcelUtils.src);

		// Create cell where data needs to be written.
		ExcelUtils.sheet.getRow(3).createCell(1).setCellValue(message);

		// finally write content
		ExcelUtils.workbook.write(fos);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();		
		}
	}


}
