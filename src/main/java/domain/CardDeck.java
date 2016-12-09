package domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jojoldu@gmail.com on 2016-11-17.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class CardDeck{
    private Stack<Card> cards;

    public CardDeck() {
        this.cards = this.generateCards();
        Collections.shuffle(this.cards);
    }

    private Stack<Card> generateCards() {
        Stack<Card> cards = new Stack<>();

        for(Card.Pattern pattern : Card.Pattern.values()){
            for(Card.Denomination denomination : Card.Denomination.values()){
                Card card = new Card(pattern, denomination);
                cards.push(card);
            }
        }
        return cards;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public Card draw(){
        return this.cards.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Card card : cards){
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
