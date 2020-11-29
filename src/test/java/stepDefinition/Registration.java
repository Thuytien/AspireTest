package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.page_Registration;

public class Registration extends BaseDef{
	page_Registration page = new page_Registration();
	
	@And ("^Go to Register page$")
	public void goToRegisterPage() throws Throwable{
		page.goToRegisterPage();
	}
	
	@When ("^User fills in Register Personal form$")
	public void fillInRegisterPersonalForm() throws Throwable{
		//page_Registration page = new page_Registration();
		page.fillInRegisterPersonal();
	}
	
    @And ("^User moves to next step$")
    public void submitForm() throws Throwable{
		//page_Registration page = new page_Registration();
		page.submitForm();
	}
    
    @When ("^User enters OTP code \"([^\"]*)\"$")
    public void enterOTPCodeStep2(String code) throws Throwable{
		//page_Registration page = new page_Registration();
		page.enterOTPCodeStep2(code);
	}
    
    @When ("^User continues with registered business in Singapore$")
    public void continueWithRegisteredBusiness() throws Throwable{
    	page.submitForm();
    }
    
    @And ("^User moves to Standard Registration$")
    public void goToStandardRegistration() throws Throwable{
    	page.submitForm();
    }
    
    @And ("^User gets start$")
    public void getStart() throws Throwable{
    	page.submitForm();
    }
    
    @When ("^User fills in Personal Details form$")
    public void fillInPersonalDetailsForm() throws Throwable{
    	page.fillInPersonalDetailsForm();
    }

}
