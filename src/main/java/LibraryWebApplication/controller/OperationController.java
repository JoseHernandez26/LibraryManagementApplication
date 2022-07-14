package LibraryWebApplication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



import LibraryWebApplication.entity.Book;
import LibraryWebApplication.model.BookModel;

import LibraryWebApplication.entity.record;
import LibraryWebApplication.model.recordModel;

@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "listbooks":
			listBooks(request, response);
			break;
		case "addbooks":
			addBookFormLoader(request, response);
			break;
		case "updatebook":
			UpdateBookFormLoader(request, response);
			break;
		case "listrecords":
			listRecords(request, response);
			break;	
		case "detailbooks":
			detailBooks(request, response);
		
			break;
		case "addrecord":
			addRecordFormLoader(request, response);
			break;	
		default:
			errorPage(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "addbookoperation":
		Book newBook= new Book(request.getParameter("name"), request.getParameter("type"),request.getParameter("status"));	
        AddBookOperation(dataSource,newBook);
        listBooks(request, response);
        break;
        
		case "updatebookoperation":
			Book updatedBook = new Book(Integer.parseInt(request.getParameter("id")),
					request.getParameter("name"), request.getParameter("type"),request.getParameter("status"));
			updateBookOperation(dataSource, updatedBook);
			   listBooks(request, response);
			break;
		
		
			
		case "addrecordoperation":
			Book updatedBook2 = new Book(Integer.parseInt(request.getParameter("id")),
					request.getParameter("name"), request.getParameter("type"),request.getParameter("status"));
			record newRecord= new record(request.getParameter("ssn"), request.getParameter("return_date"),Integer.parseInt(request.getParameter("book_id")));	
			AddRecordOperation(dataSource,updatedBook2,newRecord);
			
			
			
			
			listRecords(request, response);
			break;

		default:
			errorPage(request, response);
			break;
		}
	}
	private void updateBookOperation(DataSource dataSource, Book updatedBook) {
		new BookModel().updateBook(dataSource,updatedBook);
		return;
		
	}

	
	
	private void AddBookOperation(DataSource dataSource,Book newBook) {
		new BookModel().AddBook(dataSource, newBook);
		return; 
	}
	
	private void AddRecordOperation(DataSource dataSource,Book updatedBook,record NewRecord) {
		new recordModel().AddRecord(dataSource, updatedBook, NewRecord);
		return; 
	}
	
	public void addRecordFormLoader(HttpServletRequest request, HttpServletResponse response)
			 {	
		request.setAttribute("title", "Add Record");
		try {
			request.getRequestDispatcher("addRecord.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void detailBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<record> listRecords = new ArrayList<>();
		listRecords= new BookModel().DetailBooks(dataSource);
		request.setAttribute("listRecords",listRecords);
		request.setAttribute("title", "List of books");
		request.getRequestDispatcher("detailBook.jsp").forward(request, response);
		
		
	
		
		
	}
	
	public void listBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> listBooks = new ArrayList<>();
		listBooks= new BookModel().listBooks(dataSource);
		request.setAttribute("listBooks",listBooks );
		request.setAttribute("title", "List of books");
		request.getRequestDispatcher("listBook.jsp").forward(request, response);
		
		
	
		
		
	}
	


	
	//listing records
	public void listRecords(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<record> listRecords = new ArrayList<>();
		listRecords= new recordModel().listRecords(dataSource);
		request.setAttribute("listRecords",listRecords );
		request.setAttribute("title", "List of records");
		request.getRequestDispatcher("listRecord.jsp").forward(request, response);
		
		
	
		
		
	}
	
	public void listRecordsForDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<record> listRecords = new ArrayList<>();
		listRecords= new recordModel().listRecords(dataSource);
		request.setAttribute("listRecords",listRecords );
		request.setAttribute("title", "List of records");
		request.getRequestDispatcher("detailBook.jsp").forward(request, response);
		
		
	
		
		
	}
	
	public void addBookFormLoader(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setAttribute("title", "Add Book");
		request.getRequestDispatcher("addBook.jsp").forward(request, response);
		
	}
	
	private void UpdateBookFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update Book");
		try {
			request.getRequestDispatcher("updateBook.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setAttribute("title", "Error page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}
}
