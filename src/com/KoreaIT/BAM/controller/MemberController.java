package com.KoreaIT.BAM.controller;

import java.util.Scanner;

import com.KoreaIT.BAM.dto.Member;
import com.KoreaIT.BAM.service.MemberService;

public class MemberController extends Controller {
	private MemberService memberService;

	public MemberController(Scanner sc) {
		this.sc = sc;
		this.memberService = new MemberService();
		loginedMember = null;
	}

	public void doAction(String cmd, String methodName) {

		switch (methodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
		}
	}

	private void doJoin() {

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

			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();

			if (loginId.isEmpty()) {
				System.out.println("아이디는 필수 입력 정보입니다.");
				continue;
			}

			if (memberService.loginIdDupChk(loginId) == false) {
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

		memberService.joinMember(name, loginId, loginPw);

		System.out.println("[ " + loginId + " ] 회원님의 가입이 완료되었습니다.");
	}

	private void doLogin() {

		System.out.printf("ID : ");
		String loginId = sc.nextLine().trim();
		System.out.printf("PW : ");
		String loginPw = sc.nextLine().trim();

		Member foundMember = memberService.getMemberByLoginId(loginId);

		if (foundMember == null) {
			System.out.println("존재하지 않는 아이디 입니다.");
			return;
		}

		if (foundMember.getLoginPw().equals(loginPw) == false) {
			System.out.println("비밀번호를 확인해주세요.");
			return;
		}

		loginedMember = foundMember;

		System.out.println("로그인 성공 !");
	}

	private void doLogout() {

		loginedMember = null;
		System.out.println("로그아웃 !");
	}

	public void makeTestData() {

		System.out.println("테스트용 회원 데이터를 3개 생성했습니다.");

		for (int i = 1; i <= 3; i++) {
			memberService.joinMember("유저" + i, "user" + i, "user" + i);
		}
	}
}
