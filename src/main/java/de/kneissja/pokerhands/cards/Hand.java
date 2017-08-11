package de.kneissja.pokerhands.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Represents the poker hand
 */
public class Hand {
    private List<Card> cards;

    public Hand(final Collection<Card> cards) {
        this.cards = new ArrayList<Card>(cards);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: implement by comparing cards
        return super.equals(obj);
    }
}
