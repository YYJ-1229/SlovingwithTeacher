package com.SolvingWithTeacher.demo.web.dto;

public class UserDto {
    private String name;
    private String email;

    private String img;


    public UserDto(String name, String email, String img) {
        this.name = name;
        this.email = email;
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return img;
    }

    public void setPicture(String img) {
        this.img = img;
    }
}
