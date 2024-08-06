package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * This method is used to read data from excel and give it to data provider or returns the 2 dimensional object array
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */

	public Object[][] fetchAllTheDataFromExcelSheet(String fileName,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(fileName);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(lastRow).getLastCellNum();
		Object[][] arr=new Object[lastRow][lastCell];
		DataFormatter df=new DataFormatter();
		
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			Cell cell=sh.getRow(i+1).getCell(j);
			arr[i][j]=df.formatCellValue(cell).trim();
		}
	}
	wb.close();
		return arr;
	}
	
	
	public String ReadDataFromExcelByUsingKeyProperty(String filePath,String sheetName,String Key) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		DataFormatter df=new DataFormatter();
		String value="";
		for(int i=1;i<=count;i++)
		{
			if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(Key))
			{
			 value=df.formatCellValue(sh.getRow(i).getCell(1)).trim();
			}
		}
		wb.close();
		return value;
	}
	
	public void wrightDataToExcelByUsingKeyProperty(String filePath,String sheetName,String Key,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		DataFormatter df=new DataFormatter();
	
		for(int i=1;i<=count;i++)
		{
			if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(Key))
			{
				String name=df.formatCellValue(sh.getRow(i).getCell(0)).trim();
			 Row rw=sh.createRow(i);
			 Cell cel=rw.createCell(1);
			 Cell cel1=rw.createCell(0);
			 cel.setCellValue(value);
			 cel1.setCellValue(name);
			 FileOutputStream fos=new FileOutputStream(filePath);
			 wb.write(fos);
			
			}
		}
		 wb.close();	 
	}
}