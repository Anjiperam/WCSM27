package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {

	public String getExcelData(String Organization,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
	Workbook vb = WorkbookFactory.create(fis);
	Sheet st = vb.getSheet(Organization);
	DataFormatter df = new DataFormatter();
	String result = df.formatCellValue(st.getRow(rowNum).getCell(cellNum));
	return result;


	}

}
