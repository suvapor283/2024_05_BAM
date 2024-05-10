package com.KoreaIT.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.controller.MemberController;
import com.KoreaIT.BAM.dto.Article;

public class App {

	private List<Article> articles;
	private int lastArticleNum;

	public App() {

		articles = new ArrayList<>();
		lastArticleNum = 1;
	}

	public void run() {

		System.out.println("== 프로그램 시작 ==");

		makeTestArticleData();

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);

		memberController.makeTestMemberData();

		while (true) {

			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("member join")) {
				memberController.doJoin();
			}

			else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String content = sc.nextLine().trim();

				Article article = new Article(lastArticleNum, Util.getDateStr(), title, content, 0);
				articles.add(article);

				System.out.println(lastArticleNum + "번 글이 생성되었습니다.");
				lastArticleNum++;
			}

			else if (cmd.startsWith("article modify ")) {

				int num = getCmdNum(cmd);

				if (num == 0) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}

				Article foundArticle = getArticleById(num);

				if (foundArticle == null) {
					System.out.println(num + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String content = sc.nextLine().trim();

				foundArticle.setTitle(title);
				foundArticle.setContent(content);

				System.out.println(num + "번 게시물이 수정되었습니다.");
			}

			else if (cmd.startsWith("article delete ")) {

				int num = getCmdNum(cmd);

				if (num == 0) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}

				Article foundArticle = getArticleById(num);

				if (foundArticle == null) {
					System.out.println(num + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				articles.remove(foundArticle);

				System.out.println(num + "번 게시물이 삭제되었습니다.");
			}

			else if (cmd.startsWith("article detail ")) {

				int num = getCmdNum(cmd);

				if (num == 0) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}

				Article foundArticle = getArticleById(num);

				if (foundArticle == null) {
					System.out.println(num + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				foundArticle.increaseViewcnt();

				System.out.println("번호 : " + foundArticle.getNum());
				System.out.println("날짜 : " + foundArticle.getRegDate());
				System.out.println("제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getContent());
				System.out.println("조회수 : " + foundArticle.getViewCnt());
			}

			else if (cmd.startsWith("article list")) {

				if (articles.isEmpty()) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				}

				String searchKeyword = cmd.substring("article list".length()).trim();

				List<Article> printArticles = articles;

				if (searchKeyword.length() > 0) {
					System.out.println("검색어 : " + searchKeyword);

					printArticles = new ArrayList<>();

					for (Article article : articles) {
						if (article.getTitle().contains(searchKeyword)) {
							printArticles.add(article);
						}
					}

					if (printArticles.size() == 0) {
						System.out.println("검색결과가 없습니다.");
						continue;
					}
				}

				System.out.println("	번호	|	제목	|		날짜		|	조회수");

				for (int i = printArticles.size() - 1; i >= 0; i--) {
					Article article = printArticles.get(i);
					System.out.printf("	%d	|	%s	|	%s	|	%d\n", article.getNum(), article.getTitle(),
							article.getRegDate(), article.getViewCnt());
				}
			}

			else if (cmd.equals("exit")) {
				break;
			}

			else if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");

	}

	private Article getArticleById(int num) {

		for (Article article : articles) {
			if (article.getNum() == num) {
				return article;
			}
		}
		return null;
	}

	private int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int num = 0;

		try {
			num = Integer.parseInt(cmdBits[2]);
			return num;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private void makeTestArticleData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다.");

		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleNum++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));
		}
	}
}