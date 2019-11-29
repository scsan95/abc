package pojo;



public class Book 
{
	int id;
	String name;
	String author;
	String subject;
	float price;
	int isbn;
	
	public Book(int id, String name, String author, String subject, float price, int isbn) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
		this.isbn = isbn;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
//		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", price=" + price
//				+ ", isbn=" + isbn + "]";
		return String.format("%-5d%-20s%-60s%-30s%-10.2f\n", this.id, this.name, this.author, this.subject, this.price,this.isbn);
	}

	@Override
	public boolean equals(Object b1) {
		
		if(b1 != null)
		{
			Book other = (Book) b1;
			if(this.name == other.name);
			return true;
		}
		return false;
	}
	
	
	
}
