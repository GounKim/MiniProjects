package com.dao.member;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	
	public int idDuplicateCheck(SqlSession session, String userid) throws Exception {
		return session.selectOne("com.config.MemberMapper.idDuplicateCheck", userid);
	}
}
