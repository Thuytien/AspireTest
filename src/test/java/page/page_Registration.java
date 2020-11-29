package page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

import handler.Test;
import object.Customer;
import util.UtilConst;
import util.UtilData;

public class page_Registration {
	//Home
	private String registerXpath = "//div[@class='login-step-start__register']//a[contains (@class,'register-link')]";
	
	//Register_Person
	private String nameXpath = "//input[@name='full_name' and @data-cy = 'register-person-name']";
	private String emailXpath = "//input[@name='email' and @data-cy = 'register-person-email']";
	private String phoneXpath = "//input[@name='phone' and @data-cy = 'register-person-phone']";
	private String roleXpath = "//div[@role='radiogroup' and contains(@class,'register-step-person')]//div[@role='radio']";
	private String heardXpath = "//div[@data-cy='register-person-heard-about']//input";
	private String referralXpath = "//input[@data-cy='register-person-referral-code']";
	private String privacyXpath = "//div[contains (@class,'register-step-person__privacy')]//div[@role='checkbox']";
	private String submitBtnXpath = "//button[contains(@class,'q-btn q-btn-item')]";
	
	private String countryCodeXpath = "//div[contains (@data-cy,'register-person-phone') and contains (@label,'Phone number')]";
	private String setPhoneXpath = "//div[@name='phone' and @data-cy = 'register-person-phone']";
	private String heardAboutXpath = "//div[contains (@data-cy,'register-person-heard-about') and contains (@label,'Where did you hear about us?')]";
	
	//Register_PhoneOTP
	private String otpPhoneXpath = "//div[contains (@class,'digit-input__box')]"; 
	private String otpInputXpath = "//div[contains (@class,'digit-input__input--highlight')]";
	
	//Register_PhoneOTP_Done
	private String successMsg = "You have successfully verified your phone number. You’re on to a great start!";
	private String successMsgXpath = "//div[contains(@class,'aspire-cta-screen__content')]//p";
	//submitBtnXpath
	
	//Register_Business
	//submitBtnXpath: business in SGP; not yet
	
	//Personal Details
	//submitBtnXpath
	private String dobXpath = "//div[@label='Date of Birth']//descendant::input";
	private String month_yearXpath = "//div//button[contains (@class,'q-btn--no-uppercase')]";
	private String pre_nextPageXpath = "//div[contains (@class,'col-auto')]//button";
	private String valueXpath = "//span[text()='$$$']";
	
	
	private String nationalityXpath = "//div[@label='Nationality']";
	private String selectNationXpath = nationalityXpath+"//descendant::span";
	
	private String genderXpath = "//div[@label='Gender' and @placeholder='Set your gender']";
	
	private String purposeXpath = "//div[@data-cy='person-edit-purposes' and @class='q-field__native row items-center']";
	private String selectPurposeXpath = purposeXpath + "//descendant::span";
	
	//Business Details
	//submitBtnXpath
	private String businessNameXpath = "//div[@label='Business Name']//descendant::input";
	private String regTypeXpath = "//div[@label='Registration Type']//descendant::input";
	private String businessNumberXpath = "//div[@label='Business Registration Number (UEN)']//descendant::input";
	private String industryXpath = "//input[@data-cy='register-business-industry']";
	private String subIndustryXpath = "//input[@data-cy='register-business-sub-industry']";
	
	//Identify Details
	//submitBtnXpath
	//submitBtnXpath
	
	
	private String src_nondirector = "//div[@role='ratio' and @arial-label='Non-director']//div";
	private String sourceSelectorXpath = "//div[@data-cy='register-person-heard-about']/input";
	
	private Customer customer = new Customer();
	private ArrayList<String> roles = new ArrayList<String>();
	private ArrayList<String> sources = new ArrayList<String>();
	private ArrayList<String> genders = new ArrayList<String>();
	private ArrayList<String> purposes = new ArrayList<String>();

	public void goToRegisterPage() {
		Test.clickElement(registerXpath);
		Test.waitPageLoad();
	}
	
	public void generateCustomer() {
		UtilConst.initialSetup();
		roles = UtilConst.roles;
		sources = UtilConst.sources;
		genders = UtilConst.genders;
		purposes = UtilConst.purposes;
		
		customer.name = UtilData.generateAlphaString(5);
		customer.email = customer.name + "@email.com";
		customer.countryCode = "+84";
		customer.phoneNumber =  String.valueOf(UtilData.generateNumber(8));
		//customer.role = UtilConst.roles.get(UtilData.randInt(0, 1));
		customer.role = UtilConst.roles.get(0);
		int size = UtilConst.sources.size();
		int index = UtilData.randInt(0, size-1);
		customer.source = UtilConst.sources.get(index);
	}
	
	public void fillInRegisterPersonal() {
		generateCustomer();
		Test.clearThenTextOnElement(nameXpath, customer.name);
		Test.clearThenTextOnElement(emailXpath, customer.email);
//		Test.setElementAttribute(phoneXpath, "value", customer.countryCode);
		Test.clearThenTextOnElement(phoneXpath, customer.phoneNumber);
		String phone = customer.countryCode + customer.phoneNumber;
		Test.setElementAttribute(setPhoneXpath, "value", phone);
//		System.out.println(Test.getElementAttribute(setPhoneXpath, "value"));
//		Test.waitPageLoad();
		String isCheck = "";
		if(customer.role.equals(UtilConst.roles.get(0)))
		{
			List<WebElement> roles = Test.waitForAllElements(roleXpath);
			isCheck = Test.getElementAttribute(roles.get(0), "aria-checked");
			if(isCheck.equals("false")) {
				roles.get(0).click();
			}
		}
		else {
			List<WebElement> roles = Test.waitForAllElements(roleXpath);
			isCheck = Test.getElementAttribute(roles.get(1), "aria-checked");
			if(isCheck.equals("false")) {
				roles.get(1).click();
			}
		}
		Test.setElementAttribute(heardAboutXpath, "value", customer.source);
//		System.out.println(Test.getElementAttribute(heardAboutXpath, "value"));
//		Test.waitPageLoad();
		Test.clickElement(privacyXpath);
	}
	
	public void submitForm() {
		Test.clickElement(submitBtnXpath);
		Test.waitPageLoad();
	}
	
	public void enterOTPCodeStep2(String code) {
		Test.clickElement(otpPhoneXpath);
		for (int i=1; i<5; i++) {
			Test.clickThenTypeOnElement(otpInputXpath, String.valueOf(i));
		}
		Test.waitPageLoad();
	}
	
	public void fillInPersonalDetailsForm() {
		Test.clickElement(dobXpath);
		String yearXpath = valueXpath.replace("$$$", "2000");
		List<WebElement> dob = new ArrayList<WebElement>();
		dob = Test.waitForAllElements(month_yearXpath);
		WebElement year = dob.get(1);
		year.click();
		while (!Test.doesElementExist(yearXpath)) {
			WebElement preBtn = Test.waitForAllElements(pre_nextPageXpath).get(0);
			preBtn.click();
		}
		Test.clickElement(yearXpath);
		String dateXpath = valueXpath.replace("$$$", "1");
		Test.clickElement(dateXpath);
		
		Test.clickElement(nationalityXpath);
		Test.setElementText(selectNationXpath, "Singapore");
//		System.out.println(Test.getElementText(selectNationXpath));
		
		Test.clickElement(genderXpath);
		String gender = genders.get(UtilData.randInt(0, 1));
		Test.setElementAttribute(genderXpath, "value", gender);
		Test.clickOutsideElement(genderXpath);
		System.out.println(gender);
		System.out.println(Test.getElementAttribute(genderXpath,"value"));
		
		Test.clickElement(purposeXpath);
		String purpose = purposes.get(UtilData.randInt(0, purposes.size()-1));
		Test.setElementText(selectPurposeXpath, purpose);
		Test.clickOutsideElement(selectPurposeXpath);
//		System.out.println(Test.getElementText(selectPurposeXpath));
		
	}
}
