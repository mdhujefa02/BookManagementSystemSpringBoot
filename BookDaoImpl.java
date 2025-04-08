package com.book.start.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.book.start.model.Book;

/*Annotation used on the class which directly access database*/
@Repository("bookdao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; //auto generates the jdbc code 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addBook(Book bk) {
		String sql="insert into Book_Data values(?,?,?,?,?)";
		int r= jdbcTemplate.update(sql, new Object[]{bk.getBookId(),bk.getAuthor(),bk.getPublication(),bk.getTitle(),bk.getPrice()});
		return r;	
	}
	
	@Override
 public int deleteBook(int bookId) {
		String sql="delete from Book_Data where bookId=?";
		int i=jdbcTemplate.update(sql,new Object[]{bookId});
		System.out.println(i+ "rows Deleted");
		return i;	
	}

	@Override
	public Book getBookinfo(int bookId) {
		String sql="select * from Book_Data where bookId=?";
		Book b=jdbcTemplate.query(sql, new Object[] {bookId},new ResultSetExtractor<Book>() {

			@Override
			public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
				 Book bk = new Book();
				if (rs.next()) {  
	               
	                bk.setBookId(rs.getInt(1));
	                bk.setAuthor(rs.getString(2));
	                bk.setPublication(rs.getString(3));
	                bk.setTitle(rs.getString(4));
	                bk.setPrice(rs.getDouble(5));
				}
				return bk;
			}
			
		});
		return b;		 
	}
	
	@Override
	public List<Book> getAllBooks() {
		String sql="select * from Book_Data";
		List<Book> Booklist=jdbcTemplate.query(sql, new RowMapper<Book>(){

			@Override
			public Book mapRow(ResultSet rs, int rownum) throws SQLException {
				 Book bk = new Book();
	                bk.setBookId(rs.getInt("bookid"));
	                bk.setAuthor(rs.getString("author"));
	                bk.setPublication(rs.getString("publication"));
	                bk.setTitle(rs.getString("title"));
	                bk.setPrice(rs.getDouble("price"));
	                return bk;
			}
		});
		return Booklist;
	}
}














