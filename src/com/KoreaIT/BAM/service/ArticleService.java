package com.KoreaIT.BAM.service;

import java.util.List;

import com.KoreaIT.BAM.dao.ArticleDao;
import com.KoreaIT.BAM.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() {
		this.articleDao = new ArticleDao();
	}

	public int writeArticle(int memberNum, String title, String content, int viewCnt) {

		return articleDao.writeArticle(memberNum, title, content, viewCnt);
	}

	public void modifyArticle(Article foundArticle, String title, String content) {

		articleDao.modifyArticle(foundArticle, title, content);
	}

	public void deleteArticle(Article foundArticle) {

		articleDao.deleteArticle(foundArticle);
	}

	public Article getArticleById(int num) {

		return articleDao.getArticleById(num);
	}

	public void increaseViewcnt(Article foundArticle) {

		articleDao.increaseViewcnt(foundArticle);
	}

	public List<Article> getPrintArticles(String searchKeyword) {

		return articleDao.getPrintArticles(searchKeyword);
	}
}
