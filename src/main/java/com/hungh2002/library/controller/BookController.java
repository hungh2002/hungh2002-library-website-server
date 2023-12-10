package com.hungh2002.library.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hungh2002.library.model.entity.Book;
import com.hungh2002.library.model.repository.BookRepository;
import com.hungh2002.library.service.StorageService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/book")
@CrossOrigin
public class BookController {

    @Autowired
	private BookRepository bookRepository;
	@Autowired
	private StorageService storageService;

	@GetMapping("")
	public @ResponseBody Iterable<Book> getAllBook() {

		return bookRepository.findAll();
	}

	@PostMapping("")
	public Book CreateNewBook(@RequestBody MultipartFile thumbnail, String title, String content) {

		return bookRepository.save(new Book(
		  title,
		  content,
		  storageService.storeFile(thumbnail, System.currentTimeMillis(), Book.dirFile)));
	}
	@PutMapping("/{bookId}")
	public void modifyBook (
	  @PathVariable Long bookId,
	  @RequestBody MultipartFile thumbnail,
	  String title,
	  String content
	) 
	{

		Book book = bookRepository.findById(bookId).get();
		book.setTitle(title);
		book.setContent(content);
		storageService.deleteFile(book.getThumbnail());
		book.setThumbnail(storageService.storeFile(thumbnail, System.currentTimeMillis(), Book.dirFile));
		bookRepository.save(book);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {

		Book book = bookRepository.findById(bookId).get();
		storageService.deleteFile(book.getThumbnail());
		bookRepository.deleteById(bookId);
	}
}