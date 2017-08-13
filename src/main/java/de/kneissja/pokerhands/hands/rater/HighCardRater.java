package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.List;

/**
 * Checks for high card hands.
 * @author kneissja
 */
public class HighCardRater implements Rateable {
    @Override
    public boolean test(List<Card> cards) {
        return true; // high card is always valid
    }

    @Override
    public HandRating getRating() {
        return HandRating.HIGH_CARD;
    }
}
