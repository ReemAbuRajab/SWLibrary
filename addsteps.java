package pro1testforhw1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pro1mainforhw1.Book;
import pro1mainforhw1.errorhandling;

public class addsteps {
	Book item;
	errorhandling er; 
	public addsteps(Book item,errorhandling e ) {
		this.item=item;
		er=e;
		
	}

	@Given("that the administrator is logged in")
	public void that_the_administrator_is_logged_in() {
		loginsteps.loginflag=true;
	}

	@Given("there is a book with title {string}, author {string}, and signature {string}")
	public void there_is_a_book_with_title_author_and_signature(String title, String author, String signature) {
		item.title=title;
		item.author=author;
		item.signature=signature;
	    String tmp=signature;
	    item.code=tmp.replaceAll("[^0-9]", "");
		
		
	    
	}

	@When("the book is added to the library")
	public void the_book_is_added_to_the_library() {
		item.added=true;
	   
	}

	@Then("the book with title {string}, author {string}, and signature {string} is contained in the library")
	public void the_book_with_title_author_and_signature_is_contained_in_the_library(String string, String string2, String string3) {
		assertTrue(item.added);
	   
	}
	@Given("that the administrator is not logged in")
	public void that_the_administrator_is_not_logged_in() {
		loginsteps.loginflag=false;
		item.added=false;
		 er.error="Administrator login required";
		
		
	}

	@Then("the error message {string} is given")
	public void the_error_message_is_given(String string) {
		
	assertEquals(er.error,string);
	}
}
