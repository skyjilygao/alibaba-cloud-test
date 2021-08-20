package cn.sky.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Map<String, Integer> countMap = new ConcurrentHashMap<>(2);

    @Autowired
    private RestTemplate restTemplate;
    /*
    @Bean
    @LoadBalanced
    public RestTemplate rest() {
        return new RestTemplate();
    }*/
//    private final RestTemplate restTemplate;

   /* @Autowired
    private LoadBalancerClient loadBalancerClient;*/

    /*@Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}*/

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(HttpSession httpSession, String name){

        countMap.put("hello", countMap.getOrDefault("hello", 0) + 1);
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/test/hello?name="+name,serviceInstance.getHost(),
                serviceInstance.getPort());
        return restTemplate.getForObject(path, String.class);*/
        System.out.println("hello ---> \t "+countMap.getOrDefault("hello", 0));
        return restTemplate.getForObject("http://nacos-provider/test/hello?name="+name, String.class) + " client" +
                "============== sessionId="+httpSession.getId();
    }
}
