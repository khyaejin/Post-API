package com.homepage.likelion.post.controller;

import com.homepage.likelion.post.dto.PostCreateDto;
import com.homepage.likelion.post.dto.PostListDto;
import com.homepage.likelion.post.dto.PostUpdateDto;
import com.homepage.likelion.post.service.PostService;
import com.homepage.likelion.util.response.CustomApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 생성
    @PostMapping
    public ResponseEntity<CustomApiResponse<?>> createPost(
            @Valid @RequestBody PostCreateDto.Req req) {
            ResponseEntity<CustomApiResponse<?>> result = postService.createPost(req);
            return result;
    }

    //게시글 수정
    @PutMapping("/{postId}")
    public ResponseEntity<CustomApiResponse<?>> modifyPost(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateDto.Req req) {
        ResponseEntity<CustomApiResponse<?>> result = postService.modifyPost(postId, req);
        return result;
    }

    //게시글 전체 조회
    @GetMapping("/all")
    public ResponseEntity<CustomApiResponse<?>> getAllPost(){
        ResponseEntity<CustomApiResponse<?>> result = postService.getAllPost();
        return result;
    }

    //게시글 하나 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<CustomApiResponse<?>> getOnePost(
            //dto가 쓰이지 않음
            @RequestParam("postId") Long postId){
        ResponseEntity<CustomApiResponse<?>> result = postService.getOnePost(postId);
        return  result;
    }
}
