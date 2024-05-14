package com.KoreaIT.BAM.controller;

import java.util.Scanner;

import com.KoreaIT.BAM.dto.Member;

public abstract class Controller {

	public Scanner sc;
	public int lastNum;
	public String cmd;
	public static Member loginedMember;

	public abstract void doAction(String cmd, String methodName);

	public abstract void makeTestData();

	public static boolean isLogined() {
		return loginedMember != null;
	}
}
