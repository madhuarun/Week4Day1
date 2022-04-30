package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click from contact widget
		driver.findElement(By.xpath("//input[@id='partyIdFrom']//following-sibling::a")).click();
		
		//Getting window handler in set
		Set<String> windowhandle=driver.getWindowHandles();
		
		//Convert set to list 
		List<String> listhandle=new ArrayList<String>(windowhandle);
		//Go to popup window
		driver.switchTo().window(listhandle.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click from first contactid
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Go back to parent window
		driver.switchTo().window(listhandle.get(0));
		
		//Click to contact widget
		driver.findElement(By.xpath("//input[@id='partyIdTo']//following-sibling::a")).click();
		
		//Reinitialize window handler in set and convert to list
		windowhandle=driver.getWindowHandles();
		listhandle=new ArrayList<String>(windowhandle);
		
		//Go to pop up window 
		driver.switchTo().window(listhandle.get(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click the second contactid
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		//Go back to parent window
		driver.switchTo().window(listhandle.get(0));
		
		//Click merge button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//Handle the simple alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Print title of the current page
		System.out.println(driver.getTitle());
	}

}
