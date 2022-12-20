package pro1testforhw1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pro1mainforhw1.Book;
import pro1mainforhw1.client;
import pro1mainforhw1.errorhandling;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
public class EMailSteps {
Book lip;
MockEmailServer emailserverholder;
errorhandling errorMessageholder;
client c;
public EMailSteps (Book lib ,client c,MockEmailServer emailserverholder ,errorhandling errorMessageholder ) {
this.lip=lib;
this.c=c;
this.emailserverholder=emailserverholder;
this.errorMessageholder=errorMessageholder;

}

@Given("there is a user with id {string} with atleast one late book")
public void there_is_a_user_with_id_with_atleast_one_late_book(String string) {
	c.fine+=30;
	c.email="salam@gmail.com";

}

@When("the admin sends a reminder email")
public void the_admin_sends_a_reminder_email() {
client c2= new client();
c2.tyb="admin";
lip.sendreminder(c.email, "Late book(s)", "you have n late book(s)");
emailserverholder.simulatesending(c.email,"Late book(s)", "you have n late book(s)");
}


@Then("then the user should receive an email with subject {string} and bode {string}")
public void then_the_user_should_receive_an_email_with_subject_and_bode(String subject, String bode) {
  
	verify(emailserverholder.getMockEmailServer()).senEmail(c.email,subject,bode);
}






}
