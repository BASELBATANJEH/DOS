package com.project.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.project.View.View;

import javax.persistence.*;

@Entity(name="Book")
@Table(name="book" ,schema = "public")
public class Book {
    @Id
/*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/

    @Column(
            name = "id",
            updatable = false
    )
    @GeneratedValue(
             strategy=GenerationType.SEQUENCE, generator = "book_id_Sequence")
    @SequenceGenerator(
            name = "book_id_Sequence", sequenceName = "Book_ID_SEQ",initialValue = 1 ,allocationSize = 1 )
    @JsonView(View.View1.class)
    private Long id;
    @Column(
            name = "book_title",
            nullable = false
    )
    @JsonView({View.View1.class,View.View3.class})
    private String title;
    @Column(
            nullable = false
    )
    //@JsonView(View.View1.class)
    @JsonView(View.View3.class)
    private Integer quantity;
    @Column(
            nullable = false
    )
    //@JsonView(View.View1.class)
    @JsonView(View.View3.class)
    private Integer price;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    @ManyToOne
    @JoinColumn(
            name="topic_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name="topic_book_fk")

    )
    @JsonIgnore
    private Topic topic;

    public Book(String title, Integer quantity, Integer price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }


    public Book() {
    }

 /*   public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price + '\'' +
                '}';
    }
}

