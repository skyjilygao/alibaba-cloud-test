package cn.sky.cloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    /*@DubboReference(group="sky-cloud-group")
    private UserService userService;

    @RequestMapping("/get")
    public User get(Long id){
        log.info("==============");
        return userService.get(id);
    }*/
}
