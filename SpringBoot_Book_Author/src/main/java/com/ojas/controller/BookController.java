package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.entity.Book;
import com.ojas.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping("/newbook")
	public String show(ModelMap model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "reg_form";
	}
	@PostMapping("/newbook")
	public String submitForm(@ModelAttribute Book book, ModelMap model) {
		bookservice.newBook(book);
		model.addAttribute("book", book);
		return "reg_sucess";
	}
	@GetMapping("/getbook")
	public String getBook(ModelMap model) {
		List<Book> book = bookservice.getBook();
		model.addAttribute("book", book);
		return "get_stud";
	}
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId")Integer bookId){
		bookservice.deleteBook(bookId);
		return "redirect:/getbook";
	}
	
	@GetMapping("/edit/{bookId}")
	public String showUpdateForm(@PathVariable Integer bookId, Model model) {
	    Book book = bookservice.findById(bookId);
	    model.addAttribute("book", book);
	    return "update-user";
	}
	@PostMapping("/update/{bookId}")
	public String updateUser(@PathVariable Integer bookId, Book book, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        book.setBookId(bookId);
	        return "update-user";
	    }
	    bookservice.save(book);
	    return "redirect:/getbook";
	}
}
