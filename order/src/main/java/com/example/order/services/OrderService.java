package com.example.order.services;

import com.example.order.VO.Book;
import com.example.order.VO.RespnseTempleteVO;
import com.example.order.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;


   public void buyABook(Long id) {

        RespnseTempleteVO respnseTempleteVO = new RespnseTempleteVO();
        Book book = restTemplate.getForObject("http://localhost:9001/books/info/" + id, Book.class);
        if(book.getQuantity()==0){
            throw new ApiRequestException("There is no book available");
        }

        book.setQuantity(book.getQuantity() - 1);
        respnseTempleteVO.setBook(book);


        String url="http://localhost:9001/books/update/"+id+"?quantity="+(book.getQuantity());
            System.out.println(url);
        restTemplate.put(url,null);



    }
}
