package pro1mainforhw1;

import java.util.ArrayList;
import java.util.Calendar;

public class Book extends Itemm {

	public String title;
	public String author;
	public String signature;
	public boolean added;
	public String code;
	public DateServer dateServ;
	public EmailServer emailServer= new EmailServer();
	public Calendar dateofb;
	public boolean late=false;
	
	public static ArrayList<Book> iitems ;
	public Book() {
		dateServ= new DateServer();
	}
	public void setDateServer(DateServer dateServ) {
		this.dateServ=dateServ;
		
	}
	public void setEmailServer(EmailServer emailServer) {

	}
	public void sendreminder(String email ,String su ,String body) {
		emailServer.senEmail(email, su, body);
	}

}
