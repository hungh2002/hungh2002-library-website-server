package com.hungh2002.library.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "books")
public class Book {

    @Transient
    public static String dirFile = "images/thumbnails/";

    @Column(name="bookId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;

	@Column(name="title",unique=true, nullable=false)
	private String title;

	@Column(name="content")
	private String content;

	@Column(name="thumbnail",nullable=false)
	private String thumbnail;


    public Book() {};
	
	public Book(String title, String content, String thumbnail) {
		super();
		this.title = title;
		this.content = content;
		this.thumbnail = thumbnail;
	}


    public Long getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}