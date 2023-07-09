package com.practice.reverselevel.spring.service.posts;

import com.practice.reverselevel.spring.domain.posts.Posts;
import com.practice.reverselevel.spring.domain.posts.PostsRepository;
import com.practice.reverselevel.spring.web.dto.PostsResponseDto;
import com.practice.reverselevel.spring.web.dto.PostsSaveRequestDto;
import com.practice.reverselevel.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없음. ID=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없음. ID=" + id));
        return new PostsResponseDto(entity);
    }
}
