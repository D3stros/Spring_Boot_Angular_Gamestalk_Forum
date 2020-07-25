package com.Gamestalk.springnggamestalk.service;

import com.Gamestalk.springnggamestalk.dto.TopicDto;
import com.Gamestalk.springnggamestalk.exception.SpringGamestalkException;
import com.Gamestalk.springnggamestalk.mapper.TopicMapper;
import com.Gamestalk.springnggamestalk.model.Topic;
import com.Gamestalk.springnggamestalk.repository.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Transactional
    public TopicDto save(TopicDto topicDto) {
        Topic save = topicRepository.save(topicMapper.mapDtoToTopic(topicDto));
        topicDto.setId(save.getId());
        return topicDto;
    }


    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapTopicToDto)
                .collect(toList());
    }

    public TopicDto getTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new SpringGamestalkException("No topic found with ID - " + id));
        return topicMapper.mapTopicToDto(topic);
    }
}

