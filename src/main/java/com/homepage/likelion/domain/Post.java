package com.homepage.likelion.domain;
import com.homepage.likelion.util.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTS")
@Builder
public class Post extends BaseEntity {
    @Id
    @GeneratedValue //기본키로 설정?
    @Column(name = "POSTS_ID")
    private Long id; //글 고유 아이디

    @Column(name = "POSTS_TITLE")
    private String title; //글 제목

    @Column(name = "POSTS_CONTENT"
    )
    private String content; //글 내용
    @Column(name = "POSTED_USER_NAME"
    )
    private String postedUserName; // 작성자 이름
    @Column(name = "POSTS_PASSWORD"
    )
    private String password; // 비밀번호 }

    public void changeTitle(String title){ //글 제목 바꾸기
        this.title = title;
    }
    public void changeContent(String content){ //글 내용 바꾸기
        this.content = content;
    }
    public void changeUserName(String postedUserName){ //작성자 이름 바꾸기
        this.postedUserName = postedUserName;
    }


}