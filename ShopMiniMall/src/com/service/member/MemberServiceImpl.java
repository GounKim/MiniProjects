package com.service.member;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.member.MemberDAO;

public class MemberServiceImpl implements MemberService {

	@Override
	public int idDuplicateCheck(String userid) throws Exception {
		int num = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.idDuplicateCheck(session, userid);
		} finally {
			session.close();
		}
		
		return num;
	}

}
