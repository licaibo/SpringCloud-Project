package com.licaibo.auth.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author licaibo
 * @date 2019-12-19
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/test/redis/session")
    public String cookie(@RequestParam("browser") String browser, HttpSession session, HttpServletRequest request) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }


        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }

        return "index";
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test spring security");
        return "test spring security";
    }



}
