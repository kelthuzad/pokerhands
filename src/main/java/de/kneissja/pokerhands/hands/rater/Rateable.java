package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;
import java.util.function.Predicate;

/**
 * Common interface of all rating classes
 * @author kneissja
 */
interface Rateable extends Predicate<List<Card>> {

    /**
     * Checks if the given hand matches the criteria of the rating.
     * @param cards the cards to check
     * @return true, if the cards in the hand match the rating of the Rater
     */
    @Override
    boolean test(List<Card> cards);

    /**
     * Returns the rating of the current Rateable.
     * @return Rating of the hand, if it matches this Rateable
     */
    HandRating getRating();
}
