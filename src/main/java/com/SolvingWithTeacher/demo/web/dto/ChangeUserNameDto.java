package com.SolvingWithTeacher.demo.web.dto;

public class ChangeUserNameDto {
    private Long id;
    private String name;

    public ChangeUserNameDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public ChangeUserNameDto(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
