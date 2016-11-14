import domain.Player;

import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-11-07.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public class Application {
    public static void main(String[] args) {
        System.out.println("========= Play Game =========");
        Scanner sc = new Scanner(System.in);
        Player player = null;

        while(true) {
            System.out.println("신규케릭 생성을 원하면 1, \n기존 케릭을 사용하려면 2를 입력하세요");
            String select = sc.nextLine();

            if("1".equals(select)) {
                while (true) {
                    System.out.println("케릭터의 이름을 정해주세요");
                    String name = sc.nextLine();

                    if(name != null && !name.trim().equals("")){
                        player = new Player(name);
                        break;
                    }

                    System.out.println("잘못된 이름입니다. 다시 입력해주세요.");
                }
                break;
            } else if("2".equals(select)) {
                System.out.println("기존 케릭터 이름을 입력해주세요.");
                String name = sc.nextLine();
                System.out.println("기존 케릭명 : "+ name);
                break;
            } else {
                System.out.println("1 혹은 2만 입력 가능합니다.\n다시 입력해주세요");
            }
        }

        while (true) {

            System.out.println(player.getName()+"님 환영합니다.");
            System.out.println("exit를 입력하면 종료됩니다.");

            String input = sc.nextLine();
            if (input.equals("exit")) {
                System.out.println("종료합니다.");
                break;
            }


        }
    }
}
