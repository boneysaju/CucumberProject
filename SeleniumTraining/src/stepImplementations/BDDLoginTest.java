package stepImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	
	WebDriver driver;
	WebElement enterUsername = driver.findElement(By.id("MainContent_txtUserName"));
	WebElement enterPassword = driver.findElement(By.id("MainContent_txtPassword"));
	WebElement selectLoginButton = driver.findElement(By.id("MainContent_btnLogin"));
	WebElement confirmationMessage = driver.findElement(By.id("conf_message"));
	
	String email = "tim@testemail.com";
	String password = "trpass";
	
	@Given("^user is on the log in page$")
	public void user_is_on_the_log_in_page() {
		System.out.println("User in the on log in page");
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enter correct username and correct password$")
	public void user_enter_correct_username_and_correct_password() {
		System.out.println("User enters username and password");
		enterUsername.sendKeys(email);
		enterPassword.sendKeys(password);
		selectLoginButton.click(); 
	}
	
	
	@When ("^user enters email (.*)$") 
	public void user_enters_email(String username) {
		System.out.println("User enters username");
		enterUsername.sendKeys(username);
	}
	
	@And("^user enters password (.*)$")  
	public void user_enters_password(String passwords) {
		System.out.println("User enters password");
		enterPassword.sendKeys(passwords);
		user_clicks_log_in_button();
	}
	
	public void user_clicks_log_in_button() {
		selectLoginButton.click();
	}
	
	
	@Then("^user gets confirmation$") 
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation");
		Assert.assertTrue(confirmationMessage.getText().contains("success"));
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}


}
