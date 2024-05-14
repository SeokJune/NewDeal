package com.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, Equals, HashCode 등을 자동 생성
@NoArgsConstructor // 파라미터 없는 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 자동 생성
public class MemberDTO {
	private int code;
	private String userId;
	private String password;
}
