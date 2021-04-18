package Webdriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Provider;
import java.util.Random;

public class demo19_ReadWriteTXT_CSV_HTML_Files {

	public static void main(String[] args) throws IOException {
        //With these methods we cannot access or write data at a specified location in the file.These are best to read write whole file
		//Write TXT File--------------------------------------------------------------
		//Provider directory path
		File file=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\jars for Selenium Upskill\\Project Excel files\\WritingTextFile.txt");
		// create file and chain it to previous
		FileWriter fw =new FileWriter(file,false);  //true parameter appends data in same file if already same name file is present, false overwrites the file
		// write in file and chain it to previous
		BufferedWriter bw=new BufferedWriter(fw);
		//write some data
		System.out.println("writing in text file");
		bw.write("Sanjay");
		bw.newLine();
		bw.write("Testing");
		bw.newLine();
		

		//write some numbers in table format
		for (int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				Integer num=(int)( Math.random()*100);
				bw.write(num+"\t");
				//System.out.println(num+"\t");
			}
			bw.newLine();
		}
		bw.close();

	
	//Write CSV File------------------------------------------------------------------
		//Provider directory path
	File file1=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\jars for Selenium Upskill\\Project Excel files\\WritingCSVFile.csv");
	// create file and chain it to previous
	FileWriter fw1 =new FileWriter(file1,false);
	// write in file and chain it to previous
	BufferedWriter bw1=new BufferedWriter(fw1);
	//write some data
	System.out.println("writing in csv file");
	bw1.write("Sanjay");
	bw1.newLine();
	bw1.write("Testing");
	bw1.newLine();

	//write some numbers in table format
	for (int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			Integer num=(int)( Math.random()*100);
			bw1.write(num+",");  //instead of tab key use comma
			//System.out.println(num+"\t");
		}
		bw1.newLine();
	}
	bw1.close();
	
	
	
	//Write HTMLFile------------------------------------------------------------------
			//Provider directory path
	File file2=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\jars for Selenium Upskill\\Project Excel files\\WritingHtmlFile.html");
	// create file and chain it to previous
	FileWriter fw2 =new FileWriter(file2,false);
	// write in file and chain it to previous
	BufferedWriter bw2=new BufferedWriter(fw2);
	//write some data
	System.out.println("writing in Html file");
	bw2.write("<html> <body> <title> I am the best </title> <h1> you read it correct </h1> </body> </html>");
	bw2.close();
	
	//Read TXT, CSV and HTML File------------------------------------------------------------------
	//Provider directory path
	File file3=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\jars for Selenium Upskill\\Project Excel files\\WritingCSVFile.csv");
	FileReader fr =new FileReader(file3);
	BufferedReader br =new BufferedReader(fr);
	System.out.println("reading from text file");
	//br.readLine();
	//br.readLine();
	String line=br.readLine();
	while(line!=null)
	{
		System.out.println(line);
	}
	br.close();
		
	
}
	
}
