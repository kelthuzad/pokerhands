package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import java.util.List;

/**
 * Represents a Full House.
 * @author kneissja
 */
public class FullHouseHand extends Hand {

    /**
     * Creates a new poker hand.
     * @param cards  All cards in the hand, ordered by card value in descending order
     */
    FullHouseHand(List<Card> cards) {
        super(cards, HandRating.FULL_HOUSE);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);

        if (superCompare != 0) {
            return superCompare;
        }

        // the higher three of a kind value wins
        int thisThreeOfAKindValue = findThreeOfAKindValue(getCards());
        int otherThreeOfAKindValue = findThreeOfAKindValue(otherHand.getCards());

        return Integer.compare(thisThreeOfAKindValue, otherThreeOfAKindValue);
    }

    private int findThreeOfAKindValue(List<Card> cards) {
        boolean pairFound = false;
        int value = -1;
        for (final Card card : cards) {
            if (value == card.getValue()) {
                if (pairFound) { // if pair was already found, this is the third
                    return value;
                }
                pairFound = true;
            } else {
                pairFound = false;
            }
            value = card.getValue();
        }
        throw new IllegalStateException("Three Of A Kind value not found");
    }
}
