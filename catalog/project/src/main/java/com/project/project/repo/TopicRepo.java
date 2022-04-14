package com.project.project.repo;

import com.project.project.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepo extends JpaRepository<Topic,Long> {
    @Query("SELECT s FROM Topic s where s.name=?1")
    Optional<Topic> findTopicsByName(String name);
}
