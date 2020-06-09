package com.comparing;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetBackgroundColor {
public static void main(String[] args) {
	try {
		FileInputStream fis= new FileInputStream("./Excel/sheet1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet2");
	    Cell cell = sh.createRow(1).createCell(0);
	    cell.setCellValue("Raghu");
	    CellStyle style = wb.createCellStyle();
	    style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
		
		FileOutputStream fos = new FileOutputStream("./Excel/sheet1.xlsx");
		wb.write(fos);
		System.out.println("color added");
		
		

	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
