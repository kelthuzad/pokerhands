package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;

import java.util.List;

/**
 * Represents a Straight hand.
 * @author kneissja
 */
public class StraightHand extends Hand {

    /**
     * Creates a new poker hand.
     * @param cards  All cards in the hand, ordered by card value in descending order
     */
    StraightHand(List<Card> cards) {
        super(cards, HandRating.STRAIGHT);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);

        if (superCompare != 0) {
            return superCompare;
        }

        // highest card wins
        final int thisHighestValue = getCards().get(0).getValue();
        final int otherHighestValue = otherHand.getCards().get(0).getValue();
        return Integer.compare(thisHighestValue, otherHighestValue);
    }
}
