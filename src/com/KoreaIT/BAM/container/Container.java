package com.KoreaIT.BAM.container;

import com.KoreaIT.BAM.dao.ArticleDao;
import com.KoreaIT.BAM.dao.MemberDao;
import com.KoreaIT.BAM.service.ArticleService;
import com.KoreaIT.BAM.service.MemberService;

public class Container {
	
	public static MemberDao memberDao;
	public static ArticleDao articleDao;
	public static MemberService memberService;
	public static ArticleService articleService;
	
	static {
		memberDao = new MemberDao();
		articleDao = new ArticleDao();
		memberService = new MemberService();
		articleService = new ArticleService();
	}
}
