package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;



public class Customer_Service_Options {
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		//Disable notifications in sites
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(options); 
		 //Launch browser
		 driver.get("https://login.salesforce.com/"); 
		 // Implicit Wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 //Maximize window
		 driver.manage().window().maximize();
		 //Enter the user name
		 driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		 //Enter the password
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password$123");
		 //click on the login button
		 driver.findElement(By.xpath("//input[@id='Login']")).click();
		//click on the learn more option in the Mobile publisher
		 driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		//Switch to the next window using Window handles
		 Set<String>WindowHandles=driver.getWindowHandles();
		 List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		 String secondWindowHandles=lstWindowHandles.get(1);
		 driver.switchTo().window(secondWindowHandles);
		      
		 //click on the confirm button in the redirecting page
		 driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		 Thread.sleep(4000);
		 //Click on Products  
		 Shadow sha =new Shadow(driver);
		 WebElement ele=sha.findElementByXPath("//span[@class='nav-item-label--l1']");
		 ele.click();
		 Thread.sleep(2000);
		 // Mouse hover on Service
		 Shadow sha1 =new Shadow(driver);
		 WebElement ele1= sha1.findElementByXPath("//span[text()='Service']");
		   ele1.click();
		   Thread.sleep(2000);
		 //Click on Customer Services 
		      Shadow sha2 =new Shadow(driver);
				 WebElement ele2= sha2.findElementByXPath("//a[text()='Customer Service']");
				 ele2.click();
				 Thread.sleep(2000);
		//Get the names Of Services Available
				 List<WebElement> lst = driver.findElements(By.className("header-text"));
				 for(int i=3;i<12;i++)
				 {
					 System.out.println(lst.get(i).getText());
				 }
		//Verify the Title
				 String name =driver.getTitle();
				 System.out.println(name);
		       if(name.equals("Customer Service Tools from Service Cloud - Salesforce.com")) {
		    	   System.out.println("The title of the page is verified");
		       }
	}}
		    	   
	
		       
