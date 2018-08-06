package com.ssm.chapter12.mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ssm.chapter12.pojo.Role;

@Repository
public interface RoleMapper {
    // TODO: by zx 2018/8/6 上午10:13 :: 这里直接传pojo就可以直接获取其中的属性 #{field}
	int insertRole(Role role);

	Role getRole(@Param("id") Long id);

	int updateRole(Role role);

	int deleteRole(@Param("id") Long id);
}