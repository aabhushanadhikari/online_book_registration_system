package com.aabhushan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aabhushan.model.MyBookList;
import com.aabhushan.repo.MyBooksRepo;

@Service
public class MyBooksService {
	@Autowired
	MyBooksRepo repo2;
	public void savetoMyBooks(MyBookList books) {
		repo2.save(books);
	}
	public List<MyBookList> getAllMybooks(){
		return repo2.findAll();
	}
	
	public void deleteById(int id) {
		repo2.deleteById(id);
	}
}
