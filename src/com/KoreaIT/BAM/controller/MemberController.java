package com.KoreaIT.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.dto.Member;

public class MemberController {

	private Scanner sc;
	private List<Member> members;
	private int lastMemberNum;

	public MemberController(Scanner sc) {

		members = new ArrayList<>();
		lastMemberNum = 1;
	}

	public void doJoin() {
		String loginId = null;
		String loginPw = null;
		String loginPwChk = null;
		String name = null;

		while (true) {
			System.out.printf("이름 : ");
			name = sc.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("이름은 필수 입력 정보입니다.");
				continue;
			}
			break;
		}

		while (true) {
			boolean a = false;

			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();

			if (loginId.isEmpty()) {
				System.out.println("아이디는 필수 입력 정보입니다.");
				continue;
			}
			if (loginIdDupChk(loginId) == false) {
				System.out.println("[ " + loginId + " ] 은(는) 이미 사용중인 아이디입니다.");
				continue;
			}

			System.out.println("[ " + loginId + " ] 은(는) 사용가능한 아이디입니다.");
			break;
		}

		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();

			if (loginPw.isEmpty()) {
				System.out.println("비밀번호는 필수 입력 정보입니다.");
				continue;
			}

			System.out.printf("비밀번호 확인 : ");
			loginPwChk = sc.nextLine().trim();

			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
				continue;
			}
			break;
		}

		Member member = new Member(lastMemberNum, Util.getDateStr(), name, loginId, loginPw);
		members.add(member);

		System.out.println("[ " + loginId + " ] 회원님의 가입이 완료되었습니다.");
		lastMemberNum++;
	}

	private boolean loginIdDupChk(String loginId) {
		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return false;
			}
		}
		return true;
	}

	public void makeTestMemberData() {
		System.out.println("테스트용 회원 데이터를 3개 생성했습니다.");

		for (int i = 1; i <= 3; i++) {
			members.add(new Member(lastMemberNum++, Util.getDateStr(), "user" + i, "user" + i, "유저" + i));
		}
	}
}
