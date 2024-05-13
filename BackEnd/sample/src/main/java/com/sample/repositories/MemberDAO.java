package com.sample.repositories;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate db;
	
	// 로그인
	public int login(MemberDTO memberDTO) {
		return db.insert("Member.login", memberDTO);
	}
}
