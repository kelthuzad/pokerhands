package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Three Of A Kind hands.
 * @author kneissja
 */
class ThreeOfAKindRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {

        // check for three cards with the same value
        boolean pairFound = false;
        int value = -1;
        for (final Card card : cards) {
            if (value == card.getValue()) {
                if (pairFound) { // if pair was already found, this is the third
                    return true;
                }
                pairFound = true;
            } else {
                pairFound = false;
            }
            value = card.getValue();
        }
        return false;
    }

    @Override
    public HandRating getRating() {
        return HandRating.THREE_OF_A_KIND;
    }
}
