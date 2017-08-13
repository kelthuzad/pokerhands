package de.kneissja.pokerhands;

import de.kneissja.pokerhands.hands.Hand;

/**
 * Service that provides access to the functionality of the program
 */
public class PokerHandsService {

    /**
     * Rates all pokerhands and returns Hand with the highest rank
     * @param hand1 the first poker hand
     * @param hand2 the second poker hand
     * @return the Hand with the highest rank. Null if both hands are equally high
     */
    public Hand findHighestPokerhand(Hand hand1, Hand hand2) {
        int compare = hand1.compareTo(hand2);
        if (compare == 0) {
            return null;
        }
        return compare > 0 ? hand1 : hand2;
    }
}
