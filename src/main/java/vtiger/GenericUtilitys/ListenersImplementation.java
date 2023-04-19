package vtiger.GenericUtilitys;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, " === test script execution started ===");
		// System.out.println("---Scripted Stsrted---");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		// System.out.println("---Scripted passs---");

		test.log(Status.PASS, methodName + "=== PASS ===");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		// System.out.println("---Scripted failed---");
		test.log(Status.FAIL, methodName + " === FAIL ===");
		test.log(Status.INFO, result.getThrowable());
		// System.out.println(result.getThrowable());

		WebDriverUtility wutil = new WebDriverUtility();
		String ScreenShot = methodName + "-" + new Java_Utility().getSystemDAteInformate();
		try {
			String path = wutil.takeScreenShort(BaseClass.sDriver, ScreenShot);
			test.addScreenCaptureFromPath(path);// go the screenshot location and it will
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName + " === SKIP ===");
		test.log(Status.INFO, result.getThrowable()); // print the exception in report
		// System.out.println("---Scripted Sskipped---");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("--execution start");

		// Extent Report Configuration Report-05 Apr 2023-10-23-45.html
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new Java_Utility().getSystemDAteInformate() + ".html");
		htmlreporter.config().setDocumentTitle("Vtiger Execution report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Automation Execution report");

		report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "FireFox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter-Name", "anji");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--execution fineshed");
		// generate the report
		report.flush();
	}

}
