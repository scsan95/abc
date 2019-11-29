package pojo;

public class Copies {
int id;
int bookid;
int rack;
String status;
public Copies(int id, int bookid, int rack, String status) {
	super();
	this.id = id;
	this.bookid = bookid;
	this.rack = rack;
	this.status = status;
}

public Copies() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public int getRack() {
	return rack;
}
public void setRack(int rack) {
	this.rack = rack;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
//	return "Copies [id=" + id + ", bookid=" + bookid + ", rack=" + rack + ", status=" + status + "]";
	return String.format("%-5d | %-20s% | -60s% | -30s% | -10.2f | \n", this.id, this.bookid, this.rack, this.status);
}



}
