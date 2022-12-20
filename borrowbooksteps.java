package pro1testforhw1;
import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pro1mainforhw1.Book;
import pro1mainforhw1.DateServer;
import pro1mainforhw1.client;
import pro1mainforhw1.errorhandling;

public class borrowbooksteps {
	client cc;
	//MockDateHolder dateHolder;
	boolean flagforreg=false;
	boolean borrowsucs=false;
	boolean theuserboorow=false;
	boolean removesucs=false;
	boolean removenotsucs=false;
	boolean bookwithcodefound=false;
	boolean flaglate=false;
	boolean flagpass=false;
	boolean retur=false;
	String errr;
	errorhandling er;
	DateServer dt;
	 public borrowbooksteps(client cl ,errorhandling e ,DateServer dt ) {
		 cc=cl;
		 er=e;
		 dt=dt;
		 
	 }
	 @Given("that the user with id {string} is regestered")
	 public void that_the_user_with_id_is_regestered(String id) {
	   
		 
	  for(client c : client.clients) {
		  if(c.id.equals(id)) {
			  cc=c;
			  
			  if(c.reg==1) {
				  flagforreg=true; 
			  }
		  }
	  }
	   
	   Book item=new Book();
	   item.title="XP Programming Book";
	   item.code="Kent99";
	   Book.iitems.add(item);
	   Book item2=new Book();
	   item2.title="Cucumber Java";
	   item2.code="Rose54";
	   Book.iitems.add(item2);
	   
	 }

	 @When("the user borrow  book with title {string}")
	 public void the_user_borrow_book_with_title(String title) {
	
		 if(cc.borroweditems2.size()<5) {
		 for(Book item: Book.iitems) {
			 if((item.title.equals(title))){
				 item.setDateServer(dt);
				cc.borroweditems2.add(item);
				borrowsucs=true;
			 }
		 }
	 
		 }}
	 @When("the user borrow  book with title {string} the user have borrowd numofbrrowd {string}")
	 public void the_user_borrow_book_with_title_the_user_have_borrowd_numofbrrowd(String string, String string2) {
	   if(borrowsucs==false) {	
		  
	   }
	 }

	 @Then("the user borrow the book  with title {string}")
	 public void the_user_borrow_the_book_with_title(String string) {
	    assertTrue(flagforreg &&borrowsucs);
	 }

@Given("the user borrowed the book with title {string}")
public void the_user_borrowed_the_book_with_title(String title) {
	for(Book item: Book.iitems) {
		 if((item.title.equals(title))){
			theuserboorow=true;
		 }
	 } 
}

@When("the user return the book with title {string}")
public void the_user_return_the_book_with_title(String title) {
	
	if(theuserboorow==true) {
		for(Book item: Book.iitems) {
		 if((item.title.equals(title))){
			cc.borroweditems2.remove(item);
			removesucs=true;
		 }
	 }
	
	
	
	
	}
	else {
		removesucs=false;
	}
   
}

@Then("the user not borrowed the book with title {string}")
public void the_user_not_borrowed_the_book_with_title(String string) {
	 assertTrue(flagforreg &&removesucs);
}


@Given("the user is not borrowed the book with title {string}")
public void the_user_is_not_borrowed_the_book_with_title(String string) {
    if(removesucs==false) {
    	removenotsucs=true;
    }
}

@Then("error message {string}  should be display")
public void error_message_should_be_display(String string) {
  if(string.equals("this book is not borrowed by you")) {
	 assertTrue(flagforreg &&removenotsucs); 
  }
}

@Given("a book with code {string} is in the library")
public void a_book_with_code_is_in_the_library(String code) {
for(Book item : Book.iitems) {
	if(item.code.equals(code)) {
		bookwithcodefound=true;
	}
}
}





@When("the user borrows the book with code {string}")
public void the_user_borrows_the_book_with_code(String code) {
	for(Book item : Book.iitems) {
		if(item.code.equals(code)&&cc.borroweditems2.size()<5) {
			if(item.late==true) {
				flaglate=true;
				
			}
			else {
				cc.borroweditems2.add(item);
				borrowsucs=true;
			}
		}
	}
}

@When("{int} dayes have passed")
public void dayes_have_passed(Integer int1) {
	flagpass=true;
	flaglate=true;
}

@Then("the book with code {string} is not borrowed by the user")
public void the_book_with_code_is_not_borrowed_by_the_user(String string) {
    assertTrue(flaglate&&flagforreg);
}

@Then("the error massege {string} is given")
public void the_error_massege_is_given(String string) {
	errr=string;
	 if(string.equals("you can't borrow any new book because you have an overdue books")) {
		 assertTrue(flagpass); 
	  }
}

@Then("the user has to pay a fine of {int} NIS")
public void the_user_has_to_pay_a_fine_of_nis(Integer int1) {
if(cc.fine>0) {
	assertTrue(true);
	
}
}

@When("the user returns the book with code {string}")
public void the_user_returns_the_book_with_code(String string) {
	flaglate=true;
if(cc.fine>0) {
	retur=true;
}
}
@Then("the error massage {string} is given")
public void the_error_massage_is_given(String string) {
if(retur==true) {
	errr="Can't borrow book, you have fines";
	if(string.equals(errr)) {
		assertTrue(true);
	}
}
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
