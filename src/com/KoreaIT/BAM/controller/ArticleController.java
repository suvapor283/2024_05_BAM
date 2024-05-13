package com.KoreaIT.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.dto.Article;

public class ArticleController {

	private Scanner sc;
	private List<Article> articles;
	private int lastArticleNum;

	public ArticleController(Scanner sc) {

		this.sc = sc;
		this.articles = new ArrayList<>();
		this.lastArticleNum = 1;
	}

	public void doWrite() {

		System.out.printf("제목 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 : ");
		String content = sc.nextLine().trim();

		Article article = new Article(lastArticleNum, Util.getDateStr(), title, content, 0);
		articles.add(article);

		System.out.println(lastArticleNum + "번 글이 생성되었습니다.");
		lastArticleNum++;
	}

	public void doModify(String cmd) {
		int num = getCmdNum(cmd);

		if (num == 0) {
			System.out.println("명령어가 올바르지 않습니다.");
			return;
		}

		Article foundArticle = getArticleById(num);

		if (foundArticle == null) {
			System.out.println(num + "번 게시물이 존재하지 않습니다.");
			return;
		}

		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine().trim();
		System.out.printf("수정할 내용 : ");
		String content = sc.nextLine().trim();

		foundArticle.setTitle(title);
		foundArticle.setContent(content);

		System.out.println(num + "번 게시물이 수정되었습니다.");
	}

	public void doDelete(String cmd) {
		int num = getCmdNum(cmd);

		if (num == 0) {
			System.out.println("명령어가 올바르지 않습니다.");
			return;
		}

		Article foundArticle = getArticleById(num);

		if (foundArticle == null) {
			System.out.println(num + "번 게시물이 존재하지 않습니다.");
			return;
		}

		articles.remove(foundArticle);

		System.out.println(num + "번 게시물이 삭제되었습니다.");
	}

	public void showDetail(String cmd) {
		int num = getCmdNum(cmd);

		if (num == 0) {
			System.out.println("명령어가 올바르지 않습니다.");
			return;
		}

		Article foundArticle = getArticleById(num);

		if (foundArticle == null) {
			System.out.println(num + "번 게시물이 존재하지 않습니다.");
			return;
		}

		foundArticle.increaseViewcnt();

		System.out.println("번호 : " + foundArticle.getNum());
		System.out.println("날짜 : " + foundArticle.getRegDate());
		System.out.println("제목 : " + foundArticle.getTitle());
		System.out.println("내용 : " + foundArticle.getContent());
		System.out.println("조회수 : " + foundArticle.getViewCnt());
	}

	public void showList(String cmd) {
		if (articles.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
			return;
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
				return;
			}
		}

		System.out.println("	번호	|	제목	|		날짜		|	조회수");

		for (int i = printArticles.size() - 1; i >= 0; i--) {
			Article article = printArticles.get(i);
			System.out.printf("	%d	|	%s	|	%s	|	%d\n", article.getNum(), article.getTitle(),
					article.getRegDate(), article.getViewCnt());
		}
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

	private Article getArticleById(int num) {

		for (Article article : articles) {
			if (article.getNum() == num) {
				return article;
			}
		}
		return null;
	}

	public void makeTestArticleData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다.");

		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleNum++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));
		}
	}
}
