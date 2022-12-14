package com.SolvingWithTeacher.demo.web.dao.impl;

import com.SolvingWithTeacher.demo.domain.user.User;
import com.SolvingWithTeacher.demo.domain.user.UserRepository;
import com.SolvingWithTeacher.demo.web.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User selectUser(Long id) {// 다시 확인해보기
        User selectedUser = userRepository.getReferenceById(id); // 나중에 확인
        return null;
    }

    @Override
    public User updateUserName(Long id, String name) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);
        User updateUser;
        if(selectedUser.isPresent()){
            User user = selectedUser.get();

            user.setName(name);
            user.setUpdatedAt(LocalDateTime.now()); // 다시 확인해보기

            updateUser = userRepository.save(user);
        }else{
            throw new Exception();
        }
        return updateUser;
    }

    @Override
    public User updateUserPic(Long id, String img) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);

        User updateUser;

        if(selectedUser.isPresent()){
            User user = selectedUser.get();

            user.setPicture(img);
            user.setUpdatedAt(LocalDateTime.now()); // 다시 확인해보기

            updateUser = userRepository.save(user);
        }else{
            throw new Exception();
        }
        return updateUser;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);

        if(selectedUser.isPresent()){
            User user = selectedUser.get();
            userRepository.delete(user);
        }else{
            throw new Exception();
        }
    }
}
