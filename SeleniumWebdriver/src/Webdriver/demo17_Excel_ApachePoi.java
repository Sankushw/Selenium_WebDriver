package Webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demo17_Excel_ApachePoi {

	public static void main(String[] args) throws IOException {

		//access the excel file
		File file =new File("C:\\Users\\IBM_ADMIN\\Desktop\\ApachePOI_test.xlsx");

		//open it and chain it to previous step
		FileInputStream fis= new FileInputStream(file);
		//interfaces of apachepoi---xssf is used to work with xlsx format and ----hssf is ud=sed to work with xls format
		//to open the workbook in the excel file
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		//open the sheet with name or index
		XSSFSheet sheet=wb.getSheetAt(0);

		
		//to get text from sheet
		String data1=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("data in the 0th row 0th column= "+data1);

		String data2=sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println("data in the 0th row 1st column= "+data2);
		

		//to get all data from sheet at once
		int rowcount= sheet.getLastRowNum();
		
		for(int i=0; i<=rowcount;i++)
		{
			//this is for column count at run time
			int columncount= sheet.getRow(i).getLastCellNum();

			for(int j=0;j<columncount;j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}

		}
		wb.close();
	}

}
