package com.KoreaIT.BAM.service;

import com.KoreaIT.BAM.dao.MemberDao;
import com.KoreaIT.BAM.dto.Member;

public class MemberService {

	private MemberDao memberDao;
	
		public MemberService() {
			memberDao = new MemberDao();
		}

		public boolean loginIdDupChk(String loginId) {
			return memberDao.loginIdDupChk(loginId);
		}

		public void joinMember(String name, String loginId, String loginPw) {
			memberDao.joinMember(name, loginId, loginPw);
		}

		public Member getMemberByLoginId(String loginId) {
			return memberDao.getMemberByLoginId(loginId);
		}
}
