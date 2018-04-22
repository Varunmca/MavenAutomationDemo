package org.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




/**
 * @author varun
 *
 */
public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	@FindBy(id="email")
	WebElement loginEmailAddress;
	@FindBy(id="passwd")
	WebElement loginPassword;
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 *@ name login
	 * @param emailAddress
	 * @param password
	 */
	public void login(String emailAddress,String password)
	{
		signIn.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();
	}

}
