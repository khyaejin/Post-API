package com.homepage.likelion.post.dto;

import com.homepage.likelion.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class PostUpdateDto {
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
    //게시글 수정
    // 수정 api Response
    // 게시글 수정 : updatedAt
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePost {
        private LocalDateTime updatedAt;

        public UpdatePost(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}



