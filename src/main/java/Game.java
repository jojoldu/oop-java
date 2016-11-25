import domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-11-17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class Game {
    private static final int INIT_RECEIVE_CARD_COUNT = 2;
    private static final String STOP_RECEIVE_CARD = "0";

    public void play(){
        System.out.println("========= Blackjack =========");
        Scanner sc = new Scanner(System.in);
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        List<Player> players = Arrays.asList(new Gamer(), new Dealer());
        initPhase(cardDeck, players);
        playingPhase(sc, cardDeck, players);
    }

    private void playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
        while(true){
            boolean isAllPlayerTurnOff = receiveCardAllPlayers(sc, cardDeck, players);

            if(isAllPlayerTurnOff){
                break;
            }
        }
    }

    private boolean receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
        boolean isAllPlayerTurnOff = true;

        for(Player player : players) {

            if(isReceiveCard(sc)) {
                isAllPlayerTurnOff = true;
            }else{
                Card card = cardDeck.draw();
                player.receiveCard(card);
                player.showCards();
                isAllPlayerTurnOff = false;
            }
        }

        return isAllPlayerTurnOff;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
        return STOP_RECEIVE_CARD.equals(sc.nextLine());
    }

    private void initPhase(CardDeck cardDeck, List<Player> players){
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i = 0; i< INIT_RECEIVE_CARD_COUNT; i++) {
            for(Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }
    }
}
