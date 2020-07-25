package com.Gamestalk.springnggamestalk.repository;

import com.Gamestalk.springnggamestalk.model.Post;
import com.Gamestalk.springnggamestalk.model.User;
import com.Gamestalk.springnggamestalk.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
