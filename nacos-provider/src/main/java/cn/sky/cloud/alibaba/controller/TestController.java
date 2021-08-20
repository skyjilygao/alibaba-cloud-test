package cn.sky.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/test")
public class TestController {

    private static Integer count = 0;
    @Value("${server.port}")
    private Integer port;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(String name){
        return "hello " + name +", this server port: " + port + ", time: " + ZonedDateTime.now() +" \t count="+(++count);
    }
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
