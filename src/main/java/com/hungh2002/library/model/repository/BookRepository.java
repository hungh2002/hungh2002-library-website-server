package com.hungh2002.library.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.hungh2002.library.model.entity.Book;


public interface BookRepository extends CrudRepository<Book, Long> {

}