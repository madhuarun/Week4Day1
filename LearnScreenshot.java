package Week4Day1;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnScreenshot {
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//open frames page 
		driver.get("http://leafground.com/pages/frame.html");
		//maximize the current web page 
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//go to frame 0
		driver.switchTo().frame(0);
		//get the button as a webelement using xpath
		WebElement button=driver.findElement(By.xpath("//button[text()='Click Me']"));
		
	
		// first taking the screen shot of button as file
		File source=button.getScreenshotAs(OutputType.FILE);
		//Path to save the screen shot 
		File destination=new File("./snaps/igotbuttonscreenshot.png");
		//saving the screen shot 
		FileUtils.copyFile(source, destination);
		
		//going to the default frame
		driver.switchTo().defaultContent();
		//getting all the frames in a list using find elements method
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		//getting the size and printing it 
		System.out.println(frames.size());

}
}
