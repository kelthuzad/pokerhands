package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Straight Flush hands.
 * @author kneissja
 */
class StraightFlushRater implements Rateable {

    @Override
    public boolean test(List<Card> cards) {
        Card firstCard = cards.get(0);

        // verify all cards have the same suit
        boolean sameSuit = cards.stream().allMatch(card -> card.getSuit() == firstCard.getSuit());
        if (!sameSuit) {
            return false;
        }

        // verify all cards have consecutive values
        int value = firstCard.getValue();
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
        return HandRating.STRAIGHT_FLUSH;
    }
}
