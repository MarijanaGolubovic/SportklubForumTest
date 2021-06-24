package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class RegistrationPage extends BasePage {

	private static final String MONTH = "//*[@id=\"frmRegister\"]/div[1]/div[1]/a[1]";
	private static final String DAY = "//*[@id=\"frmRegister\"]/div[1]/div[1]/a[2]";
	private static final String YEAR = "//*[@id=\"frmRegister\"]/div[1]/div[1]/a[3]";
	public static final String USERNAME = "regDataUsername";
	private static final String PASSWORD = "regDataPassword";
	private static final String CONFIRM_PASSW = "regDataConfirmpassword"; 
	private static final String EMAIL = "regDataEmail";
	private static final String CONFIRM_EMAIL = "email_confirm";
	private static final String CB_APPROVE_TERMS = "cbApproveTerms";
	private static final String CB_PRIVACY = "//*[@id=\"regContent\"]/div[4]/label/input";
	private static final String SUBMIT = "regBtnSubmit";  
	private static final String ALERT_BTN = "btnAlertDialogOK"; 
	

	public static WebElement monthList() {
		return findElementByXpath(MONTH);
	}

	public static void selectMonth() {		
		monthList().click();
		monthList().sendKeys(Keys.ARROW_DOWN);
	}

	public static WebElement dayList() {
		return findElementByXpath(DAY);
	}

	public static void selectDate() {
		dayList().click();
		dayList().sendKeys(Keys.ARROW_DOWN);
	}

	public static WebElement yearList() {
		return findElementByXpath(YEAR);
	}

	public static void selectYear() {
		yearList().click();
		findElementByXpath("//*[@id=\"vb-page-body\"]/ul[3]/li[20]/a").click();
	}
	
	public static void openRegistrationPage() {
		HomePage.clickLoginSignupMenu();
		HomePage.clickSignupButton();
		selectMonth();
		selectDate();
		selectYear();
	}

	
	public static WebElement usernameField() {
		return findElementById(USERNAME);
	}
	
	public static void inputUsername(String input) {
		usernameField().clear();
	     usernameField().sendKeys(input);
	}

	public static WebElement passwordField() {
		return findElementById(PASSWORD);
	}
	
	public static void inputPassword(String input) {
		passwordField().clear();
		passwordField().sendKeys(input);
	}

	public static WebElement confirmPasswField() {
		return findElementById(CONFIRM_PASSW);
	}
	
	public static void inputConfirmPassw(String input) {
		confirmPasswField().clear();
		confirmPasswField().sendKeys(input);
	}
	
	public static WebElement emailField() {
		return findElementById(EMAIL);
	}
	
	public static void inputEmail(String input) {
		emailField().clear();
		emailField().sendKeys(input);
	}

	public static WebElement confirmEmailField() {
		return findElementByName(CONFIRM_EMAIL);
	}
	
	public static void inputConfirmEmail(String input) {
		confirmEmailField().clear();
		confirmEmailField().sendKeys(input);
	}
	
	public static WebElement alertButton() {
		return findElementById(ALERT_BTN);
	}
	
	public static void clickAlertBtn() {
		alertButton().click();
	}

	public static WebElement acceptTermsCBox() {
		return findElementById(CB_APPROVE_TERMS);
	}
	
	public static void clickAcceptTermsCBox() {
		acceptTermsCBox().click();
	}
	
	public static WebElement privacyCBox() {
		return findElementByXpath(CB_PRIVACY);
	}
	
	public static void clickPrivacyCBox() {
		privacyCBox().click();
	}

	public static WebElement submitButton() {
		return findElementById(SUBMIT);
	}
	
	public static void clickSubmit() {
		submitButton().click();
	}

}
