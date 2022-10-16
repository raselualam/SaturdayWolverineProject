package upskill.ebay.pageAction;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import upskill.ebay.pageElements.EbayCartLocators;
import upskill.utilities.SetupDrivers;

public class EbayCartActions {
	
	EbayCartLocators EbayCartLocatorsObj;
	
	public EbayCartActions(){
		EbayCartLocatorsObj = new EbayCartLocators();
		PageFactory.initElements(SetupDrivers.driver, EbayCartLocatorsObj);
	}
	
	public void switchNewWindow(){
		for(String winhandle : SetupDrivers.driver.getWindowHandles()){
			SetupDrivers.driver.switchTo().window(winhandle);
		}
	}

	public void selectSizeTypeDD() throws Exception{
		Select dropDown = new Select(EbayCartLocatorsObj.ddSizeType);
		dropDown.selectByVisibleText("Big & Tall");
//		dropDown.selectByIndex(1);
		Thread.sleep(2000);
	}
	
	public void selectMenSizeDD() throws Exception{
		Select dropDown = new Select(EbayCartLocatorsObj.ddMenSize);
		dropDown.selectByVisibleText("4XLT");
//		dropDown.selectByIndex(3);
		Thread.sleep(3000);
	}
	
	public void selectShadeDD() throws Exception{
		Select dropDown = new Select(EbayCartLocatorsObj.ddShade);
		dropDown.selectByVisibleText("Black");
//		dropDown.selectByValue("15");
		Thread.sleep(2000);
	}
	
	public void enterQuantity() throws Exception{
		EbayCartLocatorsObj.txtbxQty.clear();
		EbayCartLocatorsObj.txtbxQty.sendKeys("2");
		Thread.sleep(2000);
	}
	
	public void addToCart() throws Exception{
		EbayCartLocatorsObj.btnAddCart.click();
		Thread.sleep(5000);
	}
	
}
