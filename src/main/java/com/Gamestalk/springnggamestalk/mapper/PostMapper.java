package com.Gamestalk.springnggamestalk.mapper;

import com.Gamestalk.springnggamestalk.dto.PostRequest;
import com.Gamestalk.springnggamestalk.dto.PostResponse;
import com.Gamestalk.springnggamestalk.model.Post;
import com.Gamestalk.springnggamestalk.model.Topic;
import com.Gamestalk.springnggamestalk.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "topic", source="topic")
    @Mapping(target = "user", source="user")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "voteCount", constant = "0")
    Post map(PostRequest postRequest, Topic topic, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "topicName", source = "topic.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);

}

