package pro1testforhw1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pro1mainforhw1.client;
import pro1mainforhw1.errorhandling;

public class userregester {

	client cl;
	boolean flaguserregsucs=false;
	boolean flagalreadyexist=false;
	boolean flaguserout=false;
	errorhandling er ;
	client c2;
	public userregester (client c ,errorhandling e ) {
		cl=c;
		er=e;
	
	}
	

	
	@Given("ther is a user with id {string} , name {string},email {string} ,address {string},postal code {string}, and city {string}")
	public void ther_is_a_user_with_id_name_email_address_postal_code_and_city(String id, String name, String email, String address, String postalcode, String city) {
	    for(client c :client.clients) {
	    	if(c.id.equals(id)) {
	    		flagalreadyexist=true;
	    		er.error ="This user is already registered";
	    	}
	    }
	    
	    if(flagalreadyexist==false) {
		loginsteps.loginflag=true;
		 cl.id=id;
		 cl.name=name;
		 cl.email=email;
		 cl.address=address;
		 cl.postcode=postalcode;
		 cl.city=city;
		 flaguserregsucs=true;
		 }
	}

	@When("the user with id {string} register")
	public void the_user_with_id_register(String string) {
		 cl.reg=1;
	}

	@Then("the user with with id {string} , name {string},email {string} ,address {string},postal code {string}, and city {string} is registered in the library")
	public void the_user_with_with_id_name_email_address_postal_code_and_city_is_registered_in_the_library(String string, String string2, String string3, String string4, String string5, String string6) {
		if(flagalreadyexist==false) {
		client.clients.add(cl);
		}
		assertTrue(flaguserregsucs && loginsteps.loginflag);

	}
	@Given("that the admin is logged in and the user is already registered")
	public void that_the_admin_is_logged_in_and_the_user_is_already_registered() {
		flagalreadyexist=true ;
		for(client c :client.clients) {
			
		}
	}
	@Then("error message {string} is given")
	public void error_message_is_given(String emessage) {
		
		if(flagalreadyexist==true ) {
	
		}
	    if(er.error.equals(emessage) || er.error.equals(emessage)) {
	    	assertTrue(true);
	    }
	    
	   
	}

@Given("the user with with id {string}")
public void the_user_with_with_id(String string) {
	c2 = new client();
	c2.id="5";
	client.clients.add(c2);
}
	@When("the admin try to unregister that user")
	public void the_admin_try_to_unregister_that_user() {
		
	    client.clients.remove(c2);
	}

	@Then("the user is out of library")
	public void the_user_is_out_of_library() {
for(client c : client.clients) {
	System.out.println("iddddd"+c.id);
	if(c.id.equals(c2.id)) {
		flaguserout=false;
	}
	else flaguserout=true;
}            assertTrue(flaguserout);
	}
	
	
	
	
	
	@Given("the user not return the borroed book")
	public void the_user_not_return_the_borroed_book() {
if(cl.borroweditems2.size()>0) {
	flaguserout=false;
}
	}
	@Given("the user has fines")
	public void the_user_has_fines() {
	  if(cl.fine>0) {
		  flaguserout=false;
	  }
	}
	@Then("the user is not out of library")
	public void the_user_is_not_out_of_library() {
		assertTrue(!flaguserout);
	}
	
	
	
	
}
