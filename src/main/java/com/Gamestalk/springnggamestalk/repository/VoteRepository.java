package com.Gamestalk.springnggamestalk.repository;

import com.Gamestalk.springnggamestalk.model.Post;
import com.Gamestalk.springnggamestalk.model.User;
import com.Gamestalk.springnggamestalk.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
