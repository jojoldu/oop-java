package domain;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-11-17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class Rule {

    public Player getWinner(List<Player> players){
        Player highestPlayer = null;
        int highestPoint = 0;

        for(Player player : players) {
            int playerPointSum = getPointSum(player.openCards());
            if(playerPointSum > highestPoint){
                highestPlayer = player;
                highestPoint = playerPointSum;
            }
        }

        return highestPlayer;
    }

    private int getPointSum (List<Card> cards) {
        int sum = 0;

        for(Card card : cards) {
            sum += card.getDenomination().getPoint();
        }

        return sum;
    }
}
