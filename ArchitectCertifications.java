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

public class ArchitectCertifications {
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
		 //  Choose Your Role as Sales force Architect      
         Actions builder=new Actions(driver);
         builder.moveToElement(driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[2]"))).perform();
          driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[2]")).click();
		 Thread.sleep(2000); 
		//Get the Text(Summary) of Sales force Architect
		 WebElement name=driver.findElement(By.xpath("//div[(@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large')]"));
		 System.out.println(name.getText());
			 Thread.sleep(2000);
           //(//img[@class='roleMenu-item_img'])[2]
          //(//div[(@class='roleMenu-item_text')])[2]']
		//Get the List of Sales force Architect Certifications Available
		List<WebElement> lst = driver.findElements(By.className("credentials-card_title"));
        System.out.println('\n'+"SALESFORCE ARCHITECT CERTIFICATES " );
			 for(int i=0;i<lst.size();i++)
			 {
				 System.out.println(lst.get(i).getText());
			 }
		 //Click on Application Architect
		 driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		 //Get the List of Certifications available
		 List<WebElement> lst1 = driver.findElements(By.className("credentials-card_title"));
		 System.out.println('\n'+"APPLICATION CERTIFICATE ");
			 for(int i=0;i<lst1.size();i++)
			 {
				 System.out.println(lst1.get(i).getText());
			 }
}
}
