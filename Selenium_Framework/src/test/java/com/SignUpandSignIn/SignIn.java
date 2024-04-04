package com.SignUpandSignIn;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pom.SignInPage;

public class SignIn extends BaseClass{

	@Test
	public void signIn()
	{
		SignInPage signIn = new SignInPage(driver);
		signIn.clickSignIn();
		signIn.enterEmail(email);
		signIn.enterPassword(password);
		//signIn.clickSignInButton();
	}
	
}

