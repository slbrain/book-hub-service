package bookshub.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookshub.demo.dto.BookDto;
import bookshub.demo.exception.DataValidationException;
import bookshub.demo.service.BookService;
import bookshub.demo.validator.CreateGroup;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
	
	
	 @Autowired
	 BookService bookservice;
	 
	 
	
	 @GetMapping()
	 @ApiOperation("get a books by name")
	 public ResponseEntity getBookById(@ApiParam(name = "bookname", required = true) @RequestParam String bookname){
		 BookDto book=bookservice.getBookByName(bookname);
		if(book!=null) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Book is not Found", HttpStatus.NOT_FOUND);
		}
		 
	 }
	 
	 @PostMapping()
	 @ApiOperation("add a book")
	 public ResponseEntity create(@RequestBody   @Validated(CreateGroup.class)  BookDto bookDto,BindingResult result){
		 
		 if (result.hasErrors()) {
			 return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
	      }
		 return new ResponseEntity<>(bookservice.create(bookDto),HttpStatus.OK);
		 
	 }
	 
	 @PutMapping()
	 @ApiOperation("update a book")
	 public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto){
		 return new ResponseEntity<>(bookservice.update(bookDto),HttpStatus.OK);
		 
	 }
	 
	 @DeleteMapping
	 @ApiOperation("delete a book")
	 public ResponseEntity<Boolean> update(@RequestParam Integer isbn){
		 return new ResponseEntity<>(bookservice.delete(isbn),HttpStatus.OK);
		 
	 }


}
