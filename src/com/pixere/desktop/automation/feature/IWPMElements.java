package com.pixere.desktop.automation.feature;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriver;

import com.pixere.desktop.automation.test.utility.Config;

public class IWPMElements {

	WiniumDriver driver;
	Actions action;
	@FindBy(name = "Documents")
	WebElement menu_Document;
	@FindBy(name = "Open...")
	WebElement subMenu_Open;
	@FindBy(id = "853")
	WebElement drive_DropDown;
	@FindBy(id = "857")
	WebElement directoryList;
	@FindBy(id = "859")
	WebElement listFileName;
	@FindBy(name = "Save as...")
	WebElement subMenu_SaveAs;
	@FindBy(id = "256")
	WebElement btn_WelComeOK;
	@FindBy (name = "D:")
	WebElement drive_D;
	@FindBy (name = "Test-Wayne-ImageSamples +")
	WebElement folder_ImageSamples;
	@FindBy (name = "ConvertedFiles +")
	WebElement folder_SaveSamplesImages;
	@FindBy(id = "851")
	WebElement txt_FileName;
	@FindBy(id = "1")
	WebElement btn_OkOpenFileDialog;




	public IWPMElements(WiniumDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Functions to Open File and Select File to Open
	 * @throws InterruptedException 
	 */

	public void selectFileToOpenAndSaveToTIFF() {
		WebDriverWait wait = new WebDriverWait(driver, Config.DEFAULT_IMPLICIT_WAIT_TIMEOUT);
		/*wait.until(ExpectedConditions.elementToBeClickable(btn_WelComeOK));
		btn_WelComeOK.click();*/
		//wait.until(ExpectedConditions.elementToBeClickable(menu_Document));
		menu_Document.click();
		wait.until(ExpectedConditions.elementToBeClickable(menu_Document));
		subMenu_Open.click();
		wait.until(ExpectedConditions.elementToBeClickable(drive_DropDown));
		drive_DropDown.click();
		drive_D.click();

		action = new Actions(driver).doubleClick(folder_ImageSamples);
		action.build().perform();
		File folder = new File(Config.getimageLocationPath());
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(txt_FileName));
			txt_FileName.clear();
			txt_FileName.clear();
			txt_FileName.sendKeys(listOfFiles[i].getName());
			btn_OkOpenFileDialog.click();
			// File Save 
			wait.until(ExpectedConditions.elementToBeClickable(menu_Document));
			menu_Document.click();
			wait.until(ExpectedConditions.elementToBeClickable(subMenu_SaveAs));
			subMenu_SaveAs.click();
			// Save File Location
			if (i == 0 ){
				wait.until(ExpectedConditions.elementToBeClickable(drive_DropDown));
				drive_DropDown.click();
				drive_D.click();			
				action = new Actions(driver).doubleClick(folder_SaveSamplesImages);
				action.build().perform();
			}
			wait.until(ExpectedConditions.elementToBeClickable(txt_FileName));
			txt_FileName.clear();
			txt_FileName.clear();
			txt_FileName.clear();
			txt_FileName.sendKeys(listOfFiles[i].getName());
			btn_OkOpenFileDialog.click();
			if (i < listOfFiles.length ){
				menu_Document.click();
				wait.until(ExpectedConditions.elementToBeClickable(menu_Document));
				subMenu_Open.click();
			}
		}
	}

}
