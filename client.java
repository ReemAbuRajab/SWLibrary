package pro1mainforhw1;


import java.util.ArrayList;

public class client {
	public static ArrayList<client> clients =new ArrayList<client>() ;
	public String password;
	public String city;
	public String postcode;
	public String tyb;
	public String address;
	public String email;
	public String name;
	public String id;
	public int fine=0;
	public int reg=0;
	public boolean late=false;
	
	
	public  ArrayList<Book> borroweditems2 =new ArrayList<Book>() ;


	public int checkpass(String string) {

		if(string.equals("adminadmin")) {
			return 1;
		}
		
		return 0;
	}

	

}
