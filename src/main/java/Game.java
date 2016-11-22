import domain.*;

import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-11-17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class Game {
    private static final int INIT_CARD_COUNT = 2;

    public void play(){
        System.out.println("========= Blackjack =========");
        Scanner sc = new Scanner(System.in);

        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        playingPhase(sc, cardDeck, gamer);
    }

    private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer) {
        String gamerInput;
        while(true){
            System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
            gamerInput = sc.nextLine();

            if("0".equals(gamerInput)) {
                break;
            }

            Card card = cardDeck.draw();
            gamer.receiveCard(card);
            gamer.showCards();
        }
    }

    private void initPhase(CardDeck cardDeck, Gamer gamer){
        for(int i=0;i<INIT_CARD_COUNT;i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
        }
    }
}
