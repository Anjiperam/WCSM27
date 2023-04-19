package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void practice()
	{
		System.out.println("test1");
		System.out.println("test2");
		Assert.assertTrue(true);
		Assert.assertEquals(false, true);
		System.out.println("test3");
		System.out.println("test4");
	}
	@Test
	public void practice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("test1- practice");
	//	sa.assertTrue(false);
		sa.assertEquals("a","a");
		System.out.println("test2-practice");
	//	Assert.assertTrue(false);
		System.out.println("test3-practice");
	//	sa.assertTrue(false);
		System.out.println("test4-practice");
		sa.assertAll();
	}

}
