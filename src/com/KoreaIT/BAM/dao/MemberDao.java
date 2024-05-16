package com.KoreaIT.BAM.dao;

import java.util.List;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.container.Container;
import com.KoreaIT.BAM.dto.Member;

public class MemberDao {
	private List<Member> members;
	private int lastNum;

	public MemberDao() {
		this.lastNum = 1;
		this.members = Container.members;
	}

	public void joinMember(String name, String loginId, String loginPw) {

		members.add(new Member(lastNum, Util.getDateStr(), name, loginId, loginPw));
		lastNum++;
	}

	public boolean loginIdDupChk(String loginId) {

		Member member = getMemberByLoginId(loginId);

		if (member != null) {
			return false;
		}

		return true;
	}

	public Member getMemberByLoginId(String loginId) {

		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return member;
			}
		}

		return null;
	}

	public String getLoginIdByMemberId(int memberId) {

		for (Member member : members) {
			if (memberId == member.getNum()) {
				return member.getLoginId();
			}
		}

		return null;
	}
}
