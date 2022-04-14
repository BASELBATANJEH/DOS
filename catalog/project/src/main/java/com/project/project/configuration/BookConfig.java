package com.project.project.configuration;

import com.project.project.entity.Book;
import com.project.project.entity.Topic;
import com.project.project.repo.BookRep;
import com.project.project.repo.TopicRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class BookConfig  {

    @Bean
CommandLineRunner commandLineRunner(BookRep bookRep, TopicRepo topicRepo){
    return args -> {
    Book book1=new Book(
    "How to get a good grade in DOS in 40 minutes a day",
            33,
            1000


    );
        Book book2=new Book(
                "RPCs for Noobs",
                33,
                500


        );
        Book book3=new Book(
                "Xen and the Art of Surviving Undergraduate School",
                10,
                200

        );
        Book book4=new Book(
                "Cooking for the Impatient Undergrad",
                5,
                100

        );
//        bookRep.saveAll(List.of(book1,book2,book3,book4));

        Topic topic1=new Topic("distributed systems");
        Topic topic2=new Topic("undergraduate school");
        topic1.addBook(book1);
        topic1.addBook(book2);
        topic2.addBook(book3);
        topic2.addBook(book4);

        topicRepo.saveAll(List.of(topic1,topic2));




    };
}
}
