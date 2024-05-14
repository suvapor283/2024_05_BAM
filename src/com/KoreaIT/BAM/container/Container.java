package com.KoreaIT.BAM.container;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.BAM.dto.Article;
import com.KoreaIT.BAM.dto.Member;

public class Container {
	
	public static List<Member> members;
	public static List<Article> articles;
		
	static {
		members = new ArrayList<>();
		articles = new ArrayList<>();
	}
}
