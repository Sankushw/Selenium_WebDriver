package Webdriver;

import java.io.File;
import java.io.IOException;

import com.google.common.collect.Table.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class demo16_ExcelUsing_JXL {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException, BiffException {

		//Write the XLS file----------------------------------------------------------------
		//to points to that location
		File fexcel= new File("C:\\Users\\IBM_ADMIN\\Desktop\\Test123.xls");
		//fexcel.createNewFile();

		//to create a workbook and chain it to previous step
		WritableWorkbook writebook = Workbook.createWorkbook(fexcel);   //workbook cannot be instantiated

		//create a sheet with sheet name
		writebook.createSheet("Training", 0);

		//write some data in sheet
		WritableSheet writesheet= writebook.getSheet(0);
		Label testdata1= new Label(0,0,"Sanjay");
		writesheet.addCell(testdata1);

		Label testdata2= new Label(0,1,"Star");
		writesheet.addCell(testdata2);

		//to write the data
		writebook.write();

		
		//Read the XLS file----------------------------------------------------------------
		File fexcel1= new File("C:\\Users\\IBM_ADMIN\\Desktop\\Test123.xls");
		Workbook wb= Workbook.getWorkbook(fexcel1);
		Sheet sheet=null;
		jxl.Cell cell=null;
		//find how many sheets are there
		int noOfSheets=wb.getNumberOfSheets();
		String[] sheetNames=wb.getSheetNames(); //to get names of all sheets
		System.out.println("no fo sheets= "+noOfSheets+"  name of sheets= "+sheetNames);
 
		//to access some specific lines
		Sheet s=wb.getSheet(0);
		s.getCell(0, 0);

		//iterate through the sheets to get all data
		for(int p=0; p<noOfSheets; p++)
		{

			sheet=wb.getSheet(p);
			//fetch the no.of rows and columns
			int noOfRows=sheet.getRows();
			int noOfColumns=sheet.getColumns();
			System.out.println("number of rows= "+noOfRows+"number of columns= "+noOfColumns);

			//fetch data from sheets
			for(int i=0; i<noOfRows; i++)
			{
				for(int j=0; j<noOfColumns; j++)
				{

					cell=sheet.getCell(j,i);
					if(cell.getContents().length()>0)
					{
						System.out.println(cell.getContents());
					}
				}
			}

		} wb.close();
	}
}
