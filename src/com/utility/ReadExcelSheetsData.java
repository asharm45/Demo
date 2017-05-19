package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.main.test.MainTest;

public class ReadExcelSheetsData extends MainTest{
	
	static File src;
	static FileInputStream fis;
	static FileOutputStream fout;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	public String[][] fetchDataFromExcel(String path,String sheetName){
		
		try {
			src = new File(path);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int rowNum=sheet.getLastRowNum()+1;
			int colNum=sheet.getRow(0).getLastCellNum();
			
			System.out.println("number of rows "+rowNum);
			System.out.println("number of columns "+colNum);
			String[][] data= new String[rowNum][colNum];
			
			for(int i=1; i<rowNum; i++)
			{
				row=sheet.getRow(i);
				for(int j=0; j<colNum; j++)
				{
					cell= row.getCell(j);
					String value=cellToString(cell);
					data[i][j]=value;				
				}
			}
			workbook.close();
			fis.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String[][] fetchTestCasesDataFromExcel(String path,String sheetName){
			
			try {
				src = new File(path);
				fis = new FileInputStream(src);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(sheetName);
				int rowNum=sheet.getLastRowNum()+1;
				int colNum=sheet.getRow(0).getLastCellNum();
				
				System.out.println("number of rows "+rowNum);
				System.out.println("number of columns "+colNum);
				String[][] data= new String[rowNum][colNum];
				
				for(int i=1; i<rowNum; i++)
				{
					row=sheet.getRow(i);
					for(int j=0; j<colNum; j++)
					{
						cell= row.getCell(j);
						String value=cellToString(cell);
						data[i][j]=value;				
					}
				}
				workbook.close();
				fis.close();
				return data;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
	
			
	public String[][] fetchUsersDataFromExcel(String path,String sheetName){
		
		try {
			src = new File(path);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int rowNum=sheet.getLastRowNum()+1;
			int colNum=sheet.getRow(0).getLastCellNum();
			
			System.out.println("number of rows "+rowNum);
			System.out.println("number of columns "+colNum);
			String[][] data= new String[rowNum][colNum];
			
			for(int i=1; i<rowNum; i++)
			{
				row=sheet.getRow(i);
				for(int j=0; j<colNum; j++)
				{
					cell= row.getCell(j);
					String value=cellToString(cell);
					data[i][j]=value;				
				}
			}
			workbook.close();
			fis.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void writeInExcelFile(String filePath,String sheetName,int row,int column,String status){
		
		try {
			src= new File(filePath);
			fis= new FileInputStream(src);
			workbook= new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetName);
			//To write data in excel
			sheet.getRow(row).createCell(column).setCellValue(status);
			fout=new FileOutputStream(src);
			workbook.write(fout);
			workbook.close();
			System.out.println("You have updated the file");
		} catch (Exception e) {
			System.out.println("Exception occured :"+e.getCause());
		} 
	}

	public void writeTimeInExcelSheet(String filePath,String sheetName,int row,int column,long time){
		
		try {
			src= new File(filePath);
			fis= new FileInputStream(src);
			workbook= new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetName);
			//To write 'Time' in excel
			sheet.getRow(row).createCell(column).setCellValue(time);
			fout=new FileOutputStream(src);
			workbook.write(fout);
			workbook.close();
			System.out.println("You have updated time in the file");
		} catch (Exception e) {
			System.out.println("Exception occured :"+e.getCause());
		} 
	}

	
	public String cellToString(XSSFCell cell){
		Object result;
		String strReturn = null;
		
		if(cell==null){
			 strReturn ="";
		}else{
			switch (cell.getCellType()){
			case Cell.CELL_TYPE_NUMERIC:
				result=cell.getNumericCellValue();
				strReturn=result.toString();
				break;				
			case Cell.CELL_TYPE_STRING:
				result=cell.getStringCellValue();
				strReturn=result.toString();				
				break;
			default:
				strReturn=null;						
		}

		}
		return strReturn;
	}
}
