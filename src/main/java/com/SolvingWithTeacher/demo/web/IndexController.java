package com.SolvingWithTeacher.demo.web;


import com.SolvingWithTeacher.demo.config.auth.LoginUser;
import com.SolvingWithTeacher.demo.config.auth.dto.SessionUser;
import com.SolvingWithTeacher.demo.domain.user.Role;
import com.SolvingWithTeacher.demo.domain.user.UserRepository;
import com.SolvingWithTeacher.demo.service.PostService;
import com.SolvingWithTeacher.demo.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final PostService postService;

    public static Role user_Role;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postService.findAllDesc());
        return "index";
    }

    @GetMapping("/post/save")
    public String post(){
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);
        return "post-update";
    }

    @GetMapping("/student")
    public String studentMain(Model model, @LoginUser SessionUser user) {
        user_Role = Role.STUDENT;
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userRole", user.getRole());
        }
        return "student-login";
    }

    @GetMapping("/teacher")
    public String teacherMain(Model model, @LoginUser SessionUser user) {
        user_Role = Role.TEACHER;
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userRole", user.getRole());
        }
        return "teacher-login";
    }
    @GetMapping("/mypage")
    public String mypageMain(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userRole", user.getRole());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPic", user.getPicture());
        }
        else return "index";

        return "mypage";
    }
//    @RequestMapping(value="/updateImg", method=RequestMethod.POST)
//    public String updateImg(MultipartHttpServletRequest mpRequest, HttpSession session ,SessionUser user)throws Exception{
//        String memberImg = fileUtils.updateImg(mpRequest);
//        userService.updateImg(memberImg, user.getEmail());
//        user.setPicture(memberImg);
//        return "/mypage";
//    }
//    <update id="updateImg">
//    update MP_MEMBER set MEMBER_IMG = #{memberImg} where Member_ID = #{memberId}
//</update>

}
