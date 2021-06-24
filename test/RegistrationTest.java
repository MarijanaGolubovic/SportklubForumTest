package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;
import pages.HomePage;
import pages.RegistrationPage;
import utility.Constants;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistrationTest extends BaseTest {

	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);

	@Test
	public void emptyEmailFieldsTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage.clickAcceptCookies();
		RegistrationPage.openRegistrationPage();
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername(Constants.USERNAME);
		RegistrationPage.inputPassword(Constants.PASSWORD);
		RegistrationPage.inputConfirmPassw(Constants.PASSWORD);
		RegistrationPage.inputEmail("");
		RegistrationPage.inputConfirmEmail("");
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(
				ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), "Please enter your email address."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

	@Test

	public void invalidUsernameTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername("Us");
		RegistrationPage.inputPassword(Constants.PASSWORD);

		boolean result = wait.until(
				ExpectedConditions.textToBe(By.xpath("//*[@id=\"alert-dialog\"]/div[1]/div[2]/ul/li"),
						"Invalid User Name Specified. Username minimum length should be 3 characters."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();

	}

	@Test
	public void emptyUsernameFieldTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername("");
		RegistrationPage.inputPassword(Constants.PASSWORD);
		RegistrationPage.inputConfirmPassw(Constants.PASSWORD);
		RegistrationPage.inputEmail(Constants.EMAIL);
		RegistrationPage.inputConfirmEmail(Constants.EMAIL);
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), "Please enter a user name."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

	@Test
	public void notMatchingPasswTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername(Constants.USERNAME);
		RegistrationPage.inputPassword(Constants.PASSWORD);
		RegistrationPage.inputConfirmPassw("M1234567");
		RegistrationPage.inputEmail(Constants.EMAIL);
		RegistrationPage.inputConfirmEmail(Constants.EMAIL);
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), "Passwords must match"));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

	@Test
	public void emptyPasswordFieldsTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername(Constants.USERNAME);
		RegistrationPage.inputPassword("");
		RegistrationPage.inputConfirmPassw("");
		RegistrationPage.inputEmail(Constants.EMAIL);
		RegistrationPage.inputConfirmEmail(Constants.EMAIL);
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), "Your password is too short."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

	@Test
	public void invalidEmailFieldsTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		RegistrationPage.inputUsername(Constants.USERNAME);
		RegistrationPage.inputPassword(Constants.PASSWORD);
		RegistrationPage.inputConfirmPassw(Constants.PASSWORD);
		RegistrationPage.inputEmail("emailtest1gmail.com");
		RegistrationPage.inputConfirmEmail("emailtest1gmail.com");
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), "Invalid email address."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

	@Test
	public void validDataRegisterTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(RegistrationPage.USERNAME)));
		int rand = 1 + (int) (Math.random() * 1000);
		RegistrationPage.inputUsername(Constants.USERNAME + rand);
		RegistrationPage.inputPassword(Constants.PASSWORD);
		RegistrationPage.inputConfirmPassw(Constants.PASSWORD);
		RegistrationPage.inputEmail(Constants.EMAIL);
		RegistrationPage.inputConfirmEmail(Constants.EMAIL);
		RegistrationPage.clickAcceptTermsCBox();
		RegistrationPage.clickPrivacyCBox();
		RegistrationPage.clickSubmit();

		boolean result = wait.until(ExpectedConditions.textToBe(By.xpath(Constants.ALERT_DIALOG), 
				"You must select a paid subscription to purchase."));
		assertEquals(true, result);
		RegistrationPage.clickAlertBtn();
	}

}
