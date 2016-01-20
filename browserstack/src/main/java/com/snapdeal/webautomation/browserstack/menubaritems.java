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

public class menubaritems {
	
	Supportpage pageSupportpage; 


	WebDriver webdriver;

	
	public menubaritems()
	
	{
		
		
	}
		
	public menubaritems(WebDriver webdriver)
		
		{
			this.webdriver=webdriver;
			
		}

	

	@BeforeTest
    public void setup() throws Exception,IllegalThreadStateException{
	System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
    	    webdriver = new ChromeDriver();


            webdriver.get(search.r1.readpropertyvariable("baseurl",search.urlfolderpath));

          //  webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        
    }
	
	@Test(priority=0)

	public void click_automatemenuitem() throws NullPointerException
    
    {
		pageSupportpage = new Supportpage(webdriver);
		System.out.println(pageSupportpage.browserstack_menu_items_automate);
		//webdriver.manage().timeouts().implicitlyWait(, TimeUnit.SECONDS);
    	pageSupportpage.browserstack_menu_items_automate.click();
    
	    Assert.assertTrue(webdriver.getCurrentUrl().contains(search.r1.readpropertyvariable("menuautomateurl",search.testdatafolderpath)));


        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Verify login page title
 }
	
	@AfterClass
	
	public void closeselenium()
	
	{
		
		webdriver.close();
	}
	
	

}
