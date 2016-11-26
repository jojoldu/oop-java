package domain;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2016-11-23.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface Player {
    void receiveCard(Card card);

    void showCards();

    List<Card> openCards();

    void setTurnOff(boolean turnOff);

    boolean isTurnOff();
}
