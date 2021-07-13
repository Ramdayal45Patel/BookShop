package com.ramdayal.model;

public class BookAdd {
	private int id;
	private String book;
	private int price;
	private String author;
	private String category;
	private String images;
	private String date;

	public BookAdd() {
		super();
	}

	public BookAdd(int id, String book, String author, String category, String date, int price, String images) {
		super();
		this.id = id;
		this.book = book;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
