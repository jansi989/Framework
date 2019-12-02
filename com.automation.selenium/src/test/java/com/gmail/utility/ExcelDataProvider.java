package com.gmail.utility;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {


		
	public XSSFWorkbook wb;


		
		 public ExcelDataProvider() {
			 
			 File fileName=new File(".\\TestData\\TestData.xlsx");
			 
				try
				{
				FileInputStream filescr = new FileInputStream(fileName);
				wb = new XSSFWorkbook(filescr);
				
				}catch (Exception e) {
					e.printStackTrace();
				}
		
			 
		 }
		 
		 public String getStringData(String sheetname,int row,int colum) {
			 
			String data=  wb.getSheet(sheetname).getRow(row).getCell(colum).getStringCellValue();
			
			return data;
		 }
		 
	}

