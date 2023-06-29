package com.jph.myblog.controller;

import com.jph.myblog.entity.Result;
import com.jph.myblog.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rememberMe", required = false, defaultValue = "true") Boolean rememberMe,
                        HttpSession session, ModelAndView mv) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            subject.login(token);
            session.setAttribute("user", token.getPrincipal().toString());
        } catch (UnknownAccountException e) {
            mv.setViewName("login");
            mv.addObject("accountMsg", "账号不存在");
            return mv;
        } catch (IncorrectCredentialsException e) {
            mv.setViewName("login");
            mv.addObject("passwordMsg", "密码错误");
            return mv;
        } catch (Exception e) {
            mv.setViewName("login");
            mv.addObject("msg", "系统异常");
            return mv;
        }
        mv.setViewName("index");
        mv.addObject("msg", "登陆成功");
        return mv;
    }

    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }
}
