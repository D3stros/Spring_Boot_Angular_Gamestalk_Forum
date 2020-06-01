package com.Gamestalk.springnggamestalk.repository;

import com.Gamestalk.springnggamestalk.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByName(String topicName);
}