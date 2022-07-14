package LibraryWebApplication.entity;

public class record {
private int id;
private String ssn;
private String return_date;
private int book_id;




public record(int id, String ssn, String return_date, int book_id) {
	super();
	this.id = id;
	this.ssn = ssn;
	this.return_date = return_date;
	this.book_id = book_id;
}



public record( String ssn, String return_date, int book_id) {
	super();
	
	this.ssn = ssn;
	this.return_date = return_date;
	this.book_id = book_id;
}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}
public String getSsn() {
	return ssn;
}
public void setSsn(String ssn) {
	this.ssn = ssn;
}
public String getReturn_date() {
	return return_date;
}
public void setReturn_date(String return_date) {
	this.return_date = return_date;
}
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}


}
