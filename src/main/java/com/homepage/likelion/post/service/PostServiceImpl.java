package com.homepage.likelion.post.service;

import com.homepage.likelion.domain.Post;
import com.homepage.likelion.post.dto.PostCreateDto;
import com.homepage.likelion.post.dto.PostListDto;
import com.homepage.likelion.post.dto.PostUpdateDto;
import com.homepage.likelion.post.repository.PostRepository;
import com.homepage.likelion.util.response.CustomApiResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    //게시글 작성
    @Override
    public ResponseEntity<CustomApiResponse<?>> createPost(PostCreateDto.Req req) {
        //방법 1 : toEntity() 메서드를 호출하여 엔티티 객체를 생성
        Post post = req.toEntity();

        /* 방법 2 : builder
        Post post = Post.builder()
                    .title(req.getTitle())
                    .content(req.getContent())
                    .password(req.getPassword())
                    .postedUserName(req.getPostedUserName())
                    .build();
        */
        Post savedPost = postRepository.save(post);

        //생성된 게시글의 정보를 포함한 응답 반환
        PostCreateDto.CreatePost createPostResponse = new PostCreateDto.CreatePost(savedPost.getId(), savedPost.getUpdateAt());
        CustomApiResponse<PostCreateDto.CreatePost> res = CustomApiResponse.createSucsess(HttpStatus.OK.value(), createPostResponse, "게시글이 작성되었습니다.");
        return ResponseEntity.ok(res);
    }

    //게시글 수정
    @Override
    public ResponseEntity<CustomApiResponse<?>> modifyPost(Long postId, PostUpdateDto.Req req) {

        Optional<Post> optionalPost = postRepository.findById(postId);

        //게시글 검색
        Post post = optionalPost.get();
        post.changeTitle(req.getTitle());
        post.changeContent(req.getContent());
        post.changeUserName(req.getPostedUserName());
        postRepository.flush(); //변경 사항을 데이터베이스에 즉시 적용

        //수정된 게시글 정보 응답
        PostUpdateDto.UpdatePost data = new PostUpdateDto.UpdatePost(post.getUpdateAt());
        CustomApiResponse<PostUpdateDto.UpdatePost> res = CustomApiResponse.createSucsess(HttpStatus.OK.value(), data, "게시글이 수정되었습니다.");
        return ResponseEntity.ok(res);
    }

    //게시글 전체 조회
    @Override
    public ResponseEntity<CustomApiResponse<?>> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostListDto.PostResponse> postResponses = new ArrayList<>();

        for (Post post : posts) {
            postResponses.add(PostListDto.PostResponse.builder()
                    .postId(post.getId())
                    .postedUserName(post.getPostedUserName())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .updatedAt(post.getUpdateAt())
                    .build());
        }
        PostListDto.SearchPostsRes searchPostsRes = new PostListDto.SearchPostsRes((postResponses));
        CustomApiResponse<PostListDto.SearchPostsRes> res = CustomApiResponse.createSucsess(HttpStatus.OK.value(), searchPostsRes, "전체 게시글 조회 성공");
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //게시글 한개 조회
    @Override
    public  ResponseEntity<CustomApiResponse<?>> getOnePost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);

        //해당하는 게시글이 없으면
        if(optionalPost.isEmpty()){
            CustomApiResponse<Void> res = CustomApiResponse.createFailWithout(HttpStatus.NOT_FOUND.value(), "해당하는 게시글을 찾을 수 없습니다");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

        //정상적으로 조회 된 경우
        Post post = optionalPost.get();
        PostListDto.PostResponse postResponse = new PostListDto.PostResponse(
                post.getId(),
                post.getPostedUserName(),
                post.getTitle(),
                post.getContent(),
                post.getUpdateAt());
        CustomApiResponse<PostListDto.PostResponse> res = CustomApiResponse.createSucsess(HttpStatus.OK.value(), postResponse, "게시글 조회 성공");
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }

}
