package Week4Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandles {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
	
		//open chrome
		ChromeDriver driver=new ChromeDriver();
				
		//connect to leaftabs url
		driver.get("http://www.leafground.com/pages/Window.html");
		//maximize the window 
		driver.manage().window().maximize();
		//click wait for 5 seconds button
		driver.findElement(By.id("color")).click();
			
		//get window handles in set
		Set<String> windowhandle=driver.getWindowHandles();
		
		//convert window handle set in to list 
		List<String> listhandle=new ArrayList<String>(windowhandle);
		
		//switch window control to a different window 
		driver.switchTo().window(listhandle.get(2));
		//print title of the current window
		System.out.println(driver.getTitle());
		driver.switchTo().window(listhandle.get(1));
		
       System.out.println(driver.getTitle());
       //close the current window
       driver.close();
       //switch control to main window 
       driver.switchTo().window(listhandle.get(0));
       
       
}
		

}
