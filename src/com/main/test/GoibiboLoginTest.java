package com.main.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class GoibiboLoginTest extends CommonMethodsClass{
	@Test
	public void goibiboLoginTest(){
		long start = System.currentTimeMillis();
		writeTimeInExcelSheet("D:/LR12/TestCases.xlsx","Sheet1", 1, 3, start);
		
		String [][] data = fetchDataFromExcel("D:/LR12/KeywordSheets.xlsx","Sheet1");
		String [][] data1 = fetchTestCasesDataFromExcel("D:/LR12/TestCases.xlsx","Sheet1");
		if(data1[1][1].equalsIgnoreCase("n")){
			writeInExcelFile("D:/LR12/TestCases.xlsx","Sheet1",1,2,"Skip");
			throw new SkipException("Need to skip..");
			}else{
			for(int i=1;i<=9;i++){
				switch (data[i][3]) {
				case "navigate_to":
					navigate_to(driver,data[i][6]);
					break;
				case "Click_Element":
					click_Element(driver,data[i][4],data[i][5]);
					break;
				case "send_Keys":
					send_Keys(driver,data[i][4],data[i][5],data[i][6]);
					break;
				case "switchtoIframe":
					switchtoIframe(driver,data[i][4],data[i][5]);
					break;
				case "switchtodefaultcontent":
					switchtodefaultcontent(driver);
				}
			}
		}
		writeInExcelFile("D:/LR12/TestCases.xlsx","Sheet1",1,2,"Pass");
		
		long finish = System.currentTimeMillis();
		writeTimeInExcelSheet("D:/LR12/TestCases.xlsx","Sheet1", 1, 4, finish);
		
	}
}