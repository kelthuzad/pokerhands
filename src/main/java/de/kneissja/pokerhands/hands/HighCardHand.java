package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;

import java.util.List;

/**
 * Represents a High Card hand
 * @author kneissja
 */
public class HighCardHand extends Hand {
    /**
     * Creates a high card hand
     * @param cards  All cards in the hand, ordered by card value in descending order
     */
    HighCardHand(List<Card> cards) {
        super(cards, HandRating.HIGH_CARD);
    }

    @Override
    public int compareTo(Hand otherHand) {
        int superCompare = super.compareTo(otherHand);

        if (superCompare != 0) {
            return superCompare;
        }

        // compare first cards of both hands, if equal second cards and so on
        List<Card> otherHandCards = otherHand.getCards();
        for (int i = 0; i < getCards().size(); i++) {
            final Card thisCard = getCards().get(i);
            final Card otherCard = otherHandCards.get(i);
            if (thisCard.getValue() != otherCard.getValue()) {
                return thisCard.getValue() > otherCard.getValue() ? 1 : -1;
            }
        }
        return 0;
    }
}
