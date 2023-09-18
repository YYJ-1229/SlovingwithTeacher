package com.SolvingWithTeacher.demo.service;

import com.SolvingWithTeacher.demo.web.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponseDto getUser(Long id);
//    UserResponseDto saveUser(UserDto userDto);
    UserResponseDto changeUserName(Long id, String name) throws Exception;

    void deleteUser(Long id) throws Exception;

    UserResponseDto changeUserPic(Long id, String pic) throws Exception;
}
