package com.pixere.desktop.automation.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;

public class TestWiniumAutomation {
	private WiniumDriver driver;
	private DesktopOptions options;
	private WiniumDriverService service;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		String outlookApplicationPath = "C:\\Windows\\System32\\calc.exe";//C:\Program Files (x86)\TotalImageConverter
	    String winiumDriverPath = "drivers/Winium.Desktop.Driver.exe";
	 
	    options = new DesktopOptions(); //Initiate Winium Desktop Options
	    options.setApplicationPath(outlookApplicationPath); //Set Calc application path
	 
	    File drivePath = new File(winiumDriverPath); //Set winium driver path
	    
	    service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
	    service.start();
	 
	     //Build and Start a Winium Driver service
	    driver = new WiniumDriver(service, options); //Start a winium driver
	}

	@AfterMethod
	public void afterMethod() {
		//service.stop();
		driver.quit();
	}

	@Test
	public void testWiniumAutomation() throws InterruptedException {
		
		Thread.sleep(1000);
	    WebElement calcFrame = driver.findElement(By.name("Calculator"));
	    WebElement menu = driver.findElement(By.id("NavButton"));
	    menu.click();
	    WebElement viewMenu = menu.findElement(By.name("Mode DropDown"));	    
	    viewMenu.findElement(By.name("Standard Calculator")).click();
	    Thread.sleep(1000);
	    calcFrame.findElement(By.id("num8Button")).click();
	    Thread.sleep(1000);
	    calcFrame.findElement(By.id("plusButton")).click();
	    Thread.sleep(1000);
	    calcFrame.findElement(By.id("num6Button")).click();
	    Thread.sleep(1000);
	    calcFrame.findElement(By.id("equalButton")).click();
	    Thread.sleep(1000);
		
	}

}
