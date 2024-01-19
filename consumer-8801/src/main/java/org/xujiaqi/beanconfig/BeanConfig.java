package org.xujiaqi.beanconfig;

//import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
//import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

//    @Bean
//    public SentinelResourceAspect sentinelResourceAspect(){
//        return new SentinelResourceAspect();
//    }

//    @Bean
//    public Logger.Level logger(){
//        return Logger.Level.FULL;
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
