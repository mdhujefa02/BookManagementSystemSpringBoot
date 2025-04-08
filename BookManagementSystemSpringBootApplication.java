package com.book.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.book.start.dao.BookDao;
import com.book.start.model.Book;

@SpringBootApplication
public class BookManagementSystemSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BookManagementSystemSpringBootApplication.class, args);
	
		BookDao dao=(BookDao) ctx.getBean("bookdao");
		dao.addBook(new Book(101,"Let Us C","YK","BPB",780));
		dao.addBook(new Book(102,"Thinking Java","GH","BPB",456));
		dao.addBook(new Book(103,"Inside Python","KL","BPB",890));
		dao.addBook(new Book(111,"Web Design","ER","BPB",777));
		dao.addBook(new Book(112,"Spring","BN","BPB",1000));
		System.out.println("Add Book Data Successfully in The Book_Data Table in DataBase");
		//dao.addBook(new Book(110,"Harry Potter","YK","WAS",542));
		/*dao.deleteBook(104); System.out.println(dao.deleteBook(104));
		dao.deleteBook(105);   System.out.println(dao.deleteBook(105));
		dao.deleteBook(106);   System.out.println(dao.deleteBook(106));*/	
		System.out.println(dao.getBookinfo(110));
		System.out.println(dao.getAllBooks());
	}

}
