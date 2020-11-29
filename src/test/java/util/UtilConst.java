package util;

import java.util.List;
import java.util.ArrayList;

public class UtilConst {
	public static ArrayList<String> roles = new ArrayList<String>();
	public static ArrayList<String> sources = new ArrayList<String>();
	public static ArrayList<String> genders = new ArrayList<String>();
	public static ArrayList<String> purposes = new ArrayList<String>();
	
	public static void initialSetup() {
		//set roles
		roles.add("Appointed director");
		roles.add("Non-director");
		
		//set sources
		sources.add("Facebook");
		sources.add("Google");
		sources.add("LinkedIn");
		sources.add("Referral");
		sources.add("Brochure");
		sources.add("Friends and relatives");
		sources.add("Online Articles");
		sources.add("Payment Invitation");
		sources.add("Brokers");
		sources.add("Others");
		
		//set genders
		genders.add("Male");
		genders.add("Female");
		
		//set purposes
		purposes.add("Credit Line");
		purposes.add("Debit Card");
		purposes.add("Invoice Financing");
		purposes.add("Others");
	}
	
	public static void setRoles() {
		roles.add("Appointed director");
		roles.add("Non-director");
	}
	
	public static void setSources() {
		sources.add("Facebook");
		sources.add("Google");
		sources.add("LinkedIn");
		sources.add("Referral");
		sources.add("Brochure");
		sources.add("Friends and relatives");
		sources.add("Online Articles");
		sources.add("Payment Invitation");
		sources.add("Brokers");
		sources.add("Others");
	}
	
}
