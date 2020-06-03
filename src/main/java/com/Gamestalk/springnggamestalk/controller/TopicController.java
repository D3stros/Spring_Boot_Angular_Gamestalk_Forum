package com.Gamestalk.springnggamestalk.controller;

import com.Gamestalk.springnggamestalk.dto.TopicDto;
import com.Gamestalk.springnggamestalk.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/topic")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public List<TopicDto> getAllTopics() {
        return topicService.getAll();
    }

    @GetMapping("/{id}")
    public TopicDto getTopic(@PathVariable Long id) {
        return topicService.getTopic(id);
    }

    @PostMapping
    public TopicDto create(@RequestBody @Valid TopicDto topicDto) {
        return topicService.save(topicDto);
    }
}
