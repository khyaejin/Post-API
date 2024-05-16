package com.homepage.likelion.post.service;

import com.homepage.likelion.post.dto.PostCreateDto;
import com.homepage.likelion.post.dto.PostListDto;
import com.homepage.likelion.post.dto.PostUpdateDto;
import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req);
    ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req);
    ResponseEntity<CustomApiResponse<?>> getAllPost();
    ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId);

}
