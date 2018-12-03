package com.group4.Kahoot3000;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Kahoot3000ApplicationTests {

	//**********************//
	//     CLASS FIELDS     //
	//**********************//

	private ChromeDriver driver;

	private final static String url = "http://localhost:8080/";

	//*************************//
	//     SETUP & CLEANUP     //
	//*************************//

	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+
						File.separator +"src"+
						File.separator + "main"+
						File.separator + "resources" +
						File.separator + "selenium" +
						File.separator + "chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, SECONDS);
	}

	@After
	public void quitDriver(){
		driver.quit();
	}

	//***************//
	//     TESTS     //
	//***************//

	@Test
	public void contextLoads() {
	}

	@Test
	public void homePageTest(){
		driver.get(url);
		String loginDivText = driver.findElementByClassName("login").getText();
		Assert.assertFalse(loginDivText.isEmpty());
		quitDriver();
	}

	@Test
	public void loginPageTest(){
		driver.get(url);
		goToPage("login");
		Assert.assertTrue(driver.findElementById("loginUsername").isDisplayed());
		Assert.assertTrue(driver.findElementById("loginPassword").isDisplayed());
		Assert.assertTrue(driver.findElementById("loginButton").isDisplayed());
		quitDriver();
	}

	@Test
	public void registerPageTest(){
		driver.get(url);
		goToPage("register");
		Assert.assertTrue(driver.findElementById("registerUsername").isDisplayed());
		Assert.assertTrue(driver.findElementById("registerPassword1").isDisplayed());
		Assert.assertTrue(driver.findElementById("registerPassword2").isDisplayed());
		Assert.assertTrue(driver.findElementById("registerSubmit").isDisplayed());
		quitDriver();
	}

	@Test
	public void aboutUsPageTest(){
		driver.get(url);
		goToPage("aboutus");
		Assert.assertTrue(driver.findElementById("googleMap").isDisplayed());
		quitDriver();
	}

	@Test
	public void userpageTest(){
		goToPage("userpage");
		Assert.assertFalse(driver.getCurrentUrl().contains("userpage"));

		login(this.driver);
		Assert.assertTrue(driver.findElementById("games").isDisplayed());
		Assert.assertTrue(driver.findElementById("new_game").isDisplayed());
	}

	@Test
	public void logoutTest(){
		login(this.driver);
		driver.findElement(By.id("logout")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("logoutConfirm")));
	}

	//*************************//
	//     PRIVATE METHODS     //
	//*************************//

	private static void login(ChromeDriver driver){
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("login")));
		driver.findElementById("login").click();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"loginUsername\"]"));
		username.sendKeys(String.valueOf(System.getenv("testUsername")));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"loginPassword\"]"));
		password.sendKeys(String.valueOf(System.getenv("testPassword")));
		driver.findElement(By.id("loginButton")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("logout")));

	}

	private void goToPage(String page){
		driver.get(url +page);
	}

}
