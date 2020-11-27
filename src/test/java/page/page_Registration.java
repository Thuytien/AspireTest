package page;

import handler.Test;

public class page_Registration {

	private String registerXpath = "//div[@class='login-step-start__register']//a[contains (@class,'register-link')]";
	
	public void goToRegisterPage() {
		Test.clickElement(registerXpath);
		Test.waitPageLoad();
	}
}
