package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {
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
		 Thread.sleep(2000);
		//Click on Learnings 
		 Shadow sha =new Shadow(driver);
		 WebElement ele=sha.findElementByXPath("//span[text()='Learning']");
		 ele.click();
		 Thread.sleep(2000);
		 //mouse over to Learning on Trail head
		 Shadow sha1 =new Shadow(driver);
		 WebElement ele1= sha1.findElementByXPath("//span[text()='Learning on Trailhead']");
		 ele1.click();
		      Thread.sleep(2000);
		 //Select SalesForce Certification Under Learnings   
		 Shadow sha2 =new Shadow(driver);
	     WebElement ele2= sha2.findElementByXPath("//a[text()='Salesforce Certification']");
			ele2.click();
			Thread.sleep(2000); 
		 //Click on Sales force Certifications
		      Actions builder=new Actions(driver);
	            builder.moveToElement(driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[1]"))).perform();
	            driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[1]")).click();
				 Thread.sleep(2000);
		// Verify the Certifications available for Administrator Certifications should be displayed
				 List<WebElement> lst1 = driver.findElements(By.className("credentials-card_title"));
				 System.out.println('\n'+"THE CERTIFICATES ");
				 for(int i=0;i<lst1.size();i++)
				 {
					 System.out.println(lst1.get(i).getText());
				 }
				 
				


}
}
