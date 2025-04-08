package com.book.start.dao;

import java.util.List;

import com.book.start.model.Book;
//DAO interface:-data access method declaration
public interface BookDao {

	public int addBook(Book bk);
	
	public int deleteBook(int bookId);
	
	public Book getBookinfo(int bookId);
	
	public List<Book> getAllBooks();
	
}
