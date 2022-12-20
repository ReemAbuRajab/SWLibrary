package pro1testforhw1;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pro1mainforhw1.Book;


public class searchsteps {
	 
	    
		boolean flagcodefound=false;
		boolean flagtitlefound = false;
		boolean flagautherfound = false;
		boolean flagmorethanone=false;
		
	public searchsteps( ArrayList<Book>  item) {
			Book.iitems=item;
			loginsteps.loginflag=true;
	}
	@Given("these books are contained in the library")
	public void these_books_are_contained_in_the_library(io.cucumber.datatable.DataTable dataTable) {

	for(int i=0 ;i<dataTable.height() ;i++) {
		Book item1=new Book();
		item1.added=true;
		item1.author=dataTable.cell(i, 1)+" ";
		item1.signature=dataTable.cell(i, 2);
		item1.title=dataTable.cell(i, 0)+" ";
		String tmp=dataTable.cell(i, 2);
		item1.code=tmp.replaceAll("[^0-9]", "");
		
		System.out.println(item1.code);
		Book.iitems.add(item1);
	}

	}

	@When("the user searches for the text {string}")
	public void the_user_searches_for_the_text(String string) {
	 loginsteps.loginflag=false;
     String[] titles = null;
     String[] authers = null;
     int titlecounter=0;
	  flagcodefound=false;
	  String s="";
	  String auther="";
	  for(Book itemm: Book.iitems) {
		  if(itemm.code.equals(string)) {
			  flagcodefound=true;
		  }
		  s=s+itemm.title;
		  auther=auther+itemm.author;

	  }
	  titles=s.split(" ");
	  authers=auther.split(" ");
	  
	  for(int i=0  ; i<titles.length ;i++) {
		
		  if(titles[i].equals(string)) {
			 flagtitlefound = true;
			 titlecounter++;
		  }
	  }
	  
	  if(titlecounter>1) {
		  flagmorethanone=true;
	  }
	  
	  for(int i=0  ; i<authers.length ;i++) {
		  
		  if(authers[i].equals(string)) {
			 flagautherfound = true;
		  }
	  }
	  
	}

	@Then("the book with code {string} is found")
	public void the_book_with_code_is_found(String string) {
	 assertTrue((flagcodefound  ||flagtitlefound || flagautherfound)&& !loginsteps.loginflag);
	}
	@Then("no books are found")
	public void no_books_are_found() {
		assertTrue(!(flagcodefound && !loginsteps.loginflag ||flagtitlefound || flagautherfound));
	}
	@Then("the books with code {string} and {string} are found")
	public void the_books_with_code_and_are_found(String string, String string2) {
		assertTrue(flagmorethanone);
	}


}
