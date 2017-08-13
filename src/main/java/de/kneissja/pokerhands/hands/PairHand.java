package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import java.util.List;

/**
 * Represents a Pair hand.
 * @author kneissja
 */
public class PairHand extends Hand {

    /**
     * Creates a new poker hand.
     * @param cards  All cards in the hand, ordered by card value in descending order
     */
    PairHand(List<Card> cards) {
        super(cards, HandRating.PAIR);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);
        if (superCompare != 0) {
            return superCompare;
        }

        // the hand with the highest pair wins
        int thisPairValue = findPairValue(getCards());
        int otherPairValue = findPairValue(otherHand.getCards());
        if (thisPairValue != otherPairValue) {
            return Integer.compare(thisPairValue, otherPairValue);
        }

        // compare values of non-pair cards
        List<Card> otherHandCards = otherHand.getCards();
        for (int i = 0; i < getCards().size(); i++) {
            final int thisValue = getCards().get(i).getValue();
            final int otherValue = otherHandCards.get(i).getValue();

            if (thisValue != otherValue) {
                return Integer.compare(thisValue, otherValue);
            }
        }
        return 0;
    }

    private int findPairValue(List<Card> cards) {
        int value = -1;
        for (final Card card : cards) {
            if (value == card.getValue()) {
                return value;
            }
            value = card.getValue();
        }
        throw new IllegalStateException("No Pair could be found!");
    }
}
