package com.practice.reverselevel.spring.web;


import com.practice.reverselevel.spring.service.posts.PostService;
import com.practice.reverselevel.spring.web.dto.PostsResponseDto;
import com.practice.reverselevel.spring.web.dto.PostsSaveRequestDto;
import com.practice.reverselevel.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return  postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto update(@PathVariable Long id){
        return postsService.findById(id);
    }
}