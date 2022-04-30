package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertSelenium {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
	
		
		ChromeDriver driver=new ChromeDriver();
				
		driver.get(" https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		//click on try it button
		driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
		
		//switch to alert
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Madhu");
		alert.accept();
		WebElement eleText = driver.findElement(By.id("demo"));
		String alertext = eleText.getText();
		if(alertext.contains("Madhu")) {
			System.out.println("Alert contains name");
		}else {
			System.out.println("Alert doesnt contain name");
		}
		
		
}
}

