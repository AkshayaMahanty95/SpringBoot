package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.BookDao;
import com.ojas.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookdao;
	
	public Book newBook(Book book) {
		return bookdao.save(book);
	}

	public List<Book> getBook() {
		return bookdao.findAll();
	}

	public String deleteBook(Integer bookId) { 
		 bookdao.deleteById(bookId);
		return bookId+" "+"deleted";
	}

	public Book findById(Integer bookId) {
		return bookdao.findById(bookId).orElse(new Book());
	}

	public void save(Book book) {
		 bookdao.save(book);
		
	}	
}
