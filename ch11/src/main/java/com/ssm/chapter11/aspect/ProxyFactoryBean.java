package com.ssm.chapter11.aspect;

import com.ssm.chapter11.game.pojo.Role;
import com.ssm.chapter11.game.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactoryBean {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-cfg.xml");
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name");
		role.setNote("note");
		RoleService roleService = (RoleService) ctx.getBean("roleService");
		roleService.printRole(role);
	}
}
