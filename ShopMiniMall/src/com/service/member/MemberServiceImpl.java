package com.service.member;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.member.MemberDAO;
import com.dto.member.MemberDTO;

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

	@Override
	public int memberAdd(MemberDTO dto) throws Exception {
		int num = 0;
		
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			MemberDAO dao = new MemberDAO();
			num = dao.memberAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

}
