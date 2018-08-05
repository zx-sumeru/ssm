package com.ssm.chapter11.multi.bean.impl;

import com.ssm.chapter11.multi.bean.MultiBean;
import org.springframework.stereotype.Component;

@Component
public class MultiBeanImpl implements  MultiBean {

	@Override
	public void testMulti() {
		System.out.println("test multi aspects!!");
	}

}