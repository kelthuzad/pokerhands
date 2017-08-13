package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Straight hands.
 * @author kneissja
 */
class StraightRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {

        // verify all cards are in consecutive order
        int value = cards.get(0).getValue();
        for (Card card : cards) {
            if (card.getValue() != value) {
                return false;
            }
            value--; // cards are sorted in descending order
        }
        return true;
    }

    @Override
    public HandRating getRating() {
        return HandRating.STRAIGHT;
    }
}
