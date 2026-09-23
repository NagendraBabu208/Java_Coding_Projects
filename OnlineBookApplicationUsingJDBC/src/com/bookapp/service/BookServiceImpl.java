package com.bookapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.dao.BookDAO;
import com.bookapp.execption.BookNotFoundExecption;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	
    private PreparedStatement preparedStatement;
	
	@Override
	public void addBook(Book book) {
		String addQuery="Insert into Book values(?,?,?,?,?)";
		Connection connection=BookDAO.getConnection();
		try {
			preparedStatement=connection.prepareStatement(addQuery);
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getPublisher());
			preparedStatement.setDouble(5, book.getPrice());
			
			preparedStatement.execute();
			System.out.println("Book record stored into DB successfully!!!.");
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				BookDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
				
			}
		}
		
		
	}

	@Override
	public boolean deleteBookById(int bookId) {
		String deleteQuery="delete from Book where bookId=?";
		Connection connection=BookDAO.getConnection();
		boolean value=false;
		try {
			preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, bookId);
			 int deleteId =preparedStatement.executeUpdate();
			if(deleteId>0) {
				value=true;
			}else {
				throw new BookNotFoundExecption("Book is not found with that bookId:: "+bookId);

			}
			System.out.println("Book is deleted successfully!!!.");
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
				
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				BookDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		return value;
	}

	@Override
	public boolean updateBook(int bookId, double bookPrice) {
		String updateQuery="Update book set Price=? where bookId=?";
		Connection connection=BookDAO.getConnection();
		boolean flag=false;
		try {
			preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1, bookPrice);
			preparedStatement.setInt(2, bookId);
			int rowIsUpdated=preparedStatement.executeUpdate();
			if(rowIsUpdated>0) {
			     flag=true;
			}else {
				throw new BookNotFoundExecption("Book is not found with bookId:: "+bookId);

			}
			System.out.println("Book is updated successfully!!!.");
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				BookDAO.closeConnection();
			} catch (Exception e) {
				
		}
			}
		
		return flag;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> listOfBooks= new ArrayList<Book>();
		ResultSet resultSet=null;
		Book book=null;
		Connection connection=BookDAO.getConnection();
		try {
			preparedStatement=connection.prepareStatement("Select * from Book");
			 resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int bookId=resultSet.getInt(1);
				String title=resultSet.getString(2);
				String author=resultSet.getString(3);
				String publisher=resultSet.getString(4);
				double price=resultSet.getDouble(5);
				
				book=new Book();
				book.setBookId(bookId);
				book.setTitle(title);
				book.setAuthor(author);
				book.setPublisher(publisher);
				book.setPrice(price);
				
				listOfBooks.add(book);
				
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			BookDAO.closeConnection();
			
		}catch (SQLException sqlException2) {
			System.out.println(sqlException2.getMessage());
		}
			}
		
		if(listOfBooks.isEmpty()) {
			throw new BookNotFoundExecption("Books not Found!!!");
		}
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		String sqlQuery="select * from Book where author=?";
		List<Book> listOfBooks=new ArrayList<Book>();
		Book book=null;
		ResultSet resultSet=null;
		
		Connection connection=BookDAO.getConnection();
		try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, author);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				int bookId=resultSet.getInt(1);
				String title=resultSet.getString(2);
				String bookAuthor=resultSet.getString(3);
				String publisher=resultSet.getString(4);
				double price=resultSet.getDouble(5);
				
				book=new Book();
				book.setBookId(bookId);
				book.setTitle(title);
				book.setAuthor(bookAuthor);
				book.setPublisher(publisher);
				book.setPrice(price);
				
				listOfBooks.add(book);
				
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
			BookDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		if(listOfBooks.isEmpty()) {
			throw new BookNotFoundExecption("Books are not available with that author");
		}
		
		return listOfBooks;
	}

	@Override
	public List<Book> getBooksByPublisher(String publisher) {

		String sqlQuery="select * from Book where publisher=?";
		List<Book> listOfBooks=new ArrayList<Book>();
		Book book=null;
		ResultSet resultSet=null;
		
		Connection connection=BookDAO.getConnection();
		try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, publisher);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				int bookId=resultSet.getInt(1);
				String title=resultSet.getString(2);
				String bookAuthor=resultSet.getString(3);
				String npublisher=resultSet.getString(4);
				double price=resultSet.getDouble(5);
				
				book=new Book();
				book.setBookId(bookId);
				book.setTitle(title);
				book.setAuthor(bookAuthor);
				book.setPublisher(npublisher);
				book.setPrice(price);
				
				listOfBooks.add(book);
				
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
			BookDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		if(listOfBooks.isEmpty()) {
			throw new BookNotFoundExecption("Books are not Published!!!.");
		}
		
		
		return listOfBooks;
	}

	@Override
	public Book getBookById(int bookId) {
		Book book=null;
		ResultSet resultSet=null;
		String sqlQuery="select * from book where bookId=?";
		Connection connection=BookDAO.getConnection();
		try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, bookId);
			 resultSet=preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 int id=resultSet.getInt(1);
					String title=resultSet.getString(2);
					String bookAuthor=resultSet.getString(3);
					String npublisher=resultSet.getString(4);
					double price=resultSet.getDouble(5);
					
					book=new Book();
					book.setBookId(id);
					book.setTitle(title);
					book.setAuthor(bookAuthor);
					book.setPublisher(npublisher);
					book.setPrice(price);
			 }
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				BookDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2);
			}
		}
		
		if(book==null) {
			throw new BookNotFoundExecption("Book is not Found with bookId::- "+bookId);
		}
		
		return book;
	}

}
