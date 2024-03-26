package com.aabhushan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aabhushan.model.Book;
import com.aabhushan.model.MyBookList;
import com.aabhushan.service.BookService;
import com.aabhushan.service.MyBooksService;

@Controller
public class MyBooksController {
	@Autowired
	MyBooksService service;
	@Autowired
	BookService service2;
	
	@RequestMapping("/myBooks/{id}")
	public String getMyBooksList(@PathVariable("id") int id) {
		Book b=service2.getBookByid(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getPrice(),b.getAuthor());
		service.savetoMyBooks(mb);
		return "redirect:/myBooks";
	}
	@GetMapping("/myBooks")
	public String getMyBooksPage(Model model) {
		List<MyBookList> myBookList=service.getAllMybooks();
		model.addAttribute("mybooks",myBookList);
		return "myBook";
	}
	@RequestMapping("/deletefrommyBook/{id}")
	public String deleteFrommyBooksList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/myBooks";
	}

}
