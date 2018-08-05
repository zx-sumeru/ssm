package com.ssm.chapter10.annotation.service.impl;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.stereotype.Component;

@Component("roleService3")
//@Primary
public class RoleServiceImpl3 implements RoleService {
	
	@Override
	public void printRoleInfo(Role role) {
		System.out.print("{id =" + role.getId());
		System.out.print(", roleName =" + role.getRoleName());
		System.out.println(", note =" + role.getNote() + "}");
	}
}