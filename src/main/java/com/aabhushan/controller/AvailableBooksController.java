package com.aabhushan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aabhushan.model.Book;
import com.aabhushan.service.BookService;

@Controller
public class AvailableBooksController {
    @Autowired
    BookService service;
    @GetMapping("/available_book")
    public ModelAndView getAvailableBooksPage() {
        List<Book> list = service.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("availableBooks");
        modelAndView.addObject("book", list);
        return modelAndView;
    }
    @RequestMapping("/deleteAvailableBook/{id}")
    public String deleteFromAvailableBooks(@PathVariable("id") int id) {
    	service.deleteAvailableBookbyId(id);
    	return "redirect:/available_book";
    }
   
    @RequestMapping("/editAvailableBook/{id}")
    public String editFromAvailableBooks(@PathVariable("id") int id,Model model ) {
    	Book b=service.getBookByid(id);
    	model.addAttribute("book", b);
    	
    	return "editAvailableBook";
    }
}
