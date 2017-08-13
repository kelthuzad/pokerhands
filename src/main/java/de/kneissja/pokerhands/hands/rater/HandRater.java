package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Rates the poker hands.
 * @author kneissja
 */
public class HandRater {

    /**
     * Returns the rating of the poker hand
     * @param cards to be rated
     * @return rating of the hand
     */
    public HandRating rateHand(final List<Card> cards) {
        return HandRating.UNKNOWN;
    }
}
