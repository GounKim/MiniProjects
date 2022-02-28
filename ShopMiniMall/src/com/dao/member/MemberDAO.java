package com.dao.member;

import org.apache.ibatis.session.SqlSession;

import com.dto.member.MemberDTO;

public class MemberDAO {
	
	public int idDuplicateCheck(SqlSession session, String userid) throws Exception {
		return session.selectOne("com.config.MemberMapper.idDuplicateCheck", userid);
	}
	
	public int memberAdd(SqlSession session, MemberDTO dto) throws Exception {
		return session.insert("com.config.MemberMapper.memberAdd", dto);
	}
}
