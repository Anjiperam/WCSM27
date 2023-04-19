package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyzerPractice {
	@Test(retryAnalyzer=vtiger.GenericUtilitys.RetryAnalyzerImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("I am Working");	
	}

}
