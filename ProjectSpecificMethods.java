package week5.day1;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public RemoteWebDriver driver; //global variable
	public String excelFilePath;
	
@Parameters({"URL","BROWSER"})//parameters from the testng xml
@BeforeMethod
	public void beforeMethod(String url, String browser) 
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();	
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(url);//static data -URL
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@AfterMethod
	public void afterMethod() 
	{
		driver.close();
		driver.quit();
	}
@DataProvider(name="Dynamic_data")
	public String[][] test_data() throws IOException
	{
		String[][] data = AutomateExcel.excelData(excelFilePath);
		return data;
	}
}
