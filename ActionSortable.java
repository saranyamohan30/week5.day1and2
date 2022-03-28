package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Sortable")).click();
		WebElement frameSet = driver.findElement(By.className("demo-frame"));
		frameSet.click();
		driver.switchTo().frame(frameSet);
		WebElement sort1 = driver.findElement(By.xpath("(//li[contains(@class,'ui-state-default ui-sortable-handle')])[1]"));
		WebElement sort2 = driver.findElement(By.xpath("(//li[contains(@class,'ui-state-default ui-sortable-handle')])[2]"));
		String button1 = sort1.getText();
		System.out.println(button1);
		Actions action_sort=new Actions(driver);
		action_sort.dragAndDrop(sort1, sort2).release().perform();
//		action_sort.clickAndHold(sort1).keyDown(Keys.DOWN).release().perform();
		
		
	}

}
