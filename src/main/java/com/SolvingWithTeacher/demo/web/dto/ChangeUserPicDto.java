package com.SolvingWithTeacher.demo.web.dto;

public class ChangeUserPicDto {
    private Long id;
    private String pic;

    public ChangeUserPicDto(Long id, String pic) {
        this.id = id;
        this.pic = pic;
    }
    public ChangeUserPicDto(){}

    public Long getId() {
        return id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}

