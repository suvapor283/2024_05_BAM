import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		List<Article> articles = new ArrayList<>();
		
		int num = 1;

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

				Article article = new Article(num, title, content);
				articles.add(article);

				System.out.println(num + "번 글이 생성되었습니다.");
				num++;
			}

			else if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다.");
			}

			else if (cmd.equals("")) {
				System.out.println("명령어를 입력해주세요.");
			}

			else if (cmd.equals("exit")) {
				break;
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
	int num;
	String title;
	String content;
	
	Article(int num, String title, String content){
		this.num = num;
		this.title = title;
		this.content = content;
	}
}