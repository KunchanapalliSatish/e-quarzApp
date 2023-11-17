package com.Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReports1 implements IReporter {
	private ExtentReports extent;
	private ExtentTest test1;
	private ExtentSparkReporter spark;
	
	
	//protected ExtentTest Etest;
     File file= new File("Extent.html");

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Extent.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			
			}
		}

		extent.flush();
//         try {
//			Desktop.getDesktop().browse(new File("Extent.html").toURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
//	@AfterClass
//	public void auto() throws Exception {
//		Desktop.getDesktop().browse(new File("Extent.html").toURI());
//		
//	}
	
//
//	public static class ExtentTestManager {
//	    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();
//
//	    public static ExtentTest getTest() {
//	        return extentTestThreadLocal.get();
//	    }
//
//	    public static void setTest(ExtentTest extentTest) {
//	        extentTestThreadLocal.set(extentTest);
//	    }
//
//	    public static void removeTest() {
//	        extentTestThreadLocal.remove();
//	    }
//	}
//
//
//	    public void onTestFailure(ITestResult tr) {
//	        captureScreenshotAndAddToReport(tr);
//	    }
//
//	    private void captureScreenshotAndAddToReport(ITestResult tr) {
//	        // Capture screenshot logic
//	        String screenshotPath = captureScreenshot(tr.getName());
//	        ExtentTestManager.getTest();
//	        ExtentTestManager.getTest().addScreenCapture(screenshotPath);
//	    }
//
//	    private String captureScreenshot(String testName) {
//			return testName;
//	        // Implement your screenshot capture logic here
//	        // You can use WebDriver to take screenshots
//	        // Store the screenshot in a directory and return its path
//	    }
//	}
}


	

	
