package pages;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private static final String LOGIN_SIGNUP_MENU = "//*[@id=\"lnkLoginSignupMenu\"]";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String LOGIN_BTN = "//*[@id=\"vb-page-body\"]/nav/div/ul/li/div/ul/li[1]/div/form/div[4]/button";
	private static final String SIGNUP_BTN = "//*[@id=\"idLoginSignup\"]";
	public static final String FORGOTPASSW_LINK = "//a[contains(text(),'Forgot password or user name?')]";
	private static final String ACCEPT_COOKIES_BTN = "//*[@id=\"vb-page-body\"]/div[12]/p[3]/a"; 

	public static WebElement acceptCookies() {
		return findElementByXpath(ACCEPT_COOKIES_BTN);
	}
	
	public static void clickAcceptCookies() {
		acceptCookies().click();
	}

	public static WebElement loginSignupMenu() {
		return findElementByXpath(LOGIN_SIGNUP_MENU);
	}

	public static void clickLoginSignupMenu() {
		loginSignupMenu().click();
	}

	public static WebElement usernameField() {
		return findElementByName(USERNAME);
	}

	public static void inputUsername(String input) {
		usernameField().clear();
		usernameField().sendKeys(input);
	}

	public static WebElement passwordField() {
		return findElementByName(PASSWORD);
	}

	public static void inputPassword(String input) {
		passwordField().clear();
		passwordField().sendKeys(input);
	}

	public static WebElement loginButton() {
		return findElementByXpath(LOGIN_BTN);
	}

	public static void clickLoginButton() {
		loginButton().click();
	}

	public static WebElement signupButton() {
		return findElementByXpath(SIGNUP_BTN);
	}

	public static void clickSignupButton() {
		signupButton().click();
	}
	
	public static WebElement forgotPasswordLink() {
		return findElementByXpath(FORGOTPASSW_LINK);
	}

	public static void clickForgotPasswordLink() {
		forgotPasswordLink().click();
	}

}
