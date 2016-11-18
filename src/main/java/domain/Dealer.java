package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-11-17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class Dealer {
    private List<Card> cards;

    public Dealer() {
        cards = new ArrayList<>();
    }

    public void receiveCard(Card card) {}

    public int getCurrentPoint(){
        int pointSum = 0;
        int aceCount = 0;
        for(Card card : cards) {
            String denomination = card.getDenomination();

            if("A".equals(denomination)){
                aceCount +=1;
            }else if("J".equals(denomination) || "Q".equals(denomination) || "K".equals(denomination)) {
                pointSum += 10;
            }else {
                pointSum += Integer.parseInt(denomination);
            }
        }

        if(aceCount > 0) {
            for(int i=0; i<aceCount; i++) {

            }
        }

        return pointSum;
    }

    public List<Card> openCards(){
        return null;
    }
}
