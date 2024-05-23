package com.SignUpandSignIn;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import genericLib.UtilityMethods;
import pom.SignUpPage;

public class SignUp extends BaseClass{
	
	@Test
	public void signUp()
	{
		SignUpPage register = new SignUpPage(driver);
		register.clickSignIn();
		register.clickSignUp();
		register.enterEmail(email);
		register.enterPassword(password);
		register.enterMobile(mobile);
		register.enterName(name);
		register.clickCreateAccount();
		
//		UtilityMethods utiliy = new UtilityMethods();
//		utiliy.assertPage(driver, email);
		
	}
	
	
}
