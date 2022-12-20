package pro1testforhw1;

import static org.junit.Assert.assertTrue;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Duration;

import pro1mainforhw1.Book;
import pro1mainforhw1.client;

public class TimeSteps {
MockDateHolder dateHolder;
client c;
String title;
boolean flagisborrow=false;
boolean late=false;
public TimeSteps(MockDateHolder dateHolder ,client c) {
	
	this.dateHolder=dateHolder;
	this.c=c;
	  
}
public static long getDifference(Calendar b, Calendar a, TimeUnit units) 
{

    return units.convert(b.getTimeInMillis() - a.getTimeInMillis(), TimeUnit.MILLISECONDS);
}
@Given("that the user with id {string} has borrowed a book with title {string}")
public void that_the_user_with_id_has_borrowed_a_book_with_title(String id, String title) {
	c.id=id;
	Book item2 =new Book();
	title="XP Programming Book";
	item2.title="XP Programming Book";
	item2.dateofb=item2.dateServ.getDate();
	
	c.borroweditems2.add(item2);

	for(client cl : client.clients) {
		if(cl.id.equals(id)) {
			
			
			 Book item=new Book();
			 item.title="XP Programming Book";
			   Book.iitems.add(item);
			   c.borroweditems2.add(item);
			   c=cl;
		}
	}
	
	
	for(Book item : c.borroweditems2) {
		System.out.println(item.title);
	  if(item.title.equals(title )) {
		  flagisborrow=true;
		  this.title=title;
	  }
  }
}

@Given("{int} days have passed")
public void days_have_passed(Integer int1) {
	dateHolder.advance(int1);
	
	for(Book item : c.borroweditems2) {
		 if(item.title.equals(title )) {
	
			
			  long daysBetween=getDifference(MockDateHolder.nextdate,item.dateofb.getInstance(),TimeUnit.DAYS);
			  
			  if(daysBetween>=21) {
				  item.late=true;
				  late=true;
			  }
			 
		  }
	  }
	
	late=true;
	
}

@Given("the fine for one late book is {int} NIS")
public void the_fine_for_one_late_book_is_nis(Integer int1) {
	  for(Book item : c.borroweditems2) {
		  if(item.title.equals(title )) {
			  
			  
			  c.fine+=int1;
			  System.out.println( "fine "+c.fine);
		  }
	  }
	  
}

@Then("the user with id {string} has Late books")
public void the_user_with_id_has_late_books(String id) {
	
assertTrue(late);

}

@Then("the user with id {string} has to pay a fine of {int} NIS")
public void the_user_with_id_has_to_pay_a_fine_of_nis(String string, Integer int1) {
	assertTrue(c.fine>0);
	
}

}
