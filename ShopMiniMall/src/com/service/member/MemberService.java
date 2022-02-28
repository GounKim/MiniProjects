package com.service.member;

import com.dto.member.MemberDTO;

public interface MemberService {
	
	public int idDuplicateCheck(String userid) throws Exception;
	public int memberAdd(MemberDTO dto) throws Exception;
}
