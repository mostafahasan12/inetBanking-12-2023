package com.inetbanking.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils2  {
	
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;

public static int GetRowCount(String xlfile , String xlsheet) throws IOException {
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	int rowcount = ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;	
   }

public static int GetCellCount(String xlfile , String xlsheet , int rownum) throws IOException {
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	int cellcount = row.getLastCellNum();
	wb.close();
	fi.close();
	return cellcount;	
   }

public static String getCellData(String xlfile , String xlsheet , int rownum ,  int column) throws IOException {
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell = row.getCell(column);
	String data; 
	try {
		DataFormatter formatter = new  DataFormatter();
		String celldata  = formatter.formatCellValue(cell);
		return celldata;
	} 
	  catch (Exception e) { 
		data = "";
	}	
	wb.close();
	fi.close();
	return data;	
  }

public static void setCellData(String xlfile , String xlsheet ,  int rownum , int column , String data ) throws IOException {
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell = row.createCell(column);
	cell.setCellValue(data);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
   }


}


//public class ReadGuru99ExcelFile {
//
//    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
//
//    //Create an object of File class to open xlsx file
//
//    File file =    new File(filePath+"\\"+fileName);
//
//    //Create an object of FileInputStream class to read excel file
//
//    FileInputStream inputStream = new FileInputStream(file);
//
//    Workbook guru99Workbook = null;
//
//    //Find the file extension by splitting file name in substring  and getting only extension name
//
//    String fileExtensionName = fileName.substring(fileName.indexOf("."));
//
//    //Check condition if the file is xlsx file
//
//    if(fileExtensionName.equals(".xlsx")){
//
//    //If it is xlsx file then create object of XSSFWorkbook class
//
//    guru99Workbook = new XSSFWorkbook(inputStream);
//
//    }
//
//    //Check condition if the file is xls file
//
//    else if(fileExtensionName.equals(".xls")){
//
//        //If it is xls file then create object of HSSFWorkbook class
//
//        guru99Workbook = new HSSFWorkbook(inputStream);
//
//    }
//
//    //Read sheet inside the workbook by its name
//
//    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
//
//    //Find number of rows in excel file
//
//    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
//
//    //Create a loop over all the rows of excel file to read it
//
//    for (int i = 0; i < rowCount+1; i++) {
//
//        Row row = guru99Sheet.getRow(i);
//
//        //Create a loop to print cell values in a row
//
//        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//            //Print Excel data in console
//
//            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
//
//        }
//
//        System.out.println();
//    } 
//
//    }  
//
//    //Main function is calling readExcel function to read data from excel file
//
//    public static void main(String...strings) throws IOException{
//
//    //Create an object of ReadGuru99ExcelFile class
//
//    ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
//
//    //Prepare the path of excel file
//
//    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
//
//    //Call read file method of the class to read data
//
//    objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");
//
//    }
//
//}
//Note: We are not using the Testng framework here. Run the class as Java Application using function read excel in Selenium as shown in above example.
//
//Read/Write Data from Excel File in Selenium Webdriver
//Write data on Excel file
//Complete Example: Here we are trying to write data from Excel file by adding new row in Excel file
//
//package excelExportAndFileIO;
