package com.homepage.likelion.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//롬복을 통해 생성자, gettersetter 간편하게 생성
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomApiResponse<T> {

    //status, data, message
    private int status;
    private T data;
    private String message;

    //성공
    public static <T> CustomApiResponse<T> createSucsess(int status, T data, String message) {
        return new CustomApiResponse<>(status, data, message);
    }
    //실패
    public static <T> CustomApiResponse<T> createFailWithout(int status, String message) {
        return new CustomApiResponse<>(status, null, message);
    }

}
