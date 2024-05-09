package com.homepage.likelion.test;

import com.homepage.likelion.util.response.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customResponse")
public class CustomTestController {

    @PostMapping("/simple")
    public ResponseEntity<CustomApiResponse<?>> simple(){

        // 1. 응답 Body를 구성
        CustomApiResponse<Object> responseBody = CustomApiResponse.createSucsess(HttpStatus.OK.value(), null, "회원가입에 성공했습니다.");
        // 2. 응답 Body를 ResponseEntity에 넣기
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

     @GetMapping("/jsonData")
    public ResponseEntity<CustomApiResponse<?>> jsonData(){
         // userId : example
         // email : example@naver.com

         // dto 클래스 만들기 방법 1. new  사용
         SimpleDto dto = new SimpleDto("example", "example@naver.com");

         // dto 클래스 만들기 방법 2. builder  사용 -> 생성자는 순서가 있지만 builder는 순서가 x. 더 유연함
         SimpleDto dto2 = SimpleDto.builder()
                 .userId("example")
                 .email("example@naver.com")
                 .build();

         CustomApiResponse<Object> responseBody = CustomApiResponse.createSucsess(HttpStatus.OK.value(), dto, "회원 조회에 성공했습니다.");
         return ResponseEntity.status(HttpStatus.OK).body(responseBody);
     }
}
