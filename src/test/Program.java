package test;

import java.util.List;
import java.util.Scanner;

//import javax.print.attribute.standard.Copies;
import pojo.Copies;
import pojo.Users;
import dao.BookDao;
import dao.CopiesDao;
import dao.UsersDao;
import pojo.Book;
public class Program 
{
	static Scanner sc = new Scanner(System.in);
	
//	public static void acceptRecord( String[] name )
//	{
//		System.out.print("Enter name	:	");
//		name[ 0 ] = sc.nextLine();
//	}
	
	private static int userMenu() 
	{
		System.out.println("0.Exit");
		System.out.println("1.Owner ");
		System.out.println("2.Librarian");
		System.out.println("3.Member");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
		
	}
	
	public static int umenuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.sign in ");
		System.out.println("2.sign up");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	
	private static int UserMenuList() {
		System.out.println("0.Signout");
		System.out.println("1.edit profile");
		System.out.println("2.change password");
		System.out.println("3.find book by name");
		System.out.println("4.check book availability");
		System.out.println("5.fees/fine");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}

	
	public static int ownerMenuList( )
	{
		System.out.println("0.Signout");
		System.out.println("1.edit profile");
		System.out.println("2.change password");
		System.out.println("3.subjectwise copies report");
		System.out.println("4.bookwise copies report");
		System.out.println("5.fees/fine");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
		
	}
	
	
	
	private static void acceptRecord(Book book) 
	{
		System.out.print("Book id	:	");
		book.setId(sc.nextInt());
		System.out.print("Book Name	:	");
		sc.nextLine();
		book.setName(sc.nextLine());
		System.out.print("Author Name	:	");
		book.setAuthor(sc.nextLine());
		System.out.print("Subject Name	:	");
		book.setSubject(sc.nextLine());
		System.out.print("Price	:	");
		book.setPrice(sc.nextFloat());
		System.out.print("ISBN	:	");
		book.setIsbn(sc.nextInt());
	}
	
	private static void acceptRecordCopy(Copies copy) {
		System.out.print("id	:	");
		copy.setId(sc.nextInt());
		
		System.out.print("Book id :");
		copy.setBookid(sc.nextInt());
		
		System.out.print("Rack:	");
		copy.setRack(sc.nextInt());
		
		System.out.print("Status :	");
		sc.nextLine();
		copy.setStatus(sc.nextLine());
		
	}
	
	private static void acceptRecordUsers(Users user) {
		System.out.print("User id	:	");
		user.setId(sc.nextInt());
		
		System.out.print("User Name	:	");
		sc.nextLine();
		user.setName(sc.nextLine());
		
		System.out.print("User Email	:	");
		
		user.setEmail(sc.nextLine());
		System.out.print("User Phone	:	");
		user.setPhone(sc.nextLine());
		System.out.print("PASSWORD	:	");
		user.setPasswd(sc.nextLine());
		System.out.print("Role	:	");
		user.setRole(sc.nextLine());
		
	}
	
	private static void printRecord(Book value)
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Record not found");
	}
	
	private static void printRecord(List<Book> books)
	{
		if( books != null )
		{System.out.println("---------------------------------------------------------------------------------------");
			for (Book book : books) 
				
				System.out.println(book.toString());
		}
		System.out.println("---------------------------------------------------------------------------------------");
	}
	public static int menuList( )
	{
		System.out.println("0.Logout");
		System.out.println("1.Edit Profile");
		System.out.println("2.Edit Password");
		System.out.println("3.Find Book By Name");
		
		System.out.println("4.Display All Books");
		System.out.println("5.Insert Book");
		System.out.println("6.Add New Copy ");
		System.out.println("10.Edit Book");
		System.out.println("11. Change Rack");
		
		System.out.println("12.Add New Member ");
		System.out.println("15.Delete Book");

		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{		
		String[] name1 = new String[ 1 ]; 
		try( BookDao dao = new BookDao();CopiesDao dao2= new CopiesDao();
				UsersDao dao3= new UsersDao())
		{
			int choice, bookId,id,rack;
			String name,email,phone,passwd;
			float price;
			
			while((choice = Program.userMenu() ) != 0)
			{
				switch(choice)
				{
				case 0:
					break;
					
				case 1:
					while((choice = Program.ownerMenuList( ) ) !=0 )
					{
//						int id1;
//						String email1,passwd1;
//						String contact;						
							switch( choice )
							{
							case 0: 
								System.out.println("signout successfully");
								System.out.println();
							
								break;
							case 1:
								System.out.print("Enter user id	:	");
								id = sc.nextInt();
								
								System.out.print("Enter Name	:	");
								sc.nextLine();
								name = sc.nextLine();
								System.out.print("Enter Email	:	");
								email = sc.nextLine();
								System.out.print("Enter phone number	:	");
								phone= sc.nextLine();
								
								dao3.update( id, name,email,phone );
								break;
								
							case 2:
								System.out.print("Enter  id	:	");
								id = sc.nextInt();
								System.out.print("Enter passwd	:	");
								passwd = sc.nextLine();
								dao3.updatePasswd(id, passwd);
								break;
							
							case 3:
								System.out.println("SubjectWise copies Report");
								System.out.println("subject :java    count:7");
								System.out.println();
								break;
							
							case 4:
								System.out.println("Bookwise copies Report");
								System.out.println("id:1  name :java   available:5   issued:2   count:7");
								System.out.println();
								break;
							
							case 5:
								System.out.println("________________________");
								System.out.println("Fees/fine report");
								System.out.println("from date: 20/8/2019");
								System.out.println("from date: 30/9/2019");
								System.out.println("type:fee : amount:4200");
								System.out.println("type:fine   amount:50");
								System.out.println("________________________");
								System.out.println();
								break;
							}
					}
					break;
					
					//------------------> Librarian
				case 2:
					while( ( choice = Program.menuList( ) ) != 0 )
					{
						switch( choice )
						{
						case 0:
							break;
						case 1:
							System.out.print("Enter user id	:	");
							id = sc.nextInt();
							
							System.out.print("Enter Name	:	");
							sc.nextLine();
							name = sc.nextLine();
							System.out.print("Enter Email	:	");
							email = sc.nextLine();
							System.out.print("Enter phone number	:	");
							phone= sc.nextLine();
							
							dao3.update( id, name,email,phone );
							break;
							
						case 2:
							System.out.print("Enter  id	:	");
							id = sc.nextInt();
							System.out.print("Enter passwd	:	");
							passwd = sc.nextLine();
							dao3.updatePasswd(id, passwd);
							break;
							
						case 3:
//							Program.acceptRecordName( name );
							//Book value = findRecord( name1[ 0 ] );
							//Program.printRecord( value );
							break;
							
						case 4:
							List<Book> books = dao.getBooks();
							Program.printRecord( books );
							break;
						case 5:
							Book book = new Book();
							Program.acceptRecord( book );
							dao.insert( book );
							break;
							
						case 6:
							Copies copy = new Copies();
							Program.acceptRecordCopy(copy);
							dao2.insert(copy);
							break;
							
						case 10:
							System.out.print("Enter book id	:	");
							bookId = sc.nextInt();
							System.out.print("Enter price	:	");
							price = sc.nextFloat();
							dao.update( bookId, price );
							break;
							
							
						case 11:
							System.out.print("Enter book id	:	");
							bookId = sc.nextInt();
							System.out.print("Change Rack Number	:	");
							rack = sc.nextInt();
							dao2.update( bookId, rack );
							break;
							
						case 12:
							Users user = new Users();
							Program.acceptRecordUsers( user );
							dao3.insert( user );
							break;
							
						case 15:
							System.out.print("Enter book id	:	");
							dao.delete( sc.nextInt() );
							break;
						
						}
					}
					break;
					
				case 3:
					while((choice = Program.UserMenuList())!= 0)
					{
						
					}
					
					break;
				}
				
			}
			
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}

	
	
	
	
}
