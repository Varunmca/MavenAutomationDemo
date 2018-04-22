package org.automation.testscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {

	
	public WebDriver driver;
	String url="http://facebook.com";
	String browser="Chrome";
	
	public void init()
	{
		lounchBrowser(browser);
		getUrl(url);
		Registration_Page();
	}
	
	public void lounchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new ChromeDriver();
		}
	}
	public void getUrl(String url) 
	{
		driver.get(url);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}
	public void waitforElement(WebDriver driver,WebElement element,long timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void Registration_Page()
	{
		WebElement Fname=driver.findElement(By.name("firstname"));
		WebElement Sname=driver.findElement(By.name("lastname"));
		WebElement Email=driver.findElement(By.name("reg_email__"));
		WebElement ReEnter_Email=driver.findElement(By.name("reg_email_confirmation__"));
		WebElement Password=driver.findElement(By.name("reg_passwd__"));
		WebElement day_Select=driver.findElement(By.name("birthday_day"));
		WebElement month_Select=driver.findElement(By.name("birthday_month"));
		WebElement year_Select=driver.findElement(By.name("birthday_year"));
		
		//waitforElement(driver,ReEnter_Email,20);
		//waitforElement(driver,Sname,10);
		//waitforElement(driver,Email,10);
		//waitforElement(driver,Password,10);
		Fname.sendKeys("varun");
		Sname.sendKeys("Singh");
		Email.sendKeys("varun@gmail.com");
		waitforElement(driver,ReEnter_Email,20);
		ReEnter_Email.sendKeys("varun@gmail.com");
		Password.sendKeys("12423434");
		
		Select  sel1=null;
		sel1=new Select(day_Select);
		sel1.selectByVisibleText("10");
		Select	sel2=new Select(month_Select);
			sel2.selectByIndex(2);
			Select sel3=new Select(year_Select);
		 sel3.selectByIndex(4);
		 
	List<WebElement>	  radioBtn=driver.findElements(By.name("sex"));
	System.out.println(radioBtn.size());
	for(WebElement radio:radioBtn)
	{
		String strRadio=radio.getAttribute("value");
		System.out.println(strRadio);
		if(strRadio.contains("2"));
		{
			radio.click();
			break;
		}
		
	}
	List<WebElement>	  regNo=driver.findElements(By.id("registration_container"));
	System.out.println(regNo.size());
	for(WebElement reg:regNo)
	{
		String strReg=reg.getText();
		System.out.println(strReg);
	}
	}
	public static void main(String args[])
	{
		Facebook obj=new Facebook();
		obj.init();
	}
}
