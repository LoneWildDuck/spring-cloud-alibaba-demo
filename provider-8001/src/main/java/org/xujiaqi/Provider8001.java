package org.xujiaqi;

//import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//开启服务发现
//@EnableDubbo
//@EnableFeignClients
public class Provider8001
{
    public static void main( String[] args )
    {
        SpringApplication.run(Provider8001.class, args);
    }
}
