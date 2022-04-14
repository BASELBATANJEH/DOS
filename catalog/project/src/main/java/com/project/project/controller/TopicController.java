package com.project.project.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.project.View.View;
import com.project.project.entity.Topic;
import com.project.project.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class TopicController {

    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }
    @JsonView(View.View2.class)

    @GetMapping("search/")
    public List<Topic> searchTopic(){
        return topicService.getTopics();
    }
    @JsonView(View.View1.class)
    @GetMapping("search/{name}")
    public Optional<Topic> searchTopic(@PathVariable String name){
        return topicService.getTopics(name);
    }
}
