package com.sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dto.MemberDTO;
import com.sample.repositories.MemberDAO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public int login(MemberDTO memberDTO) {
		return memberDAO.login(memberDTO);
	}
}
