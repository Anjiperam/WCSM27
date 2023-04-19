package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	/*
	 * @Test(dataProvider = "getDate") public void addToCard(String name, int price,
	 * int qlty, String color, boolean isAvailable) { System.out.println(name + "--"
	 * + price + "--" + qlty + "--" + color + "--" + isAvailable); }
	 * 
	 * @DataProvider public Object[][] getDate() { Object[][] data = new
	 * Object[2][5];
	 * 
	 * data[0][0] = "samsung"; data[0][1] = 1200; data[0][2] = 12; data[0][3] =
	 * "Black"; data[0][4] = true;
	 * 
	 * data[1][0] = "redme"; data[1][1] = 1400; data[1][2] = 10; data[1][3] =
	 * "blue"; data[1][4] = false;
	 * 
	 * return data; }
	 */

	@Test(dataProvider = "getExcelDate")
	public void excelDate(String name, String color, int price, int qty) {
		System.out.println(name + "--" + color + "--" + price + "--" + qty);
	}
	@DataProvider
	public Object[][] getExcelDate() {
		Object[][] edata = new Object[3][4];

		edata[0][0] = "Hp";
		edata[0][1] = "black";
		edata[0][2] = 45000;
		edata[0][3] = 143;

		edata[1][0] = "Lenovo";
		edata[1][1] = "Blue";
		edata[1][2] = 54000;
		edata[1][3] = 345;

		edata[2][0] = "Mac";
		edata[2][1] = "Yesh";
		edata[2][2] = 84000;
		edata[2][3] = 34;

		return edata;
	}

}
