package Week4Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//open frames page and maximize
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		//Selecting  frame 1
		driver.switchTo().frame("frame1");
		
		//In the frame 1 select topic and enter value
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("selenium");
		
		//Switching to the inner frame
		driver.switchTo().frame("frame3");
		
		//clicking the checkbox in inner frame
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//Switching to the default frame
		driver.switchTo().defaultContent();
		
		//Switching to another frame frame 2
		driver.switchTo().frame("frame2");
		
		//In the frame 2 selecting the "avatar" from drop down by giving index 
		WebElement dd=driver.findElement(By.id("animals"));
		Select dropdown=new Select(dd);
		dropdown.selectByIndex(3);
		
		//switching back to parent frame
		driver.switchTo().parentFrame();
	}

}
