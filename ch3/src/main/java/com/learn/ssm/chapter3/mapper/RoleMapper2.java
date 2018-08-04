package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper2 {
	
	@Select("select id, role_name as roleName, note from t_role where id=#{id}")
	public Role getRole(Long id);
}
