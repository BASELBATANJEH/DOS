package com.project.project.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.project.View.View;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Topic")
@Table(name="topic" ,schema = "public")
public class Topic {
    @JsonView(View.View2.class)
    @Id
/*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "topic_id_Sequence")
    @SequenceGenerator(name = "topic_id_Sequence", sequenceName = "Topic_ID_SEQ",initialValue = 1 ,allocationSize = 1)
    @Column(
            updatable = false
    )
    private Long id;
    @Column(

            nullable = false
    )
    @JsonView(View.View2.class)
    private String name;
    @OneToMany(
            mappedBy = "topic",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            orphanRemoval = true
    )
    @JsonView(View.View1.class)
    List<Book> books=new ArrayList<>();

    public Topic( String name) {
        this.name = name;
    }

    public Topic() {
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

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
            book.setTopic(this);

        }
    }
    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
            book.setTopic(null);
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
