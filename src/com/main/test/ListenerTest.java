package com.main.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.*;

public class ListenerTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			GetScreenShots.captureScreenShots(result.getName());
		} catch (Exception e) {
			
		}
		System.out.println(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//ReadExcelSheetsData.writeInExcelFile(filePath, sheetName, row, column, status);
		System.out.println("Test case has skipped...");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test starts here...");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test has finished...");
		
	}

}
