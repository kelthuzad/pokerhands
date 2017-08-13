package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Four Of A Kind hands.
 * @author kneissja
 */
class FourOfAKindRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {
        // four cards of the same kind required
        return (cards.get(0).getValue() == cards.get(3).getValue()) ||  // first 4 cards equal
               (cards.get(1).getValue() == cards.get(4).getValue());    // last 4 cards equal
    }

    @Override
    public HandRating getRating() {
        return HandRating.FOUR_OF_A_KIND;
    }
}
