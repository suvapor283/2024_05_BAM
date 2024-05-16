package com.KoreaIT.BAM.service;

import com.KoreaIT.BAM.dao.ArticleDao;
import com.KoreaIT.BAM.dto.Article;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int writeArticle(int memberNum, String title, String content, int viewCnt) {
		return articleDao.writeArticle(memberNum, title, content, viewCnt);
		
	}

	public int getCmdNum(String cmd) {
		return articleDao.getCmdNum(cmd);
	}

	public Article getArticleById(int num) {
		return articleDao.getArticleById(num);
	}

	public void removeArticle(Article foundArticle) {
		articleDao.removeArticle(foundArticle);
	}

	public String getLoginIdByMemberId(int memberId) {
		return articleDao.getLoginIdByMemberId(memberId);
	}


}
