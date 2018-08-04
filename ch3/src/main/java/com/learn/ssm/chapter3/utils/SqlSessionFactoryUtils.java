package com.learn.ssm.chapter3.utils;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.mapper.RoleMapper2;
import com.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

	private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

	private static SqlSessionFactory sqlSessionFactory = null;

	private SqlSessionFactoryUtils() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		synchronized (LOCK) {
			if (sqlSessionFactory != null) {
				return sqlSessionFactory;
			}
			String resource = "mybatis-config.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
			return sqlSessionFactory;
		}
	}
	
	
	//��������SqlSessionFactory
	public static SqlSessionFactory getSqlSessionFactory2() {
		synchronized (LOCK) {
			//���ݿ����ӳ���Ϣ
			PooledDataSource dataSource = new PooledDataSource();
			dataSource.setDriver("com.mysql.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("123456");
			dataSource.setUrl("jdbc:mysql://localhost:3306/chapter3");
			dataSource.setDefaultAutoCommit(false);
			//����MyBatis��JDBC����ʽ
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development", transactionFactory, dataSource);
			//����Configuration����
			Configuration configuration = new Configuration(environment);
			//ע��һ��MyBatis�����ı���
			configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
			//����һ��ӳ����
			configuration.addMapper(RoleMapper.class);
			configuration.addMapper(RoleMapper2.class);
			//ʹ��SqlSessionFactoryBuilder����SqlSessionFactory
			sqlSessionFactory = 
			    new SqlSessionFactoryBuilder().build(configuration);
			return sqlSessionFactory; 	
		}
	}

	public static SqlSession openSqlSession() {
		if (sqlSessionFactory == null) {
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
}