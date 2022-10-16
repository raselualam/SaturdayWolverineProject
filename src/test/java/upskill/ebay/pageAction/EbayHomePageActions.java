package upskill.ebay.pageAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import upskill.ebay.pageElements.EbayHomePageLocators;
import upskill.utilities.SetupDrivers;

public class EbayHomePageActions {
	
	EbayHomePageLocators EbayHomePageLocatorsObj;

	public EbayHomePageActions(){
		EbayHomePageLocatorsObj = new EbayHomePageLocators();
		PageFactory.initElements(SetupDrivers.driver, EbayHomePageLocatorsObj);
	}
	
	public void searchShoes(){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys("Shoes");
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void searchItems(String items){
		EbayHomePageLocatorsObj.txtbxSearch.sendKeys(items);
		EbayHomePageLocatorsObj.btnSearch.click();
	}
	
	public void mouseHoverMyEbay() throws Exception{
		Actions actions = new Actions(SetupDrivers.driver);
		actions.moveToElement(EbayHomePageLocatorsObj.linkMyEbay);
		actions.perform();
		Thread.sleep(3000);
	}
	
	public void clickSummary() throws Exception{
		EbayHomePageLocatorsObj.linkSummary.isEnabled();
		EbayHomePageLocatorsObj.linkSummary.click();
		Thread.sleep(3000);
	}
	
	public void handleAlert(){
		SetupDrivers.driver.switchTo().alert().accept();						//Yes to popup window
		SetupDrivers.driver.switchTo().alert().dismiss();						//No to popup window
		SetupDrivers.driver.switchTo().alert().sendKeys("Survey Looks good");	//Write in prompts
		SetupDrivers.driver.switchTo().alert().getText();						//get the text from alert
	}
	
	public void keyboardKeys(){
		EbayHomePageLocatorsObj.btnSearch.sendKeys(Keys.ENTER); 			//EbayHomePageLocatorsObj.btnSearch.click();
		EbayHomePageLocatorsObj.btnSearch.sendKeys(Keys.UP); 
		EbayHomePageLocatorsObj.btnSearch.sendKeys(Keys.DOWN); 
		EbayHomePageLocatorsObj.btnSearch.sendKeys(Keys.CLEAR); 
		EbayHomePageLocatorsObj.btnSearch.sendKeys(Keys.DELETE); 
	}
	
	public void javaScriptExecutor(){
		JavascriptExecutor js = (JavascriptExecutor)SetupDrivers.driver;	//Creating JS object
		
		js.executeScript("");
		
		js.executeScript("EbaySearchResultLocatorsObj.cbxBrandNike.click();"); //Clicking on element
		
		js.executeScript("EbayHomePageLocatorsObj.txtbxSearch.value ='shirt';"); //Writing something
		
		js.executeScript("EbaySearchResultLocatorsObj.cbxBrandNike.checked=true;"); //Interect Checkbox
		
		js.executeScript("window.location = 'http://upskill.com';"); // initializing location
		
		js.executeScript("location.reload()"); 						//Refresh browser
		
		js.executeScript("alert('Confirmation');");					//Alert
		
		js.executeScript("window.scrollBy(0,500)", ""); 			//Scroll down to specific pixel
		
		js.executeScript("window.scrollBy(0,-500)", ""); 			//Scroll up to specific pixel
		
		js.executeScript("arguments[0].scrollIntoView();", EbayHomePageLocatorsObj.btnSearch);  //Scroll to a object
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); //Scroll down to bottom of website
	}
	
	public void handleIframe(){
		
		//i find iframe using iframe tag in DOM or HTML
		//i use switchTo().frame() to switch iframes
		
		//Switch iframe by Index
		SetupDrivers.driver.switchTo().frame(0);
		SetupDrivers.driver.switchTo().frame(1);
		
		//Switch iframe by Name or ID
		SetupDrivers.driver.switchTo().frame("iframe-name");
		SetupDrivers.driver.switchTo().frame("id");
		
		//Switch back to previous iframe
		SetupDrivers.driver.switchTo().defaultContent();
		SetupDrivers.driver.switchTo().parentFrame();
		SetupDrivers.driver.switchTo().frame("parent");
		
		//nested iframe
		SetupDrivers.driver.switchTo().frame("inner");
		SetupDrivers.driver.switchTo().frame("child");
	}
	
	public void dynamicFrames(){
		
		List<WebElement> framelist = SetupDrivers.driver.findElements(By.tagName("iframe"));
		
		for (int i=0; i<(framelist.size()); i++){
			SetupDrivers.driver.switchTo().frame(i);
			
			try{
				EbayHomePageLocatorsObj.btnSearch.click();
			}catch(Exception e){
				System.out.println("Element not found in iframes");
			}
		}
	}
}