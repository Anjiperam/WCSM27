package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPracticeTest {

	@Test(invocationCount = 1, priority = 1)
	public void createUserTest() {
		//Assert.fail();
		System.out.println("i am working createUserTest fine");
	}

	@Test(invocationCount=-1)//enabled=false)
	public void mofifyUserTest() {
		System.out.println("i am working mofifyUserTest fine");
	}

	@Test(dependsOnMethods = "createUserTest")
	public void deleteUserTest() {
		System.out.println("i am working deleteUserTest fine");
	}

}
