package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.cards.CardComparator;

import java.util.*;

/**
 * Represents the poker hand
 * @author kneissja
 */
public class Hand {
    /**
     * All cards in this hand
     */
    private List<Card> cards;

    /**
     * Rating of the hand
     */
    private HandRating rating;

    /**
     * Number of cards in a hand
     */
    private static final int HAND_SIZE = 5;

    /**
     * Creates a new poker hand.
     * @param cards All cards in the hand. Must be exactly HAND_SIZE cards
     */
    public Hand(final Collection<Card> cards) {
        verifyCards(cards);
        this.cards = new ArrayList<>(cards);
        this.cards.sort(new CardComparator());
        rating = new HandRater().rateHand(this);
    }

    private void verifyCards(final Collection<Card> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Input may not be null");
        }

        if (cards.size() != HAND_SIZE) {
            throw new IllegalArgumentException("Wrong number of cards in the hand: "+cards.size()+", must be "+HAND_SIZE);
        }

        // add cards to HashSet to remove duplicate cards from the collection
        HashSet<Card> cardHashSet = new HashSet<>(cards);
        if (cardHashSet.size() != HAND_SIZE) {
            throw new IllegalArgumentException("Input contains duplicate card(s)");
        }
    }

    /**
     * Returns an unmodifiable list containing the sorted cards of this hand
     * @return list with descending sorted cards
     */
    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

}
