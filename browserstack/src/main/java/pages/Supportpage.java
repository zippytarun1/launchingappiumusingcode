package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.snapdeal.webautomation.browserstack.Readfile;

public  class Supportpage {
	
	

public  Supportpage (WebDriver driver){
	 
	        this.driver = driver;
	 
	 
	        PageFactory.initElements(driver, this);
	 
	    }

public Supportpage()
{
	
}

String urlfolderpath="C://browserstack//testdata//urldata.properties";


String testdatafolderpath="C://browserstack//testdata//testdata.properties";

Readfile r1=new Readfile();

WebDriver driver;

@FindBy(name="search")

public WebElement browserstack_Support_search;

 

@FindBy(name="commit")

public WebElement browserstack_support_searchcommit_button;

 
@FindBy(xpath="//*[@id='faq']/li[1]/a")

public WebElement browserstack_support_autosuggest;


@FindBy(xpath="//*[@id='alerts']/div[2]/ul/li[1]")

public WebElement browserstack_autosuggest_mobile1;


@FindBy(xpath="//*[@id='alerts']/div[2]/ul/li[2]")

public WebElement browserstack_autosuggest_mobile2;


@FindBy(xpath="//*[@id='alerts']/div[2]/ul/li[3]")

public WebElement browserstack_autosuggest_mobile3;


@FindBy(xpath="//*[@id='alerts']/div[2]/ul/li[4]")

public WebElement browserstack_autosuggest_mobile4;


@FindBy(xpath="//*[@id='alerts']/div[2]/ul/li[5]")

public WebElement browserstack_autosuggest_mobile5;

@FindBy(id="name")


public WebElement browserstack_contactus_name;


@FindBy(xpath="//*[@id='email']")

public WebElement browserstack_contactus_email;

@FindBy(xpath="//*[@id='message']")

public WebElement browserstack_contactus_message;

@FindBy(xpath="//*[@id='contact-form']/input")

public WebElement browserstack_contactus_button;



@FindBy(xpath="//*[@id='faq']/li[1]")


public WebElement browserstack_search_mobile1;

@FindBy(xpath="//*[@id='faq']/li[2]")


public WebElement browserstack_search_mobile2;

@FindBy(xpath="//*[@id='faq']/li[3]")


public WebElement browserstack_search_mobile3;

@FindBy(xpath="//*[@id='faq']/li[4]")


public WebElement browserstack_search_mobile4;


@FindBy(xpath="//*[@id='faq']/li[5]")


public WebElement browserstack_search_mobile5;


@FindBy(id="automate_button")


public WebElement browserstack_menu_items_automate;






public void sendsearchquery(String searchkeys){
	
	browserstack_Support_search.clear();
	browserstack_Support_search.sendKeys(searchkeys);

     

}

 

//Set password in password textbox

public void submitsearchquery(){

	browserstack_support_searchcommit_button.click();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	browserstack_Support_search.clear();

}


public void autosuggestresult() throws NullPointerException
{


Assert.assertTrue(browserstack_autosuggest_mobile1.getText().substring(0, 69).toLowerCase().contains(r1.readpropertyvariable("searchresult1",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_autosuggest_mobile2.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult2",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_autosuggest_mobile3.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult3",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_autosuggest_mobile4.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult4",testdatafolderpath).toLowerCase()));


Assert.assertTrue(browserstack_autosuggest_mobile5.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult5",testdatafolderpath).toLowerCase()));



}


public void searchresult() throws NullPointerException

{



Assert.assertTrue(browserstack_search_mobile1.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult1",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_search_mobile2.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult2",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_search_mobile3.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult3",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_search_mobile4.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult4",testdatafolderpath).toLowerCase()));

Assert.assertTrue(browserstack_search_mobile5.getText().toLowerCase().contains(r1.readpropertyvariable("searchresult5",testdatafolderpath).toLowerCase()));



}
public String pagetittle()

{
	
	return driver.getTitle();
}

 
/*public String[] stringcreator(String xyz,int length)

{
String[] array=new String[length];
	
	for (int i=1;i <=length;i++)
	{	
	array[i-1]=xyz+i;
	}
	

return array;
}*/



public void postivetestcaseafillcontactus()

{
	

browserstack_contactus_name.sendKeys(r1.readpropertyvariable("username",testdatafolderpath));

browserstack_contactus_email.sendKeys(r1.readpropertyvariable("emailid",testdatafolderpath));


browserstack_contactus_message.sendKeys(r1.readpropertyvariable("text",testdatafolderpath));

 browserstack_contactus_button.click();
	
}

public void negativetestcaseafillcontactus()

{
	

browserstack_contactus_name.sendKeys(r1.readpropertyvariable("negativeusername",testdatafolderpath));

browserstack_contactus_email.sendKeys(r1.readpropertyvariable("negativeemailid",testdatafolderpath));


browserstack_contactus_message.sendKeys(r1.readpropertyvariable("negativetext",testdatafolderpath));

 browserstack_contactus_button.click();
	
}




}

