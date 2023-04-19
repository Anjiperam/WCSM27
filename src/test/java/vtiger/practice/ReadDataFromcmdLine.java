package vtiger.practice;

import org.testng.annotations.Test;

public class ReadDataFromcmdLine {
@Test
public void test()
{
	String BROWSER = System.getProperty("browser");
	String URl = System.getProperty("url");
	System.out.println(BROWSER);
	System.out.println(URl);
	
}
}
