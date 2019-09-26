package com.qf.controller;

import com.qf.Response.ResponseUserLogin;
import com.qf.domain.UserLogin;
import com.qf.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 54110 on 2019-09-25.
 */
@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;


    @RequestMapping("/findAll/{page}/{size}")
    public ResponseUserLogin findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size, HttpServletRequest request){
        HttpSession session =  request.getSession();
       if (session.getAttribute("name")!=null){
           session.setAttribute("name","张三");
           System.out.println("用户未登陆");
       }
        System.out.println("用户以登陆");



        return    userLoginService.findAll(page,size);
    }

    @RequestMapping("/insertUser")
    public UserLogin save(@RequestBody UserLogin userLogin){
        return userLoginService.save(userLogin);
    }

    @RequestMapping("/deleteUser")
    public String delete(@RequestBody UserLogin userLogin){

        return userLoginService.delete(userLogin);
    }

    @RequestMapping("/selectById")
    public UserLogin selectById(@RequestBody UserLogin userLogin){

        return userLoginService.selectById(userLogin);
    }

    @RequestMapping("/updateData")
    public UserLogin updateData(@RequestBody UserLogin userLogin){

        return userLoginService.updateData(userLogin);
    }
}
