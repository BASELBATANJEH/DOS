package com.project.project.services;

import com.project.project.entity.Topic;
import com.project.project.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepo topicRepo;
    @Autowired
    public TopicService(TopicRepo topicRepo) {
        this.topicRepo = topicRepo;
    }

    public List<Topic> getTopics() {
        return topicRepo.findAll();

    }



    public Optional<Topic> getTopics(String name) {

        Optional<Topic> topicOptional = topicRepo.findTopicsByName(name);
        if(topicOptional.isPresent()){
            return topicOptional;
        }
        else{
            throw new IllegalStateException("No such topic exist");
        }
    }
}
