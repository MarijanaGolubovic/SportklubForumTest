package test;

import org.junit.AfterClass;

import org.junit.BeforeClass;
import browser.Browser;
import utility.Constants;


public class BaseTest {

	@BeforeClass
	public static void setUp() {	
		Browser.getBrowser().get(Constants.FORUM_URL);
		Browser.getBrowser().manage().window().maximize();
	}

	@AfterClass
	public static void cleanUp() {
		Browser.getBrowser().quit();
	}
}