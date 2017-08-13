package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Two Pair hands.
 * @author kneissja
 */
class TwoPairRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {
        // check for two pairs of cards with the same values
        int pairCount = 0;
        int value = -1;
        for (final Card card : cards) {
            if (value == card.getValue()) {
                pairCount++;
                value = -1;
            }
            value = card.getValue();
        }
        return pairCount == 2;
    }

    @Override
    public HandRating getRating() {
        return HandRating.TWO_PAIRS;
    }
}
