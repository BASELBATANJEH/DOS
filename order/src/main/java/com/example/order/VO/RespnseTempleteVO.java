package com.example.order.VO;

public class RespnseTempleteVO {
    private Book book;

    public RespnseTempleteVO(Book book) {
        this.book = book;
    }

    public RespnseTempleteVO() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
