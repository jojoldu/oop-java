import domain.Card;
import domain.CardDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 2016-12-09.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class ApplicationTest {

    private CardDeck cardDeck;
    private List<Card> cards;

    @Before
    public void setup() {
        cardDeck = new CardDeck();
        cards = cardDeck.getCards();
    }

    @Test
    public void test_카드패턴비교 () {
        assertThat(cards.get(0).getPattern(), is(Card.Pattern.SPADE));
        assertThat(cards.get(13).getPattern(), is(Card.Pattern.HEART));
    }

    @Test
    public void test_카드끗수비교 () {
        assertThat(cards.get(0).getDenomination(), is(Card.Denomination.ACE));
        assertThat(cards.get(0).getDenomination().getPoint(), is(1));
    }

    @Test
    public void test_List를Stack으로변환() {
        assertThat(cardDeck.getCards().size(), is(52));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(51));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(50));
        cardDeck.draw();
        assertThat(cardDeck.getCards().size(), is(49));
    }
}
