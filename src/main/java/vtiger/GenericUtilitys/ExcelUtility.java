package vtiger.GenericUtilitys;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is contain generic methods related to Excel file
 * 
 * @author Anji
 *
 */
public class ExcelUtility {
	/**
	 * this method will read date from ExcelFile
	 * 
	 * @param Organization
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getExcelData(String Organization, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook vb = WorkbookFactory.create(fis);
		Sheet st = vb.getSheet(Organization);
		DataFormatter df = new DataFormatter();
		String result = df.formatCellValue(st.getRow(rowNum).getCell(cellNum));
		return result;
	}
	/**
	 * this will method will read data  excel sheet and return  it to  data provider  
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readDataFromExcelToDataprovide(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook vb = WorkbookFactory.create(fis);
		Sheet sh = vb.getSheet(SheetName);
		int lastRowNum = sh.getLastRowNum();
		short lastCellNum = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRowNum][lastCellNum];

		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}

		return data;
	}
}
