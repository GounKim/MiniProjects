package com.service.member;

import java.util.HashMap;

import com.dto.member.MemberDTO;

public interface MemberService {
	
	public int idDuplicateCheck(String userid) throws Exception;
	public int memberAdd(MemberDTO dto) throws Exception;
	public MemberDTO login(HashMap<String, String> map) throws Exception;
}
