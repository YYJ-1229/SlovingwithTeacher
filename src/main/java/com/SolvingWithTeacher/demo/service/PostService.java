package com.SolvingWithTeacher.demo.service;


import com.SolvingWithTeacher.demo.domain.PostRepository;
import com.SolvingWithTeacher.demo.domain.Posts;
import com.SolvingWithTeacher.demo.web.dto.PostListResponseDto;
import com.SolvingWithTeacher.demo.web.dto.PostResponseDto;
import com.SolvingWithTeacher.demo.web.dto.PostSaveRequestDto;
import com.SolvingWithTeacher.demo.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto){
        return postRepository.save(postSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto){
        Posts posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 없습니다. id = "+ id));

        posts.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id){
        Posts posts = postRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("해당 게시글이 없습니다. id = "+ id));
        postRepository.delete(posts);
    }
    public PostResponseDto findById(Long id){
        Posts entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }
}
