package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import pojo.Users;
import utils.DBUtils;

public class UsersDao implements Closeable
{
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement updateStatementPasswd;
	private PreparedStatement deleteStatement;
	private PreparedStatement selectStatement;
	public UsersDao()throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?)");
		
//		dao3.update( id, name,email,phone );
		this.updateStatement = connection.prepareStatement("UPDATE users SET name=? , email=? , phone=? WHERE id=?");
		this.updateStatementPasswd = connection.prepareStatement("UPDATE users SET passwd=? WHERE id=?");
		//this.deleteStatement = connection.prepareStatement("DELETE FROM books WHERE id=?");
		//this.selectStatement = connection.prepareStatement("SELECT * FROM books");
	}
	public int insert(Users user)throws Exception
	{
		this.insertStatement.setInt(1, user.getId());
		this.insertStatement.setString(2, user.getName());
		this.insertStatement.setString(3, user.getEmail());
		this.insertStatement.setString(4, user.getPhone());
		this.insertStatement.setString(5, user.getPasswd());
		this.insertStatement.setString(6, user.getRole());
		
		return this.insertStatement.executeUpdate();
	}
	
	public int update(int id, String name, String email, String phone)throws Exception {
		this.updateStatement.setString(1, phone);
		this.updateStatement.setString(2, email);
		this.updateStatement.setString(3, name);
		this.updateStatement.setInt(4, id);
		return this.updateStatement.executeUpdate();
		
	}
	
	public int updatePasswd(int id, String passwd)throws Exception
	{
		this.updateStatement.setString(1, passwd);
		this.updateStatement.setInt(2, id);
		return this.updateStatement.executeUpdate();
	}
	
	public int delete(int bookId) throws Exception
	{
		this.deleteStatement.setInt(1, bookId);
		return this.deleteStatement.executeUpdate();
	}
	public List<Book> getBooks()throws Exception
	{
		List<Book> bookList = new ArrayList<Book>();
		try( ResultSet rs = this.selectStatement.executeQuery())
		{
			while( rs.next())
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6));
				bookList.add(book);
			}
		}
		return bookList;
	}
	@Override
	public void close() throws IOException 
	{
		try
		{
			this.insertStatement.close();
			this.updateStatement.close();
			this.deleteStatement.close();
			this.selectStatement.close();
			this.connection.close();
		}
		catch( SQLException cause )
		{
			throw new IOException(cause);
		}
	}
	
	
}
