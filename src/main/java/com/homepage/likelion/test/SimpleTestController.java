package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //SimpleTestController가 RestPoolwebService의 컨트롤러임을 알려주는 어노테이션?
@RequestMapping("/api/simpleText") //원래 @GetMapping("/api/simpleText/success")이런식으로 써야하는데 "/api/simpleText/fail"와 /api/simpleText이부분이 겹치니까 미리 정해둬서 편하게 쓰는 것
public class SimpleTestController {

    // GET http://localhost:8080/api/simpleText/success
    @GetMapping("success")
    public String simpleTextSuccess(){
        return "안녕";
    }

    // GET http://localhost:8080/api/simpleText/fail
    @GetMapping("fail")    ///@RequestMapping("/api/simpleText") 없으면 api/simpleText/fail 이렇게 써야 함
    public ResponseEntity<String> simpleTextFail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
    }
}
