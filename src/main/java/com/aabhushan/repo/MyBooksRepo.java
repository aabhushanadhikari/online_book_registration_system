package com.aabhushan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aabhushan.model.MyBookList;



@Repository
public interface MyBooksRepo  extends JpaRepository<MyBookList, Integer>{
	
}
