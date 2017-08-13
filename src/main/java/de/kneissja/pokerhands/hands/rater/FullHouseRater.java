package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Full House hands.
 * @author kneissja
 */
class FullHouseRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {
        // Three Of A Kind + Pair required
        return
                // first three cards three of a kind, last two cards pair
               (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(0).getValue() == cards.get(2).getValue() &&
                cards.get(3).getValue() == cards.get(4).getValue()) ||

                // first two cards pair, last three cards three of a kind
               (cards.get(0).getValue() == cards.get(1).getValue() &&
                cards.get(2).getValue() == cards.get(3).getValue() &&
                cards.get(2).getValue() == cards.get(4).getValue());
    }

    @Override
    public HandRating getRating() {
        return HandRating.FULL_HOUSE;
    }
}
