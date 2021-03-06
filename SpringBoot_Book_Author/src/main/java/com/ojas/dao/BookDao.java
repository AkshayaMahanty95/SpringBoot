package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}
