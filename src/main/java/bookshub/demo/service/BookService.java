package bookshub.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import bookshub.demo.dto.BookDto;
import bookshub.demo.dto.BookShopDto;

@Service
public class BookService{
	public  final List<BookDto> books = new ArrayList<BookDto>();
	
	public BookService(){
		this.books.add(new BookDto(1,"Batman"));
		BookDto book= new BookDto(2,"Amazing Spider Man");
		SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
		Date date1=null;
		try {
			 date1 = dateformat3.parse("17/07/2002");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setPublishdate(date1);
		BookShopDto bookshop = new BookShopDto(1, "Vijitha Yapa Book Shop");
		BookShopDto bookshop1 = new BookShopDto(1, "Godage Book Shop");
		List<BookShopDto> bookshops = new ArrayList<BookShopDto>();
		bookshops.add(bookshop);
		bookshops.add(bookshop1);
		book.setBookshops(bookshops);
		this.books.add(book);
		this.books.add(new BookDto(3,"Action Comics"));
		this.books.add(new BookDto(3,"The Incredible Hulk"));
		this.books.add(new BookDto(3,"Wolverine"));
		this.books.add(new BookDto(3,"Teen Titans"));
		
		
	}
	
	public List<BookDto> getBooks(){
		
	
		return books;
		
	}
	
	public BookDto getBookByName(String name) {
		try {
			return  books.stream().filter(bk->bk.getName().startsWith(name)).findFirst().get();
		}catch(NoSuchElementException e) {
			return null;
		}
		
	}

	public BookDto create(BookDto bookDto) {
		books.add(bookDto);
		 return bookDto;
	}

	public BookDto update(BookDto bookDto) {
		BookDto existingBook=books.stream().filter(bk->bk.getIsbn()==bookDto.getIsbn()).findFirst().get();
	
		int indexToReplace = books.indexOf(existingBook);
		books.set(indexToReplace,bookDto);
		return bookDto;
	}

	public boolean delete(Integer isbn) {
		
		return books.removeIf(bk->bk.getIsbn()==isbn);
	}

}
