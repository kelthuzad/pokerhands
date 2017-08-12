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
     * Number of cards in a hand
     */
    private static final int HAND_SIZE = 5;

    /**
     * Creates a new poker hand.
     * @param cards All cards in the hand. Must be exactly HAND_SIZE cards
     */
    public Hand(final Collection<Card> cards) {
        verifyCards(cards);
        this.cards = new ArrayList<Card>(cards);
        this.cards.sort(new CardComparator());
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

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

}
