package cn.chen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//数据动态刷新注解
@RefreshScope
@EnableDiscoveryClient
public class ConfigClientApp {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;

    @RequestMapping("/name")
    public String findName(){
        return name;
    }

    @RequestMapping("/password")
    public String findpassword(){
        return password;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class,args);
    }
}
