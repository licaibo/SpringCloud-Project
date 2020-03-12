package com.licaibo.auth.controller;

import com.licaibo.auth.security.MyUserDetails;
import com.licaibo.framework.base.BasicResultController;
import com.licaibo.framework.enu.HttpResultEnum;
import com.licaibo.framework.exception.BasicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.RemoteEndpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * @author licaibo
 * @date 2019-12-19
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BasicResultController {


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

    @GetMapping("/get")
    public ResponseEntity get() {
        if(true) {
          throw  new BasicException(HttpResultEnum.NOT_FOUND.getCode(),"没发现服务");
        }
        return responseOk("get请求成功");
    }

    @PostMapping("/post")
    public ResponseEntity post() {
        System.out.println("test spring security");
        return responseOk("post请求成功");
    }

    @GetMapping("/info")
    public ResponseEntity info() {
        MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return responseOk(principal);
    }



}
