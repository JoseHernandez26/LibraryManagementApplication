package LibraryWebApplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import LibraryWebApplication.entity.record;
import LibraryWebApplication.entity.Book;

public class recordModel {

	
	public List<record> listRecords(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<record> listRecords = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from record";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listRecords.add(new record(rs.getInt("id"), rs.getString("ssn"), rs.getString("return_date"),rs.getInt("book_id")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listRecords;
	}
	
	public void AddRecord(DataSource dataSource, Book updatedBook,record newRecord) {
		Connection connect = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		try {
			connect = dataSource.getConnection();
			String ssn = newRecord.getSsn();
			String return_date = newRecord.getReturn_date();
			int book_id= newRecord.getBook_id();
			

			String query2 = "insert into record (ssn,return_date,book_id) values (?,?,?)";
			statement2 = connect.prepareStatement(query2);
			statement2.setString(1, ssn);
			statement2.setString(2, return_date);
			statement2.setInt(3, book_id);
			statement2.execute();
			
			int id = updatedBook.getId();
			String name = updatedBook.getName();
			String type = updatedBook.getType();
			String status = updatedBook.getStatus();
			String query = "update book set name = ? , type = ?,status =?  where id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, type);
			statement.setString(3, status);
			statement.setInt(4, id);
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
