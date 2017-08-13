package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

public class PairRater implements Rateable {

    @Override
    public boolean test(List<Card> cards) {
        // checks if there is at least one pair of cards with the same value
        int value = -1;
        for (final Card card : cards) {
            if (value == card.getValue()) {
                return true;
            }
            value = card.getValue();
        }
        return false;
    }

    @Override
    public HandRating getRating() {
        return HandRating.PAIR;
    }
}
