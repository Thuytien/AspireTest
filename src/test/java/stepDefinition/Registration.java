package stepDefinition;

import cucumber.api.java.en.And;

import page.page_Registration;

public class Registration extends BaseDef{
	
	@And ("^Go to Register page$")
	public void goToRegisterPage() throws Throwable{
		page_Registration page = new page_Registration();
		page.goToRegisterPage();
	}

}
