package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.MemberDTO;
import com.sample.services.MemberService;

@RestController
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@PostMapping(value = "login", produces = "application/text; charset=utf8")
	public ResponseEntity<?> login(Model model, @RequestBody MemberDTO memberDTO) throws Exception {
		try {
			int result = memberService.login(memberDTO);
			if (result != 1) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 혹은 비밀번호가 맞지 않습니다");
			} else {
				return ResponseEntity.ok().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류 발생: " + e.getMessage());
		}
	}
}
