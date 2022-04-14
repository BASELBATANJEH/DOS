package com.project.project.controller;

import com.project.project.entity.Book;
import com.project.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class
    BookController {
private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/info/{id}")
    public Book infoBooks(@PathVariable("id") Long id){
        return bookService.getBook(id);
    }


    @PutMapping ("/update/{id}")
    public void updateBookByCost(@PathVariable("id") Long id, @RequestParam(required = false) Integer price,@RequestParam(required = false)Integer quantity){
    bookService.updateBookByCost(id,price,quantity);
    }

    @GetMapping  ("/buy/{id}")
    public void buyABook(@PathVariable("id") Long id){
        bookService.buyABook(id);
    }




}
