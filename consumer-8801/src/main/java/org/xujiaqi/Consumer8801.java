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
//@EnableDubbo
@EnableDiscoveryClient
//@EnableFeignClients
public class Consumer8801
{
    public static void main( String[] args )
    {
        SpringApplication.run(Consumer8801.class, args);
    }
}
