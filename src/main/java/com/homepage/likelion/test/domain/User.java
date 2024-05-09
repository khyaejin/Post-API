package com.homepage.likelion.test.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
//Entity에는 @Setter 사용 x -> 이유 추후 설명
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "usereId")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
