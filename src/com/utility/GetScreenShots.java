package com.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.main.test.MainTest;

public class GetScreenShots extends MainTest{
	
	public static void captureScreenShots(String screenShtotName) throws Exception{
		try {
			Thread.sleep(3000);
			//take a screen shot
			TakesScreenshot ts = (TakesScreenshot)driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File("./ScreenShots/"+screenShtotName+".png"));
			System.out.println("Screenshot taken");		
		} catch (InterruptedException e) {
		
		}
	}
}
