package com.ssm.chapter8.mapper;

import com.ssm.chapter8.params.PageParams;
import com.ssm.chapter8.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
	
	public Role getRole(Long id);

	public List<Role> findRole(@Param("pageParams") PageParams pageParams, @Param("roleName") String roleName);
}