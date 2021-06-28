package cn.sky.cloud.alibaba.controller;

import cn.sky.cloud.alibaba.pojo.User;
import cn.sky.cloud.alibaba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @DubboReference(group="sky-cloud-group")
    private UserService userService;

    @RequestMapping("/get")
    public User get(Long id){
        log.info("==============");
        return userService.get(id);
    }
}
