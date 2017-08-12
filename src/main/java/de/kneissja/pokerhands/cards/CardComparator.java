package de.kneissja.pokerhands.cards;

import java.util.Comparator;

/**
 * Compares {@link Card} by value.
 * Cards will be sorted descending.
 * @author kneissja
 */
public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        if (card1 == null && card2 == null) {
            return 0;
        }

        if (card1 == null) {
            return 1;
        }

        if (card2 == null) {
            return -1;
        }

        if (card1.getValue() == card2.getValue()) {
            return 0;
        }

        return card1.getValue() > card2.getValue() ? -1 : 1;
    }
}
