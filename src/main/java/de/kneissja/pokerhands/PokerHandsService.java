package de.kneissja.pokerhands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.Hand;
import de.kneissja.pokerhands.hands.PokerhandFactory;

import java.util.Collection;

/**
 * Service that provides access to the functionality of the program
 */
public class PokerHandsService {

    private final PokerhandFactory pokerhandFactory = new PokerhandFactory();

    /**
     * Rates all pokerhands and returns Hand with the highest rank
     * @param hand1Cards the first poker hand
     * @param hand2Cards the second poker hand
     * @return the Hand with the highest rank. Null if both hands are equally high
     */
    public Hand findHighestPokerhand(final Collection<Card> hand1Cards, final Collection<Card> hand2Cards) {
        final Hand hand1 = pokerhandFactory.createHand(hand1Cards);
        final Hand hand2 = pokerhandFactory.createHand(hand2Cards);
        return findHighestPokerhand(hand1, hand2);
    }

    /**
     * Rates all pokerhands and returns Hand with the highest rank
     * @param hand1 the first poker hand
     * @param hand2 the second poker hand
     * @return the Hand with the highest rank. Null if both hands are equally high
     */
    public Hand findHighestPokerhand(final Hand hand1, final Hand hand2) {
        int compare = hand1.compareTo(hand2);
        if (compare == 0) {
            return null;
        }
        return compare > 0 ? hand1 : hand2;
    }
}
