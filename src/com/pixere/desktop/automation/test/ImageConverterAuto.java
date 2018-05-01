package com.pixere.desktop.automation.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pixere.desktop.automation.feature.IWPMElements;
import com.pixere.desktop.automation.test.utility.Config;

public class ImageConverterAuto {
	private WiniumDriver driver;
	private DesktopOptions options;
	private WiniumDriverService service;
	private IWPMElements iwpmeElements;

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {

		options = new DesktopOptions(); // Initiate Winium Desktop Options
		options.setApplicationPath(Config.getimageConverterLocationPath()); // Set application path

		File drivePath = new File(Config.getwiniumDriverPath()); // Set winium driver path
		service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999)
				.withVerbose(true).withSilent(false).buildDesktopService();
		if (service.isRunning()) {
			
			service.stop();
		} else {
			service.start();
		}

		// Build and Start a Winium Driver service
		driver = new WiniumDriver(service, options); // Start a winium driver
		Thread.sleep(5);
		iwpmeElements = new IWPMElements(driver);

	}

	@AfterMethod
	public void afterMethod() {
		// service.stop();
		driver.quit();
	}

	@Test
	public void testWiniumAutomation() throws InterruptedException {
		
		iwpmeElements.selectFileToOpenAndSaveToTIFF();	

	}

}
