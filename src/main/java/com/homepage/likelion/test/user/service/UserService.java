package com.homepage.likelion.test.user.service;

import com.homepage.likelion.test.domain.User;
import com.homepage.likelion.test.tmp.dto.SignupDto;
import com.homepage.likelion.test.user.dto.UserSignupDto;
import com.homepage.likelion.test.user.repository.UserRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor //private final로 선언된 객체는 자동주입 됨
public class UserService {

    private final UserRepository userRepository;

    //회원가입 로직 작성
    public ResponseEntity<CustomApiResponse<?>> signup(UserSignupDto dto) {
        //회원이 존재하는지 -> userId 고유해야 함
        Optional<User> findUser = userRepository.findByUserId(dto.getUserId());

        // 동일한 userId를 갖고 있다 ->  회원가입 불가 -> CustomResponse의  createFail 데이터 반환
        if (findUser.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(CustomApiResponse.createFailWithout(HttpStatus.BAD_REQUEST.value(), "중복된 아이디 입니다."));

        }

        // 동일한 userId가 없다 -> 회원가입 진행
        User newUser = User.builder()
                .userId(dto.getUserId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        //새로운 User 저장
        userRepository.save(newUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(CustomApiResponse.createSucsess(HttpStatus.OK.value(), null, "회원가입에 성공했습니다"));
    }
}
