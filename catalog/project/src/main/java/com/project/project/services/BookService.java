package com.project.project.services;

import com.project.project.entity.Book;
import com.project.project.repo.BookRep;
import com.project.project.exception.ApiRequestException;
import com.project.project.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRep bookRep;

    @Autowired
    public BookService(BookRep bookRep) {
        this.bookRep = bookRep;
    }

    public Book getBook(Long id) {
        boolean exists=bookRep.existsById(id);
        if(!exists){

            throw new ApiRequestException("student with id "+id+" doesn't exist");
        }
        Optional <Book> book=bookRep.findById(id);
        return book.get();
    }
    @Transactional
    public void updateBookByCost(Long id, Integer price,Integer quantity) {
        boolean exists = bookRep.existsById(id);
        if (!exists) {

            throw new ApiRequestException("student with id" + id + "doesn't exist");
        }
        Book book = bookRep.getById(id);
        if (price != null) {
            if (price < 0) {
                throw new IllegalStateException("price can't be negative number");
            }
            else if (price == 0) {
                throw new IllegalStateException("price can't be zero");
            }
            else  {
                book.setPrice(price);
            }

        }



        if (quantity != null) {
            if (quantity < 0) {
                throw new IllegalStateException("There are no books currently available");
            }
            else  {
                book.setQuantity(quantity);
            }

        }
    }
    @Transactional
    public void buyABook(Long id) {
        boolean exists = bookRep.existsById(id);
        if (!exists) {
            throw new ApiRequestException("student with id" + id + "doesn't exist");
        }
        Book book = bookRep.getById(id);
        if (book.getQuantity() != null || !(book.getQuantity() <= 0))
            book.setQuantity(book.getQuantity() - 1);

        bookRep.save(book);
    }

}


