package com.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	// config와 .java 사이의 의존성을 떨어뜨리기 위해서 분리
	static SqlSessionFactory sqlSessionFactory;
	
	static {
		//Configuration.xml 등록 -> 중요함, db연결에 관련된 모든 정보를 가지고 있음
		String resource = "com/config/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
	
	}// end static block
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}// end static method
	
}// end class
