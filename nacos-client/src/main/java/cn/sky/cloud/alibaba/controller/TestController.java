package cn.sky.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

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
    public String sayHello(String name){
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/test/hello?name="+name,serviceInstance.getHost(),
                serviceInstance.getPort());
        return restTemplate.getForObject(path, String.class);*/
        return restTemplate.getForObject("http://nacos-provider/test/hello?name="+name, String.class);
    }
}
