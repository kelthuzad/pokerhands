package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for Flush hands.
 * @author kneissja
 */
class FlushRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {
        // all cards must have the same suit
        final Card firstCard = cards.get(0);
        return cards.stream().allMatch(card -> card.getSuit() == firstCard.getSuit());
    }

    @Override
    public HandRating getRating() {
        return HandRating.FLUSH;
    }
}
