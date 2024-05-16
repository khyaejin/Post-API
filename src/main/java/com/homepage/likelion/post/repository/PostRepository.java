package com.homepage.likelion.post.repository;

import com.homepage.likelion.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> { //Post :엔티티, Long : PK타입
}

