package com.KoreaIT.BAM.dao;

import java.util.List;

import com.KoreaIT.BAM.Util.Util;
import com.KoreaIT.BAM.container.Container;
import com.KoreaIT.BAM.dto.Article;
import com.KoreaIT.BAM.dto.Member;

public class ArticleDao {
	
	private List<Article> articles;
	private List<Member> members;
	private int lastNum;
	
	public ArticleDao() {
		this.articles = Container.articles;
		this.members = Container.members;
		this.lastNum = 1;
	}

	public int writeArticle(int memberNum, String title, String content, int viewCnt) {
		articles.add(new Article(lastNum, Util.getDateStr(), memberNum, title, content, viewCnt));
		return lastNum++;
	}

	public int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int num = 0;

		try {
			num = Integer.parseInt(cmdBits[2]);
			return num;
		} catch (NumberFormatException e) {
			return 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

	public Article getArticleById(int num) {
		for (Article article : articles) {
			if (article.getNum() == num) {
				return article;
			}
		}
		return null;
	}

	public void removeArticle(Article foundArticle) {
		articles.remove(foundArticle);	
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
