package com.learn.ssm.chapter4.mapper;

import com.learn.ssm.chapter4.pojo.Role;

import java.util.List;

public interface RoleMapper {
	public int insertRole(Role role);
	public int deleteRole(Long id);
	public int updateRole(Role role);
	public Role getRole(Long id);
	public List<Role> findRoles(String roleName);
}