package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver (); 
		 driver.get(" https://www.nykaa.com/"); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 //Mouse over on Brands and Search L'Oreal Paris
		 WebElement ele =driver.findElement(By.xpath("//a[text()='brands']"));
		// Actions
		 Actions builder=new Actions(driver);
         builder.moveToElement(ele).perform();
         // Click L'Oreal Paris
         driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();
         //Check the title contains L'Oreal Paris
         System.out.println(driver.getTitle());
         //Click sort By and select customer top rated
         driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
         driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
         //Click Category and click Hair->Click hair care->Shampoo
         driver.findElement(By.xpath("//span[text()='Category']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//span[text()='Hair']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
         Thread.sleep(2000);
         //Click->Concern->Color Protection
         driver.findElement(By.xpath("//span[text()='Concern']")).click();
         driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
         Thread.sleep(2000);
         //check whether the Filter is applied with Shampoo
        WebElement name=  driver.findElement(By.xpath("//span[text()='Shampoo']"));
        System.out.println(name.getText());
       //Click on L'Oreal Paris Colour Protect Shampoo
       driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
       //GO to the new window and select size as 175ml
       Set<String>WindowHandles=driver.getWindowHandles();
	   List<String>lstWindowHandles=new ArrayList<String>(WindowHandles);
		String secondWindowHandles=lstWindowHandles.get(1);
		driver.switchTo().window(secondWindowHandles);
        
		//and select size as 175ml
		WebElement SIZE=driver.findElement(By.xpath("//select[@title='SIZE']"));
        Thread.sleep(1000);
		Select select = new Select(SIZE);
		select.selectByVisibleText("175ml");  
		//Print the MRP of the product
		WebElement price=driver.findElement(By.xpath("//span[@class='css-1jczs19']"));
		String msd=price.getText();
		System.out.println("The MRP is " +msd);
		//Click on ADD to BAG
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']")).click();
		Thread.sleep(5000);
		// Print the Grand Total amount
		driver.switchTo().frame(0);
		WebElement Grandprice=driver.findElement(By.xpath("(//div[@class='value'])[4]"));
	    String str =Grandprice.getText().replaceAll("₹","");
	    System.out.println("Grand Total is " +str);
		Thread.sleep(2000);
		//Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		//Check if this grand total is the same in step 14
		WebElement Grandprice1=driver.findElement(By.xpath("//span[text()='259']"));
		String prc = Grandprice1.getText();
		if(prc.equals(str)) {
			System.out.println("The price is same");
		}else
		{
			System.out.println("The price is not same");
		}
		
		//close the all windows
		driver.quit();


}
}