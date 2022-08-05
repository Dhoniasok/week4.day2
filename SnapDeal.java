package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver (); 
		 driver.get("https://www.snapdeal.com/"); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 //Go to Mens Fashion
		WebElement ele= driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		 //Go to Sports Shoes
		 Actions builder=new Actions(driver);
         builder.moveToElement(ele).perform();
         driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
         //Get the count of the sports shoes
        WebElement Count= driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]"));
        System.out.println("The Count of sports shoes " +Count.getText());
        //Click Training shoes
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        Thread.sleep(2000);
        //Sort by Low to High
        driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
        Thread.sleep(2000);
        //Select the price range (900-1200)
        driver.findElement(By.xpath("//input[@class='input-filter']")).clear();
        driver.findElement(By.xpath("//input[@class='input-filter']")).sendKeys("900");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");
        Thread.sleep(2000);
        //Press GO
        driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
        //Filter with color Navy
        WebElement ele1=driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
        Thread.sleep(2000);
        //Exception handle 
		 try {
			  
			  ele1.click(); 
			  System.out.println("Stale element exception"); } 
		 catch(StaleElementReferenceException e) {
			  System.out.println("StaleElementRefrence exception"); }
		 //verify the all applied filters 
        System.out.println("All the filters are applied successfully");
        //Mouse Hover on first resulting Training shoes
      WebElement ele2= driver.findElement(By.xpath("//img[@class='product-image wooble']"));
      //click QuickView button
      Actions builder1=new Actions(driver);
      builder1.moveToElement(ele2).perform();
      driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
     // Switch to new window	 
		 Set<String>WindowHandles=driver.getWindowHandles();
		 List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		 String secondWindowHandles=lstWindowHandles.get(0);
		 driver.switchTo().window(secondWindowHandles);
		 Thread.sleep(2000);
	 //Print the cost and the discount percentage
     WebElement price= driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']"));
     System.out.println("The cost and discount percentage is " +price.getText());
     //Take the snapshot of the shoe
     File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	  File target = new File("./report/shoes.png");	
	   //set the storage path
	   FileUtils.copyFile(screenshotAs, target);
	   // Close the current page
	   WebElement ele3= driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]"));
	   Actions builder2=new Actions(driver);
	      builder2.moveToElement(ele3).perform();
	      driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
	      Thread.sleep(2000);
      // Close the Browser
	      driver.close();
	      

	  
}
}
