package com.Gamestalk.springnggamestalk.service;

import com.Gamestalk.springnggamestalk.dto.TopicDto;
import com.Gamestalk.springnggamestalk.exception.TopicNotFoundException;
import com.Gamestalk.springnggamestalk.model.Topic;
import com.Gamestalk.springnggamestalk.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Transactional
    public TopicDto save(TopicDto topicDto) {
        Topic topic = topicRepository.save(mapToTopic(topicDto));
        topicDto.setId(topic.getId());
        return topicDto;
    }

    @Transactional(readOnly = true)
    public TopicDto getTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found with id -" + id));
        return mapToDto(topic);
    }

    private TopicDto mapToDto(Topic topic) {
        return TopicDto.builder().name(topic.getName())
                .id(topic.getId())
                .postCount(topic.getPosts().size())
                .build();
    }

    private Topic mapToTopic(TopicDto topicDto) {
        return Topic.builder().name("/r/" + topicDto.getName())
                .description(topicDto.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}
