package test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;
import pages.HomePage;
import utility.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Test
	public void emptyUsernAndPAsswFieldTest() throws InterruptedException {
		
		HomePage.inputUsername("");
		HomePage.inputPassword("");
		HomePage.clickLoginButton();

		boolean result = wait.until(ExpectedConditions
				.textToBe(By.xpath(Constants.ERROR_BOX), "You have entered an invalid username or password. Please enter the correct details and try again."
						+ " Don't forget that the password is case sensitive. Forgotten your password? Click here!"));
		assertEquals(true, result);
	}

	@Test
	public void emptyPasswFieldTest() throws InterruptedException {
		HomePage.clickAcceptCookies();
		HomePage.clickLoginSignupMenu();
		HomePage.inputUsername(Constants.USERNAME_LOGIN);
		HomePage.inputPassword("");
		HomePage.clickLoginButton();

		boolean result = wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(Constants.ERROR_BOX), 
						"You have entered an invalid username or password. Please enter the correct details and try again. "
						+ "Don't forget that the password is case sensitive. Forgotten your password? Click here!"));
		assertEquals(true, result);
	}
	
	@Test
	public void emptyUsernameFieldTest() throws InterruptedException {
		
		HomePage.inputUsername("");
		HomePage.inputPassword(Constants.PASSWORD_LOGIN);
		HomePage.clickLoginButton();

		boolean result = wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(Constants.ERROR_BOX), 
						"You have entered an invalid username or password. Please enter the correct details and try again. "
						+ "Don't forget that the password is case sensitive. Forgotten your password? Click here!"));
		assertEquals(true, result);
	}
	
	@Test
	public void forgotenPasswordLinkTest() throws InterruptedException {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(HomePage.FORGOTPASSW_LINK)));
		HomePage.clickForgotPasswordLink();  
		
		boolean result = wait.until(ExpectedConditions
				.urlToBe(Constants.LOSTPW_URL));
		
		assertEquals(true, result);
	}
	
	@Test
	public void invalidPasswordTest() throws InterruptedException {
		driver.navigate().to(Constants.FORUM_URL);
		HomePage.clickLoginSignupMenu();
		HomePage.inputUsername(Constants.USERNAME_LOGIN);
		HomePage.inputPassword("M12345");
		HomePage.clickLoginButton();

		boolean result = wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(Constants.ERROR_BOX), 
						"You have entered an invalid username or password. Please enter the correct details and try again. "
						+ "Don't forget that the password is case sensitive. Forgotten your password? Click here!"));
		assertEquals(true, result);
	}
	
	@Test
	public void invalidUsernameTest() throws InterruptedException {
		
		HomePage.inputUsername("Mar");
		HomePage.inputPassword(Constants.PASSWORD_LOGIN);
		HomePage.clickLoginButton();

		boolean result = wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(Constants.ERROR_BOX), 
						"You have entered an invalid username or password. Please enter the correct details and try again. "
						+ "Don't forget that the password is case sensitive. Forgotten your password? Click here!"));
		assertEquals(true, result);
	}
	
	
	@Test
	public void validCredentialsLoginTest() throws InterruptedException {
		
		HomePage.inputUsername(Constants.USERNAME_LOGIN);
		HomePage.inputPassword(Constants.PASSWORD_LOGIN);
		HomePage.clickLoginButton();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(Constants.USERN_MENU)));
		assertEquals("Mar.Gol", result.getText());
	}
		
}
