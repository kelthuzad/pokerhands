package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;

import java.util.List;

/**
 * Represents a Four Of A Kind hand.
 * @author kneissja
 */
public class FourOfAKindHand extends Hand {
    /**
     * Creates a new poker hand.
     * @param cards All cards in the hand, ordered by card value in descending order
     */
    FourOfAKindHand(List<Card> cards) {
        super(cards, HandRating.FOUR_OF_A_KIND);
    }
}
