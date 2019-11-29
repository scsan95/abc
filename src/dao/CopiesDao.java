package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Copies;
import utils.DBUtils;

public class CopiesDao implements Closeable
{
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	
	private PreparedStatement deleteStatement;
	private PreparedStatement selectStatement;
	public CopiesDao()throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareStatement("INSERT INTO copies VALUES(?,?,?,?)");
		this.updateStatement = connection.prepareStatement("UPDATE copies SET rack=? WHERE bookid=?");
		this.deleteStatement = connection.prepareStatement("DELETE FROM books WHERE id=?");
		this.selectStatement = connection.prepareStatement("SELECT * FROM copies");
	}
	public int insert(Copies copy)throws Exception
	{
		this.insertStatement.setInt(1, copy.getId());
		this.insertStatement.setInt(2, copy.getBookid());
		this.insertStatement.setInt(3, copy.getRack());
		this.insertStatement.setString(4, copy.getStatus());
		
		
		return this.insertStatement.executeUpdate();
	}
	
	public int update(int bookId, int rack)throws Exception {
		this.updateStatement.setInt(1, rack);
		this.updateStatement.setInt(2, bookId);
		return this.updateStatement.executeUpdate();
	}
	
	public int delete(int BookId) throws Exception
	{
		this.deleteStatement.setInt(1, BookId);
		return this.deleteStatement.executeUpdate();
	}
	
	
	public List<Copies> getCopies()throws Exception
	{
		List<Copies> copyList = new ArrayList<Copies>();
		try( ResultSet rs = this.selectStatement.executeQuery())
		{
			while( rs.next())
			{
				Copies copy = new Copies(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				copyList.add(copy);
			}
		}
		return copyList;
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
