package com.homepage.likelion.post.dto;

import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class PostListDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Req {
        private Long postId; //게시글 ID
        private String postedUserName; //작성자 이름
        private String password; //비밀번호
        private String title; //게시글 제목
        private String content; //게시글 내용

    }

    @Getter @Builder
    @NoArgsConstructor(access  = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class PostResponse {
        private Long postId; //게시글 ID
        private String postedUserName; //작성자 이름
        private String title; //게시글 제목
        private String content; //게시글 내용
        private LocalDateTime updatedAt; //최종 수정 날짜
    }

    //게시글 조회 :List<Post> posts
    @Getter @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SearchPostsRes{
        private List<PostListDto.PostResponse> posts;

        public SearchPostsRes(List<PostListDto.PostResponse> posts){
            this.posts = posts;
        }
    }

}
