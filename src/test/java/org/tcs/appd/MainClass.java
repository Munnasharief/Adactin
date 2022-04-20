package org.tcs.appd;

import java.io.Console;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainClass extends BaseClass{

	public static void main(String[] args) throws InterruptedException, IOException {
		
		browserlaunch("Chrome");
		launchurl("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys(getExcelData(0, 0));
		driver.findElement(By.id("password")).sendKeys(getExcelData(1,0));
		driver.findElement(By.id("login")).click();
		WebElement location = driver.findElement(By.id("location"));
		selectVisibleTxt(location, "London");
		WebElement Hotels = driver.findElement(By.id("hotels"));
		selectVisibleTxt(Hotels, "Hotel Sunshine");
		WebElement roomtype = driver.findElement(By.name("room_type"));
		selectVisibleTxt(roomtype, "Standard" );
		WebElement NumberofRooms = driver.findElement(By.name("room_nos"));
		//NumberofRooms.clear();
		selectIndex(3, NumberofRooms);
		WebElement AdultsperRoom = driver.findElement(By.name("adult_room"));
		//AdultsperRoom.clear();
		selectIndex(2, AdultsperRoom);
		WebElement ChildrenperRoom = driver.findElement(By.name("child_room"));
		//ChildrenperRoom.clear();
		selectIndex(1, ChildrenperRoom);
		WebElement search = driver.findElement(By.name("Submit"));
		click(search);
		WebElement option = driver.findElement(By.name("radiobutton_0"));
		click(option);
		WebElement submit = driver.findElement(By.name("continue"));
		click(submit);
		WebElement FirstName = driver.findElement(By.name("first_name"));
		sendkeys(FirstName, "Munawar");
		WebElement LastName = driver.findElement(By.name("last_name"));
		sendkeys(LastName, "Sharief");
		
		WebElement BillingAddress = driver.findElement(By.name("address"));
		sendkeys(BillingAddress, "101 abc xyz");
		WebElement CreditCardNo = driver.findElement(By.name("cc_num"));
		sendkeys(CreditCardNo, "3216541234562580");
		WebElement CreditCardType = driver.findElement(By.name("cc_type"));
		selectVisibleTxt(CreditCardType, "VISA");
		WebElement ExpiryDate1 = driver.findElement(By.id("cc_exp_month"));
		selectIndex(4, ExpiryDate1);
		WebElement ExpiryDate2 = driver.findElement(By.id("cc_exp_year"));
		selectIndex(4, ExpiryDate2);
		WebElement CVVNumber = driver.findElement(By.name("cc_cvv"));
		sendkeys(CVVNumber, "1234");
		//WebElement BookNow = driver.findElement(By.xpath("//input[@type=button][1]"));//doubt in xpath
		//BookNow.click();
		WebElement BookNow = driver.findElement(By.name("book_now"));
		BookNow.click();
		Thread.sleep(7000);
		WebElement orderid = driver.findElement(By.id("order_no"));
		jsgetattribute(orderid);
		}
	}
