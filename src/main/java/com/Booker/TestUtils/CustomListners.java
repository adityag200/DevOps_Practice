package com.Booker.TestUtils;



import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Booker.Setup.BaseSetup;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;





public class CustomListners extends BaseSetup implements ITestListener, ISuiteListener
{
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		 
			String exceptionMessage = Arrays.toString(arg0.getThrowable().getStackTrace());
		
			testLog.get().fail("<details>"+ "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see the execption"
				+ "</font>" + "</b>" + "</summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details>"+"\n");
		
		String failureLog ="This Test Case got Failed";
		Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		testLog.get().log(Status.INFO, m);
		
	}

	public void onTestSkipped(ITestResult arg0) {
		

		String methodName = arg0.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case:- "+methodName+ " Skip"+ "/<b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		
		testLog.get().skip(m); 
		
		
	}

	public void onTestStart(ITestResult arg0) {
		
		String methodName = arg0.getMethod().getMethodName();
		
		ExtentTest child = parentTest.get().createNode(methodName);
		testLog.set(child);
		
		//testCaseLogger.get().log(Status.INFO, "Starting execution of Test Case:- "+methodName);
		
		testLog.get().info("<b>"+"Starting execution of Test Case:- "+methodName+ "/<b>");
		
	}

	public void onTestSuccess(ITestResult arg0) {
		
		String methodName = arg0.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case:- " +methodName+ " Passed"+ "/<b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		testLog.get().pass(m);
		
		//extent.flush();
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

}
