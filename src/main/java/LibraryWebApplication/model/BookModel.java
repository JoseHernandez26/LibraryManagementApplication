package LibraryWebApplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import LibraryWebApplication.entity.Book;
import LibraryWebApplication.entity.ListaBookAndRecords;
import LibraryWebApplication.entity.record;

public class BookModel {
	public List<Book> listBooks(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<Book> listBooks = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;       
        try {
			connect = dataSource.getConnection();			
			// Step 2: Create a SQL statements string
			String query = "Select * from book";
			stmt = connect.createStatement();
			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
			// Step 4: Process the result set
			while(rs.next()){
				listBooks.add(new Book(rs.getInt("id"), rs.getString("name"), rs.getString("type"),rs.getString("status")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return listBooks;
	}
	
	
	public List<record> DetailBooks(DataSource dataSource) {
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

	public boolean AddBook(DataSource dataSource, Book newBook) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
			String name = newBook.getName();
			String type = newBook.getType();
			String status = newBook.getStatus();
			
			String query = "insert into book (name,type,status) values (?,?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, type);
			statement.setString(3, status);
			return statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		

	}
	public void updateBook(DataSource dataSource, Book updatedBook) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = dataSource.getConnection();
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
