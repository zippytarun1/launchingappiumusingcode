package com.snapdeal.webautomation.browserstack;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import pages.Supportpage;

public class search {

	public static String urlfolderpath = "C://browserstack//testdata//urldata.properties";

	public static String testdatafolderpath = "C://browserstack//testdata//testdata.properties";
	private String param;
	private String filestring;

	Supportpage pageSupportpage;

	public static Readfile r1 = new Readfile();

	WebDriver webdriver;

	public search()

	{
	}

	public search(WebDriver webdriver)

	{
		this.webdriver = webdriver;

	}

	@DataProvider(name = "data")

	public static Object[][] dataMethod() {
		return new Object[][] { { r1.readpropertyvariable("mobilesecurityurl", urlfolderpath), "mobile security" },
				{ r1.readpropertyvariable("mobilesearchstringurl", urlfolderpath), "mobile" } };
	}

	@BeforeTest
	public void setup() throws Exception, IllegalThreadStateException {

		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		webdriver = new ChromeDriver();

		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		webdriver.get(r1.readpropertyvariable("baseurl", urlfolderpath));

	}

	@Test(priority = 1)

	public void verify_autosuggest() throws NullPointerException

	{

		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		pageSupportpage.sendsearchquery("Mobile ");

		pageSupportpage.autosuggestresult();

		// Verify login page title

	}

	@Test(priority = 0)

	public void verify_search() throws NullPointerException

	{

		pageSupportpage = new Supportpage(webdriver);

		pageSupportpage.sendsearchquery("Mobile");
		pageSupportpage.submitsearchquery();

		pageSupportpage.searchresult();

	}

	@Test(priority = 2)

	public void verify_tittle()

	{

		Assert.assertTrue(pageSupportpage.pagetittle().contains(r1.readpropertyvariable("tittle", testdatafolderpath)));

	}

	@Test(priority = 3, dataProvider = "data")

	public void urlformation_verification(String searchstringurl, String searchstring)

	{
		pageSupportpage = new Supportpage(webdriver);

		pageSupportpage.sendsearchquery(searchstring);
		pageSupportpage.submitsearchquery();
		Assert.assertTrue(webdriver.getCurrentUrl().contains(searchstringurl));
	}

	@Test(priority = 4)

	public void contactus_form()

	{

		pageSupportpage = new Supportpage(webdriver);
		pageSupportpage.postivetestcaseafillcontactus();
		webdriver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='contact-form']/input")));
		pageSupportpage.negativetestcaseafillcontactus();
	}

	@Test(priority = 5)

	public void linktext()

	{
		Assert.assertTrue(pageSupportpage.pagetittle().contains(r1.readpropertyvariable("tittle", testdatafolderpath)));
	}

	@AfterClass

	public void verifyTextPresent(String value) {
		pageSupportpage.pagetittle().contains("ds");
	}

	public void closeselenium()

	{

		webdriver.close();
	}

}
