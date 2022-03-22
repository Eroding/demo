package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Controller.
 *
 * @author cnh
 * @date 2021 -09-27
 */
@RestController
@RequestMapping("/con")
public class Controller {

    @Autowired
    private UserService userService;

    /**
     * Register string.
     *
     * @return the string
     */
    @GetMapping("register")
    public String register() {
        UserVo userVo = new UserVo();
        userService.register(userVo);
        return "finish";
    }
}
