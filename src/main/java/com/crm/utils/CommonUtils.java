package com.crm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.crm.base.BasePage;

public class CommonUtils extends BasePage{
	
	public CommonUtils(WebDriver driver) {
		super(driver);
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIMEOUT = 10;
	public static long EXPLICIT_WAIT_TIMEOUT = 30;

	XSSFWorkbook xwb;
	XSSFSheet xsheet;
	OPCPackage pkg;

	public Object[][] getTestData(String sheetName) {
		try {
			pkg = OPCPackage.open("src/main/java/com/crm/TestData.xlsx");
			xwb = new XSSFWorkbook(pkg);
			xsheet = xwb.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

		Object[][] data = new Object[xsheet.getPhysicalNumberOfRows()][xsheet.getRow(0).getPhysicalNumberOfCells()];

		for (int i = 1; i < xsheet.getLastRowNum(); i++) {
			for (int j = 0; j < xsheet.getRow(0).getPhysicalNumberOfCells(); j++) {
				data[i][j] = xsheet.getRow(i).getCell(j);
			}
		}

		return data;
	}
	
	public void takeScreenShot() {
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("test-output/screenshots/"+System.currentTimeMillis()+".png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
