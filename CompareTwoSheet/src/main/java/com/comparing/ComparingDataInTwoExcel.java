package com.comparing;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ComparingDataInTwoExcel {
	public static int rowCount1;
	public static int rowCount2;
	public static int cellNum1;
	public static int cellNum2;
	public static String cellValue1;
	public static String cellValue2;
	public static CellStyle style;
	public static Cell cell2;
	public static Workbook wb2;
	public static org.apache.poi.ss.usermodel.Sheet sh1;
	public static org.apache.poi.ss.usermodel.Sheet sh2;
	public static void main(String[] args) {

		//Sheet1
		try {
			FileInputStream fis = new FileInputStream("./Excel/Trail1.xlsx");
			Workbook wb1 = WorkbookFactory.create(fis);
			sh1 = wb1.getSheet("Sheet1");
			rowCount1= sh1.getLastRowNum();
			//cellNum1=sh1.getRow(1).getLastCellNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		//Sheet2
		try {
			FileInputStream fis = new FileInputStream("./Excel/Trail2.xlsx");
			wb2 = WorkbookFactory.create(fis);
			sh2 = wb2.getSheet("Sheet1");
			rowCount2= sh2.getLastRowNum();
			
			
			
			//cellNum2=sh1.getRow(1).getLastCellNum();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if (rowCount1==rowCount2)
		{
			System.out.println("Sheet1 row count "+rowCount1+" ********** "+"Sheet2 rowCount "+rowCount2);
			for (int i = 0; i < rowCount1; i++)
			{
				cellNum1= sh1.getRow(i).getLastCellNum();


			}
			System.out.println("Sheet1 cell count"+cellNum1);
			for (int i = 0; i < rowCount2; i++)
			{
				cellNum2= sh2.getRow(i).getLastCellNum();



			}
			System.out.println("Sheet2 cell count"+cellNum2);

			System.out.println("**************");
			if (cellNum1==cellNum2) 
			{
				//Sheet 1 cell value

				for (int i = 0; i < rowCount1+1; i++) 
				{
					for (int j = 0; j < cellNum1; j++)
					{
						cellValue1=sh1.getRow(i).getCell(j).getStringCellValue();
						System.out.println("Sheet1 cellValue1 "+cellValue1);
					}
					// Sheet2 cell values
					for (int i1 = i; i1 < rowCount2+1;) {
						for (int j = 0; j <cellNum2; j++) {
							cellValue2=sh2.getRow(i1).getCell(j).getStringCellValue();
							System.out.println("Sheet2 cellValue2 "+cellValue2);
						}
						break;
					}
					


					if (cellValue1.equals(cellValue2)) 
					{
						System.out.println("Both cellValues are same");

					}
					else
					{
						System.out.println("both cell values are not same");
						
					}
					System.out.println("**************");
				}


			}
			else 
			{
				System.out.println("Both cellNum are not same");
			}

		}
		else
		{

			System.out.println("Both row count are not same");
		}


	}

}

