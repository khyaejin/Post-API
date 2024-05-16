package com.homepage.likelion.post.dto;

import com.homepage.likelion.domain.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;


public class PostCreateDto {

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor
    @Builder
    public static class Req {
        @NotBlank(message = "작성자 이름은 비어있을 수 없습니다")
        private String postedUserName;

        @NotBlank(message = "비밀번호는 비어있을 수 없습니다")
        private String password;

        @NotBlank(message = "게시글 제목은 비어있을 수 없습니다")
        private String title;

        @NotBlank(message = "게시글 내용은 비어있을 수 없습니다")
        private String content;

        public Post toEntity() {
            return Post.builder()
                    .postedUserName(postedUserName)
                    .password(password)
                    .title(title)
                    .content(content)
                    .build();
        }
    }

    //게시글 작성 :postId, updateAt
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreatePost {
        private Long postId;
        private LocalDateTime updateAt;

        public CreatePost(Long postId, LocalDateTime updateAt) {
            this.postId = postId;
            this.updateAt = updateAt;
        }
    }


}
