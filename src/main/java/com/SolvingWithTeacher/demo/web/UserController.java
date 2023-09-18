package com.SolvingWithTeacher.demo.web;


import com.SolvingWithTeacher.demo.service.UserService;
import com.SolvingWithTeacher.demo.web.dto.ChangeUserNameDto;
import com.SolvingWithTeacher.demo.web.dto.ChangeUserPicDto;
import com.SolvingWithTeacher.demo.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public ResponseEntity<UserResponseDto> getUser(Long id){
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping("/changeName")
    public ResponseEntity<UserResponseDto> changeUserName(@RequestBody ChangeUserNameDto changeUserNameDto) throws Exception{
        UserResponseDto userResponseDto = userService.changeUserName(changeUserNameDto.getId(), changeUserNameDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
    @PutMapping("/changePic")
    public ResponseEntity<UserResponseDto> changeUserPic(@RequestBody ChangeUserPicDto changeUserPicDto) throws Exception{
        UserResponseDto userResponseDto = userService.changeUserPic(changeUserPicDto.getId(), changeUserPicDto.getPic());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(Long id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
    }
}
