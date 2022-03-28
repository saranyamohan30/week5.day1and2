package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSelectable {
	
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Selectable")).click();
		WebElement frameSet = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame("frameSet");
		WebElement select1 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[1]"));
		WebElement select3 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[3]"));
		WebElement select5 = driver.findElement(By.xpath("(//ol[@id='selectable']/li)[5]"));
		Actions action=new Actions(driver);
		action.keyDown(Keys.DOWN).click(select1).click(select3).click(select5).perform();
//		action.clickAndHold().keyDown(Keys.DOWN).keyUp(Keys.CONTROL).perform();
		
	}
}
