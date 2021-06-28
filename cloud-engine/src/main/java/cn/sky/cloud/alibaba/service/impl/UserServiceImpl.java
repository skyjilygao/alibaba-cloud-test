package cn.sky.cloud.alibaba.service.impl;

import cn.sky.cloud.alibaba.pojo.User;
import cn.sky.cloud.alibaba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DubboService(group="sky-cloud-group")
public class UserServiceImpl implements UserService {
    @Override
    public User get(Long id) {
        User u = new User();
        u.setAge(2);
        u.setName("yaoyao");
        u.setId(id);
        return u;
    }
}
