package com.yaocongfei.controller;

import com.yaocongfei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    //返回json
    @ResponseBody
    @RequestMapping("/getUser")
    public User toIndex(HttpServletRequest request, @RequestBody User user) {
        User u = new User();
        System.out.println(user.getUsername());
        com.yaocongfei.model.User aa = userService.getUserById(1);
        System.out.println(aa.getAge());
        System.out.println(aa.getPassword());
        System.out.println(aa.getUserName());
        System.out.println(aa.getId());
        return u;
    }
  /*//返回jsp
  @RequestMapping("/showUser")
  public String showUser(HttpServletRequest request,Model model){
    int userId = Integer.parseInt(request.getParameter("id"));
    User user = this.userService.getUserById(userId);
    model.addAttribute("user", user);
    return "showUser";
  }*/
}