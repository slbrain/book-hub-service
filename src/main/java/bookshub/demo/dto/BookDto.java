package bookshub.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import bookshub.demo.validator.CreateGroup;

public class BookDto {
	private Integer isbn;
	
	@NotNull
	@NotEmpty(groups = { CreateGroup.class },message = "books name is required.")
	private String name;
    
	
	private Date publishdate;
	List<BookShopDto> bookshops;
	
	
	public BookDto(int isbn, String name) {
		super();
		this.isbn = isbn;
		this.name = name;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public List<BookShopDto> getBookshops() {
		return bookshops;
	}
	public void setBookshops(List<BookShopDto> bookshops) {
		this.bookshops = bookshops;
	}
	
	
			

}
