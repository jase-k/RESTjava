package com.jasekraft.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jasekraft.mvc.models.Book;
import com.jasekraft.mvc.services.BookService;

@Controller
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books/{id}")
	public String showBook(@PathVariable("id") long id,
			Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	
	@RequestMapping("/books")
	public String showAllBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "showAllBooks.jsp";
	}
}
