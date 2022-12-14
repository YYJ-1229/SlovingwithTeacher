package com.SolvingWithTeacher.demo.web;


import com.SolvingWithTeacher.demo.service.PostService;
import com.SolvingWithTeacher.demo.web.dto.PostResponseDto;
import com.SolvingWithTeacher.demo.web.dto.PostSaveRequestDto;
import com.SolvingWithTeacher.demo.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        System.out.println(requestDto.toString());
        System.out.println("hello");
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}
