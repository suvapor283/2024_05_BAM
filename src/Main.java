import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		List<Article> articles = new ArrayList<>();

		int lastArticleid = 1;

		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String content = sc.nextLine();

				Article article = new Article(lastArticleid, title, content);
				articles.add(article);

				System.out.println(lastArticleid + "번 글이 생성되었습니다.");
				lastArticleid++;
			}
			
			else if(cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				} 
				
				Article foundArticle = null;

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				
				System.out.printf("수정할 내용 : ");
				String content = sc.nextLine();
				
				foundArticle.title = title;
				foundArticle.content = content;
				System.out.println(id + "번 게시물이 수정되었습니다.");
			}

			else if(cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				} 
				
				Article foundArticle = null;

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
//				int foundIndex = -1;
				
//				int indexId = 0;
//				
//				for (Article article : articles) {
//					if (article.id == id) {
//						foundIndex = indexId;
//						break;
//					}
//					indexId++;
//				}
//				
//				for (int i = 0; i < articles.size(); i++) {
//					Article article = articles.get(i);
//					if (article.id == id) {
//						foundIndex = i;
//						break;
//					}
//				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				articles.remove(foundArticle);
//				articles.remove(foundIndex);
				System.out.println(id + "번 게시물이 삭제되었습니다.");
			}
			
			
			else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				} 
				
				Article foundArticle = null;

				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}

				System.out.println("번호 : " + foundArticle.id);
				System.out.println("날짜 : ~~~");
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.content);

			}
			
			else if (cmd.equals("article list")) {
				if (articles.isEmpty()) {
					System.out.println("존재하는 게시글이 없습니다.");
					continue;
				}

				System.out.println("번호 | 제목 | 내용");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.println(article.id + " | " + article.title + " | " + article.content);
				}

			}

			else if (cmd.equals("exit")) {
				break;
			}

			else if (cmd.equals("")) {
				System.out.println("명령어를 입력해주세요.");
			}

			else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}
		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}

class Article {
	int id;
	String title;
	String content;

	Article(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}