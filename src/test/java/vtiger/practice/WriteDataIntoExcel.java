package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook vb = WorkbookFactory.create(fis);
		Sheet sh = vb.getSheet("Organization");
		Row r = sh.getRow(1);
		Cell cel = r.createCell(10);
		cel.setCellValue("peram anjaneyulu");

		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		vb.write(fos);
		System.out.println("data added");
		vb.close();

	}

}
