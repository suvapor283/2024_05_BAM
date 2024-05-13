package com.KoreaIT.BAM;

import java.util.Scanner;

import com.KoreaIT.BAM.controller.ArticleController;
import com.KoreaIT.BAM.controller.Controller;
import com.KoreaIT.BAM.controller.MemberController;

public class App {

	public void run() {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);

		memberController.makeTestData();
		articleController.makeTestData();

		while (true) {

			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			String[] cmdBits = cmd.split(" ");

			if (cmdBits.length < 2) {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			String controllerName = cmdBits[0];
			String methodName = cmdBits[1];

			Controller controller = null;

			if (controllerName.equals("member")) {
				controller = memberController;
			}

			else if (controllerName.equals("article")) {
				controller = articleController;
			}

			else if (cmd.equals("exit")) {
				break;
			}

			else if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			} else {
				System.out.println("존재하지 않는 명령어입니다.");
				continue;
			}

			controller.doAction(cmd, methodName);
		}

		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}
}