package com.SolvingWithTeacher.demo.web.dto;


import com.SolvingWithTeacher.demo.domain.user.Role;

public class UserResponseDto {
    private Long id;
    private String name;
    private String picture;
    private String email;
    private Role role;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String name, String picture, String email, Role role) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}