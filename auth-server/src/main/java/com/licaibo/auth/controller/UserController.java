package com.licaibo.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

/**
 * @author licaibo
 * @date 2019-12-19
 **/
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {


    @RequestMapping("/test/redis/session")
    public String cookie(@RequestParam("browser") String browser, HttpSession session) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }

        return "index";
    }


}
