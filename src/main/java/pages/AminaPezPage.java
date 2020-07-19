package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class AminaPezPage {
	private WebDriver driver;
	
	private By hideButton = By.id("hide-textbox");
	private By pets = By.id("emu-checkbox");	
	private By books = By.xpath("//input[@value=\"Jezeva kucica\"]");
	private By checkbox = By.xpath("//input[@type=\"checkbox\"]");
	private By promptBox = By.id("promptBox");
	private By promptResult = By.id("demo");
	//private By newBrowserWindow = By.id("win1");
	
	
	
	
//constructor
	public AminaPezPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void aminaClickHideButton()  {
	driver.findElement(hideButton).click();
}
	
	public boolean aminaIsCheckboxDisabled() {
		AminaPezPage home = new AminaPezPage(driver);
		return driver.findElement(pets).isEnabled();
		
	}	
	
	
	//Verify that total number of checkboxes is 6
	public int aminaGetAllCheckbox() {
	AminaPezPage home = new AminaPezPage(driver);
	
	List<WebElement> Checkbox = driver.findElements(checkbox);
	return Checkbox.size();
	
	
}
	//Select Radio button Jezeva kucica
	public void aminaRadioButtonSelected() {
		new AminaPezPage(driver);
		driver.findElement(books).click();
		System.out.println("Jezeva kucica is selected");
		
		
		
	}
	//From Nahla Courses select Turski 
	// Click on prompt box button, enter your name and click on OK****
	public String aminaClickPromptboxButton() {
		new AminaPezPage(driver);
		
		driver.findElement(promptBox).click();
		 driver.switchTo().alert().sendKeys("Vildana");
		 driver.switchTo().alert().accept();
		 
		 return driver.findElement(promptResult).getText();
		 
	}


	public void clickRadioBtn(String string) {
		// TODO Auto-generated method stub
		
	}
	public void tearDown () {
		driver.quit();

}
}
	
