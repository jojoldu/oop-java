import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-11-07.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public class Application {
    public static void main(String[] args) {
        System.out.println("========= Blackjack =========");
        Scanner sc = new Scanner(System.in);
        System.out.println("안녕하세요. 게이머님의 이름을 정해주세요.");
        String gamerName = sc.nextLine();
        System.out.println(gamerName+"님 반갑습니다.");
    }

}
