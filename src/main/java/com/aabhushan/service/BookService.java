package com.aabhushan.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aabhushan.model.Book;
import com.aabhushan.repo.BookRepo;
@Service
public class BookService {
	@Autowired
	BookRepo repo;
	public void saveBook(Book book) {
		repo.save(book);
	}
	public List<Book> getAllBooks(){
		return repo.findAll();
	};
	public Book getBookByid(int id) {
		return repo.findById(id).get();
	}
	public void deleteAvailableBookbyId(int id) {
		repo.deleteById(id);
	}
}
