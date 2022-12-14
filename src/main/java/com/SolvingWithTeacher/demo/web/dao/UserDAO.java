package com.SolvingWithTeacher.demo.web.dao;


import com.SolvingWithTeacher.demo.domain.user.User;

public interface UserDAO {
    User selectUser(Long id);
    User updateUserName(Long id, String name) throws Exception;
    User updateUserPic(Long id, String pic) throws Exception;

    void deleteUser(Long id) throws Exception;
}
