package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;

import java.util.List;

/**
 * Represents a Straight Flush hand.
 * @author kneissja
 */
class StraightFlushHand extends Hand {
    /**
     * Creates a straight flush hand
     * @param cards  All cards in the hand. Must be exactly HAND_SIZE cards
     */
    StraightFlushHand(List<Card> cards) {
        super(cards, HandRating.STRAIGHT_FLUSH);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);

        if (superCompare != 0) {
            return superCompare;
        }

        // the highest card wins
        final int thisHighestValue = getCards().get(0).getValue();
        final int otherHighestValue = otherHand.getCards().get(0).getValue();
        return Integer.compare(thisHighestValue, otherHighestValue);
    }
}
