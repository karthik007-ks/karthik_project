package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.vtiger.GenericUtils.IPathConstant;

public class ExcelData 
{
	public String getDataFromExcelSheet(String sheetName, String rowName, String ColName) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		int actualRowNum=0;
		for (int i = 0; i < rowNum; i++) 
		{
			String rowText = wb.getSheet(sheetName).getRow(i).getCell(0).getStringCellValue();
			if(rowText.equalsIgnoreCase(rowName))
			{
				actualRowNum=i;
				break;
			}
	    }
		int colNum = wb.getSheet(sheetName).getRow(0).getLastCellNum();
		int actualColNum=0;
		for (int j = 0; j < colNum; j++) 
		{
			String colText = wb.getSheet(sheetName).getRow(0).getCell(j).getStringCellValue();
			if(colText.equalsIgnoreCase(ColName))
			{
				actualColNum=j;
				break;
			}
		}
		return wb.getSheet(sheetName).getRow(actualRowNum).getCell(actualColNum).getStringCellValue();
	}
	public void writeDataInExcelSheet(String sheetName, int row, int col,String text) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCEL_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(text);
		FileOutputStream fos=new FileOutputStream(IPathConstant.EXCEL_PATH);
		wb.write(fos);
		wb.close();
	}
}
