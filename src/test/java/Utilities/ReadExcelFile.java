package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("C://Users//2150757//eclipse-workspace//Make_My_Trip//DemoData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//Booking_Detail
		int No_of_Sheet = workbook.getNumberOfSheets();
		System.out.println("Total Number of sheet:- "+No_of_Sheet);
		for(int i=0; i<No_of_Sheet;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Booking_Detail")) {
				
			   XSSFSheet worksheet = workbook.getSheetAt(i);
			   
			   //Identify TestCase columns by scanning the entire 1st row
			   Iterator<Row> row = worksheet.iterator(); //WorkSheet is a Collection of rows
			   Row firstRow = row.next();
			   Iterator<Cell> cell = firstRow.cellIterator();//firstRow is a Collection of cells
			   int counter=0;
			   int column=0;
			  
			   while (cell.hasNext()) { //hasNext will check if there is any cell present in front if yes it will move to that cell
				   Cell cellValue = cell.next();
				   //System.out.println(cellValue.getStringCellValue());
				   if(cellValue.getStringCellValue().equalsIgnoreCase("Booking Details")) {
					   //desire cell
					   System.out.println(cellValue.getStringCellValue());
					   column=counter;	
				   }
				   counter++;
			}
			   System.out.println(column);
			
			   //once columns is identified then scan entire testcase column to identify purchase testcase row
			   
			   while(row.hasNext()) {
				   Row row_value = row.next();
				   if(row_value.getCell(column).getStringCellValue().equalsIgnoreCase("Booking Details")) {
					  Iterator<Cell> cells_value = row_value.cellIterator();
					  while (cells_value.hasNext()) {
						System.out.println(cells_value.next().getStringCellValue());
					}
				   }
			   }
			}
		}
	}


}
