package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
/**
 * this method used to read data from excel by specifying sheetname,row number and cell no
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @return cell String value
 * @throws Throwable
 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	FileInputStream file=new FileInputStream(IPathConstant.EXCEL_PATH);
	Workbook workbook=WorkbookFactory.create(file);
	Sheet sheet=workbook.getSheet(sheetName);
	Row row=sheet.getRow(rownum);
	Cell cell=row.getCell(cellnum);
	return cell.getStringCellValue();
	}
	
}