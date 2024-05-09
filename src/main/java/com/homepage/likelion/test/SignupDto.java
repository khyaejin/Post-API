package com.homepage.likelion.test;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    //클라이언트로부터 받을 데이터를 정의하는 dto

    //Validation 사용 @NotEmpty
    @NotEmpty(message = "userId는 필수값입니다.") //userId에 비어있는 값이 들어올 수 없음
    private String userId;

    //Validation 사용 @Email
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;
    private String password;

}
