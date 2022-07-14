package LibraryWebApplication.entity;
import LibraryWebApplication.entity.record;

import java.util.ArrayList;
import java.util.List;

import LibraryWebApplication.entity.Book;


public class ListaBookAndRecords {
	
	public List<record> listRecords = new ArrayList<>(); 	
	public List<Book> listBooks = new ArrayList<>();
	public List<record> getListRecords() {
		return listRecords;
	}
	public void setListRecords(List<record> listRecords) {
		this.listRecords = listRecords;
	}
	public List<Book> getListBooks() {
		return listBooks;
	}
	public void setListBooks(List<Book> listBooks) {
		this.listBooks = listBooks;
	} 	
	
	
}
