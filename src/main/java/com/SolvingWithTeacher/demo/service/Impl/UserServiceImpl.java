package com.SolvingWithTeacher.demo.service.Impl;


import com.SolvingWithTeacher.demo.domain.user.User;
import com.SolvingWithTeacher.demo.service.UserService;
import com.SolvingWithTeacher.demo.web.dao.UserDAO;
import com.SolvingWithTeacher.demo.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserResponseDto getUser(Long id) { // get을 화려면 다 가져와야 하는거 아닌감
        User user = userDAO.selectUser(id);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setRole(user.getRole());
        userResponseDto.setPicture(user.getPicture());

        return userResponseDto;
    }

    @Override
    public UserResponseDto changeUserName(Long id, String name) throws Exception {
        User changeUser = userDAO.updateUserName(id, name);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(changeUser.getName());
        return userResponseDto;
    }

    @Override
    public UserResponseDto changeUserPic(Long id, String img) throws Exception {
        User changeUser = userDAO.updateUserPic(id, img);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setPicture(changeUser.getPicture());
        return userResponseDto;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
