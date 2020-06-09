package com.comparing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestingComparision {
	public static int rowCount1;
	public static int rowCount2;
	public static int cellNum1;
	public static int cellNum2;
	public static String cellValue1;
	public static String cellValue2;
	public static CellStyle style;
	public static Cell cell2;
	public static Workbook wb2;
	public static Sheet sh1;
	public static Sheet sh2;
	public static void main(String[] args) {

		//Sheet1
		try 
		{
			FileInputStream fis = new FileInputStream("./Excel/Test1.xlsx");
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
		try 
		{
			FileInputStream fis = new FileInputStream("./Excel/Test2.xlsx");
			wb2 = WorkbookFactory.create(fis);
			sh2 = wb2.getSheet("Sheet2");
			rowCount2= sh2.getLastRowNum();



			//cellNum2=sh1.getRow(1).getLastCellNum();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if (rowCount1==rowCount2)
		{
			System.out.println("Sheet1 row count is "+rowCount1+" ********** "+"Sheet2 rowCount is "+rowCount2);
			/*	for (int i = 0; i < rowCount1; i++)
			{
				cellNum1= sh1.getRow(i).getLastCellNum();

			}
			System.out.println("Sheet1 cell count is"+cellNum1);
			for (int i = 0; i < rowCount2; i++)
			{
				cellNum2= sh2.getRow(i).getLastCellNum();

			}*/
			int lastCellNum1=sh1.getRow(0).getLastCellNum();
			int lastCellNum2=sh2.getRow(0).getLastCellNum();
			System.out.println(lastCellNum1);
			System.out.println(lastCellNum2);
			System.out.println("**************");
			if (lastCellNum1==lastCellNum2) 
			{
				//Sheet 1 cell value
				int iC = 0;
				for (int i = 0; i <= rowCount1; i++) 
				{
					iC++;
					int jC = 0;
					for (int j = 0; j < lastCellNum1; j++)
					{
						jC++;
						System.out.println("--------- "+iC+" "+jC+"-------------");
						try 
						{
							cellValue1=sh1.getRow(i).getCell(j).getStringCellValue();
							cellValue2=sh2.getRow(i).getCell(j).getStringCellValue();
							System.out.println("Sheet1 cellValue1 = "+cellValue1);
							System.out.println("Sheet2 cellValue2 = "+cellValue2);
							if (cellValue2.equals(cellValue1))
							{
								System.out.println("Both cellValues are same");
							}
							else
							{
								System.out.println("both cell values are not same");
								try 
								{
									CellStyle style = wb2.createCellStyle();
									style = wb2.createCellStyle();
									style.setFillForegroundColor(IndexedColors.RED.getIndex());
									style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
									cell2=sh2.getRow(i).getCell(j);
									cell2.setCellStyle(style);
									FileOutputStream fos = new FileOutputStream("./Excel/Test2.xlsx");
									wb2.write(fos);

									System.out.println("color added");
								}
								catch (Exception e) 
								{
									e.printStackTrace();
								}
							}
						}
						catch (NullPointerException e)
						{
							System.out.println("both cell values are not same");
							System.out.println("Sheet1 cellValue1 = "+cellValue1);
							System.out.println("Sheet2 cellValue2 = "+"Null");
							try 
							{
								CellStyle style = wb2.createCellStyle();
								style = wb2.createCellStyle();
								style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
								style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
								sh2.getRow(i).createCell(j).setCellValue("NULL");
								cell2=sh2.getRow(i).getCell(j);
								cell2.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream("./Excel/Test2.xlsx");
								wb2.write(fos);
								System.out.println("NULL Value is written");
							} 
							catch (Exception e1) 
							{
								e1.printStackTrace();
							}

						}
					}
				}


				try 
				{
					wb2.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
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

