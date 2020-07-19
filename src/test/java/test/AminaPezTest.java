package test;

import java.awt.Checkbox;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AminaPezPage;


public class AminaPezTest {

	private static WebDriver driver = null;
	
	@BeforeClass
	public static void AminaPezLogin(){
		String dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//go to 
		driver.get("https://amina-pez.github.io/automation/"); 
		
	}
	//click hide button
	@Test(priority=1)
	public void ClickHideButton(){
		AminaPezPage home = new AminaPezPage(driver);
		home.aminaClickHideButton();
		
		
	}
	//Verify that "Tekst koji treba biti sakriven" is hidden - poseban zadatak
	
	//Check that Emu checkbox is disabled
	@Test(priority=2)
		public void IsCheckboxDisabled() {
			AminaPezPage home = new AminaPezPage(driver);
			
			Assert.assertFalse(home.aminaIsCheckboxDisabled(), "Checkbox button is not disabled.");
	}	
	
		//Verify that total number of checkboxes is 6
	@Test(priority=3)	
	public void GetAllCheckbox() {
		AminaPezPage home = new AminaPezPage(driver);
		Assert.assertEquals(home.aminaGetAllCheckbox(), 6, "Number of checkboxes is not 6");
				//Assert.assertEquals(number1, 3, "Number of checkboxes is not 3");
			
		
		
	}
	//Select Radio button Jezeva kucica
	@Test(priority=4)
		public void RadioButtonSelected() {	
		//Select Radio button Jezeva kucica
		AminaPezPage home = new AminaPezPage(driver);
		home.aminaRadioButtonSelected();
		home.clickRadioBtn("Jezeva kucica");
		
		}
	
	//Click on prompt box button, enter your name and click on OK
	//Check that under "Prompt box!" button following text: "Hello <name>" is displayed
	@Test(priority=5)
	public void ClickPromptboxButton() {
		AminaPezPage home = new AminaPezPage(driver);
		home.aminaClickPromptboxButton();
		Assert.assertEquals(home.aminaClickPromptboxButton(), "Hello Vildana", "Please enter your name");
		
	}
	
	@AfterMethod
	public void stayOnLoginPage() {
		driver.get("https://amina-pez.github.io/automation/");
		
	}
	@AfterClass
	public void tearDown() {
		AminaPezPage home = new AminaPezPage(driver);
		home.tearDown();
}
}
		

