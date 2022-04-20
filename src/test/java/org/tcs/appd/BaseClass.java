package org.tcs.appd;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void browserlaunch(String browser) {
     
	switch (browser) {
	case "Chrome":
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP 15\\Desktop\\Documents\\Selenium JAR\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		break;
	case "Firefox":
		System.setProperty("webdriver.gecko.driver", "\\Users\\HP 15\\eclipse-Sample\\SeleniumFirefox\\DriverFirefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	default:
		System.out.println("This is not a valid browser");
		break;
	}
	}
    
	public static void launchurl(String url) {
		
	driver.get(url);
	
	}
 
	public static void sendkeys(WebElement username, String data) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOf(username));
    username.sendKeys(data);
	}
	
	public static WebElement findelementbyid(String id) {
		return driver.findElement(By.id(id));
		}
	public static WebElement findElementByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public static void click(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	

	public static void getAttribute(WebElement element) {
		String data = element.getAttribute("value");
		System.out.println(data);

	}

	public static void Actionclk(WebElement element) {
		Actions acc = new Actions(driver);
		acc.contextClick(element).perform();
	}

	public static void robotKey(int a) throws AWTException {
		Robot rr = new Robot();
		for (int i = 1; i <= a; i++) {
			rr.keyPress(KeyEvent.VK_DOWN);
			rr.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public static void dragAndDrop(WebElement element, WebElement elements) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(element, elements).perform();

	}

	public static void dropDownAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String data = options.get(i).getText();
			System.out.println(data);

		}
	}

	public static void selectValue(String data, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(data);
	}
	

	public static void selectVisibleTxt( WebElement string, String data) {
		Select s = new Select(string);
		s.selectByValue(data);
	}

	public static void selectIndex(int  data, WebElement element) {
		Select s = new Select(element);
		s.selectByIndex(data);
	}

	public static void ss() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Juitworkout\\screenshots\\Ss.jpg");
		FileHandler.copy(Source, dest);
	}
	

	public static void Alerts(String alert) {

		Actions acc = new Actions(driver);

		switch (alert) {

		case ("simple"):
			driver.switchTo().alert().accept();
			break;
		case ("context"):
			driver.switchTo().alert().dismiss();
			break;

		}
	}

	public static void promptAlert(String data) {

		Alert d = driver.switchTo().alert();
		d.sendKeys(data);
		d.accept();

	}

	public static void doubleclk(WebElement element) {
		Actions s = new Actions(driver);
		s.doubleClick(element);

	}

	public static void mouseOver(WebElement element) {
		Actions acc = new Actions(driver);
		acc.moveToElement(element).perform();
	}

	public static void scroll(int a) {
		if (a == 1) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,6500)");

		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-6500)");
		}

	}

	public static void jS(String values, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + values + "')", element);
		js.executeScript("arguments[0].setAttribute('value','" + values + "')", element);

	}

	public static void jsgetattribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object data =  js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(data);
	}

	public static void windowId() {

		String data = driver.getWindowHandle();
		System.out.println(data);

		Set<String> data1 = driver.getWindowHandles();
		System.out.println(data1);
	}

	public static void selectDropDownIndex(WebElement element, int id) {
		new Select(element).selectByIndex(id);
	}

	public static void selectDropDownValue(WebElement element, String name) {
		Select select = new Select(element);
		select.selectByValue(name);
	}

	public static String sendtestData(WebElement element ,String key) throws FileNotFoundException {
		// File f = new File("./target/props.properties");
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Cucumberproject\\src\\test\\resources\\login.Properties");
		FileReader reader = new FileReader(f);
		Properties prop = new Properties();
		try {
			prop.load(reader);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		String k =  prop.getProperty(key);
		element.sendKeys(k);
		return k;
		
	}
	public static String getExcelData(int string, int string2) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(string);
				Cell cell = row.getCell(string2);
				value = cell.getStringCellValue();
			return value;
	}
	public static int getrowcount() throws IOException {
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		int noofRows = sh.getPhysicalNumberOfRows();
		return noofRows;
	}
	public static int getCellcount() throws IOException {
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		 Row row = sh.getRow(0);
		int rows = sh.getPhysicalNumberOfRows();
		int noofcolumns = row.getPhysicalNumberOfCells();
		return noofcolumns;
		
	}

	public static  void WriteExcel( int i,int j) throws IOException {
		
		List<WebElement> data = driver.findElements(By.tagName("td"));
		for (int n = 0; n < data.size(); n++) {
			String tableData = data.get(n).getText();
			System.out.println(tableData);
		
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet s = wb.createSheet("aar");
		Row r = s.createRow(n);
		Cell c = r.createCell(j);
		 c.setCellValue(tableData);
		 FileOutputStream ot = new FileOutputStream(f);
		 wb.write(ot);
		 wb.close();
		
	}}
		
	public static String readbyExcel(int i, int j) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		value = cell.getStringCellValue();
		return value;
	}

	
//	public static void selectByIndex(WebElement element,int index) {
//		Select s = new Select(element);
//		s.selectByIndex(index);
//	}
		public static String getDateFromExcel(int i, int j) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\HP 15\\Desktop\\New folder\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(i);
				Cell cell = row.getCell(j);
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
					value = sc.format(dateCellValue);			
					}
				return value;
	}
	public static void tableData() {
		
		List<WebElement> data = driver.findElements(By.tagName("td"));
		for (int i = 0; i < data.size(); i++) {
			String tableData = data.get(i).getText();
			System.out.println(tableData);			
		}
	}
}