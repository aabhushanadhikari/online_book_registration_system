package com.aabhushan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aabhushan.model.Book;
import com.aabhushan.service.BookService;

@Controller
public class RegisterBook{
	@Autowired
	BookService service;
	@GetMapping("/register_book")
	public String getRegisterBook() {
		return "registerBook";
	}
	@PostMapping("/save")
	public String postRegisterBook(@ModelAttribute Book book) {
		service.saveBook(book);
		return "redirect:/available_book";
	}
}
