package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnExcel extends ProjectSpecificMethods{
  
	@BeforeTest
	public void setPath()
	{
		excelFilePath="./testdata/createLead_testdata.xlsx";
	}
	
	@Test(dataProvider="Dynamic_data")
	public void ExcelData(String username, String password, String firstname, String lastname, String dropdownValue)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(firstname);
		driver.findElement(By.id("lastNameField")).sendKeys(lastname);
//		driver.findElement(By.id("createContactForm_description")).sendKeys("sarandescription");
//		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("saran@test.com");
		WebElement dropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropdownObject=new Select(dropdown);
		dropdownObject.selectByVisibleText(dropdownValue);
		driver.findElement(By.name("submitButton")).click();
	}
}

/*
 * @DataProvider(name="Dynamic_data") public String[][] testData() { String[][]
 * data=new String[2][5];
 * 
 * data[0][0]="Demosalesmanager"; data[0][1]="crmsfa"; data[0][2]="saranfirst1";
 * data[0][3]="saranlast1"; data[0][4]="New Jersey";
 * 
 * data[1][0]="Demosalesmanager"; data[1][1]="crmsfa"; data[1][2]="saranfirst2";
 * data[1][3]="saranlast2"; data[1][4]="New Jersey";
 * 
 * return data; }
 */