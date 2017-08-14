package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;

import java.util.*;

/**
 * Represents the poker hand
 * @author kneissja
 */
public abstract class Hand implements Comparable<Hand> {
    /**
     * All cards in this hand
     */
    private final List<Card> cards;

    /**
     * Rating of the hand
     */
    private HandRating rating;

    /**
     * Creates a new poker hand.
     * @param cards All cards in the hand, ordered by card value in descending order
     * @param rating The rating of the hand
     */
    Hand(final List<Card> cards, final HandRating rating) {
        this.rating = rating;
        this.cards = cards;
    }

    /**
     * Returns an unmodifiable list containing the sorted cards of this hand
     * @return list with descending sorted cards
     */
    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    /**
     * Returns the rating of the hand
     * @return rating of this hand
     */
    public HandRating getRating() {
        return rating;
    }

    /**
     * Compares the hand with another hand.
     * @param otherHand hand to compare with
     * @return 1, 0 or -1 if this hand is higher, equal or lower than the other hand
     */
    @Override
    public int compareTo(Hand otherHand) {
        if (otherHand == null) {
            return 1;
        }

        return getRating().compareTo(otherHand.getRating());
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null &&
               obj instanceof Hand &&
               getCards().equals(((Hand) obj).getCards()) &&
               getRating().equals(((Hand)obj).getRating());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getCards(), getRating());
    }

    @Override
    public String toString() {
        return "Hand consisting of "+getCards()+" => "+getRating();
    }
}
