package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import java.util.List;
import java.util.Optional;

/**
 * Represents a Two Pair hand.
 * @author kneissja
 */
public class TwoPairHand extends Hand {

    /**
     * Creates a new poker hand.
     * @param cards  All cards in the hand, ordered by card value in descending order
     */
    TwoPairHand(List<Card> cards) {
        super(cards, HandRating.TWO_PAIRS);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);
        if (superCompare != 0) {
            return superCompare;
        }

        // the highest pair wins
        int thisHighPairValue = findPairValue(getCards());
        int otherHighPairValue = findPairValue(otherHand.getCards());
        if (thisHighPairValue != otherHighPairValue) {
            return thisHighPairValue > otherHighPairValue ? 1 : -1;
        }

        // highest pairs are equal, compare lower pair
        // cards are sorted by low pair can only be in last 3 cards
        int thisLowPairValue = findPairValue(getCards().subList(2,5));
        int otherLowPairValue = findPairValue(otherHand.getCards().subList(2,5));

        if (thisLowPairValue != otherLowPairValue) {
            return thisLowPairValue > otherLowPairValue ? 1 : -1;
        }

        // both pairs are equal, compare the single card
        int thisSingleCardValue = findSingleCardValue(getCards(), thisHighPairValue, thisLowPairValue);
        int otherSingleCardValue = findSingleCardValue(otherHand.getCards(), otherHighPairValue, otherLowPairValue);

        return Integer.compare(thisSingleCardValue, otherSingleCardValue);
    }

    private int findSingleCardValue(List<Card> cards, int highPairValue, int lowPairValue) {
        Optional<Card> singleCard = cards.stream().filter(card -> card.getValue() != highPairValue &&
                                                                  card.getValue() != lowPairValue).findFirst();
        if (!singleCard.isPresent()) {
            throw new IllegalStateException("Single card not found");
        }
        return singleCard.get().getValue();
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
