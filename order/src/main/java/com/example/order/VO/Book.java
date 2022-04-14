package com.example.order.VO;

import jdk.jfr.DataAmount;

import javax.persistence.Column;

public class Book {
    private Long id;

    private String name;

    private Integer quantity;

    private Integer cost;

    private String topic;

    public Book(Long id, String name, Integer quantity, Integer cost, String topic) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.topic = topic;
    }

    public Book(String name, Integer quantity, Integer cost, String topic) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.topic = topic;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", topic='" + topic + '\'' +
                '}';
    }
}
