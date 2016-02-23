package autocompleteTestSuit;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;



public class autocompleteEndToEnd {
	
	private FirefoxDriver driver = null;
	
	@BeforeTest
	public void init(){
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}
		
		
	@Test
	public void checkActiveSearchBox() throws IOException{
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ra");
	}
	
	@Test
	public void checkDropDownofSearchBox() throws InterruptedException{
		int i = 0;
		Thread.sleep(4000);
		List<WebElement> dropDown = driver.findElement(By.xpath("//*[@id='gsr']//ul[@role='listbox']")).findElements(By.tagName("li"));
		System.out.println("list : "+ dropDown.size());
		
		for(WebElement e : dropDown) {
			  System.out.println(e.getText());
			}
		
	}
	
	@AfterTest
	public void closeTest(){
		driver.close();
		System.exit(0);
	}
	
	
	public void getScreenshot() throws IOException{

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/Rahul/Documents/workspace/automationTestSuit/screenshot.png"));
	}

}
