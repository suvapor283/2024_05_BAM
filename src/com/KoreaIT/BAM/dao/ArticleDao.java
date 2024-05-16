package com.KoreaIT.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.dto.Article;

public class ArticleDao {
	private List<Article> articles;
	private int lastNum;

	public ArticleDao() {
		this.articles = new ArrayList<>();
		this.lastNum = 1;
	}

	public int writeArticle(int memberNum, String title, String content, int viewCnt) {

		articles.add(new Article(lastNum, Util.getDateStr(), memberNum, title, content, viewCnt));
		return lastNum++;
	}

	public void modifyArticle(Article foundArticle, String title, String content) {

		foundArticle.setTitle(title);
		foundArticle.setContent(content);
	}

	public void deleteArticle(Article foundArticle) {

		articles.remove(foundArticle);
	}

	public Article getArticleById(int num) {

		for (Article article : articles) {
			if (article.getNum() == num) {
				return article;
			}
		}

		return null;
	}

	public void increaseViewcnt(Article foundArticle) {

		foundArticle.increaseViewcnt();
	}

	public List<Article> getPrintArticles(String searchKeyword) {

		if (searchKeyword.length() > 0) {
			System.out.println("검색어 : " + searchKeyword);

			List<Article> printArticles = new ArrayList<>();

			for (Article article : articles) {
				if (article.getTitle().contains(searchKeyword)) {
					printArticles.add(article);
				}
			}

			return printArticles;
		}

		return articles;
	}
}
