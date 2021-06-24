package pages;

import org.openqa.selenium.WebElement;

import browser.Browser;

public class BasePage {
	public static WebElement findElementByXpath(String xpath) {
		return Browser.getBrowser().findElementByXPath(xpath);
	}
	
	public static WebElement findElementByName(String name) {
		return Browser.getBrowser().findElementByName(name);
	}
	
	public static WebElement findElementById(String id) {
		return Browser.getBrowser().findElementById(id);
	}
}
