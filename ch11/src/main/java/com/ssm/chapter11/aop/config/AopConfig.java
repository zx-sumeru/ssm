package com.ssm.chapter11.aop.config;

import com.ssm.chapter11.aop.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ssm.chapter11.aop")
public class AopConfig {
	
	@Bean
    public RoleAspect getRoleAspect() {
        return new RoleAspect();
    }
}
