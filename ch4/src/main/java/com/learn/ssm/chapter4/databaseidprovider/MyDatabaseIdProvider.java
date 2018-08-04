package com.learn.ssm.chapter4.databaseidprovider;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MyDatabaseIdProvider implements DatabaseIdProvider {

	private static final String DATEBASE_TYPE_DB2 = "DB2";
	private static final String DATEBASE_TYPE_MYSQL = "MySQL";
	private static final String DATEBASE_TYPE_ORACLE = "Oralce";

	private Logger log = Logger.getLogger(MyDatabaseIdProvider.class);

	@Override
	public void setProperties(Properties props) {
		log.info(props);
	}

	@Override
	public String getDatabaseId(DataSource dataSource) throws SQLException {
		Connection connection = dataSource.getConnection();
		// TODO: by ZX 2018/8/4 15:06 :: 获取数据库名称的方法 connection.getMetaData().getDatabaseProductName()
		String dbProductName = connection.getMetaData().getDatabaseProductName();
		if (MyDatabaseIdProvider.DATEBASE_TYPE_DB2.equals(dbProductName)) {
			return "db2";
		} else if (MyDatabaseIdProvider.DATEBASE_TYPE_MYSQL
				.equals(dbProductName)) {
			return "mysql";
		} else if (MyDatabaseIdProvider.DATEBASE_TYPE_ORACLE
				.equals(dbProductName)) {
			return "oracle";
		} else {
			return null;
		}
	}

}
