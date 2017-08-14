package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import org.junit.Test;

/**
 * Basic tests for {@link PokerhandFactory}
 */
public class PokerhandFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        new PokerhandFactory().createHand(null, null, null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughCards() {
        new PokerhandFactory().createHand(Card.HEARTS_5, Card.HEARTS_2, Card.HEARTS_7, Card.HEARTS_4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToManyCards() {
        new PokerhandFactory().createHand(Card.HEARTS_5, Card.HEARTS_2, Card.HEARTS_7,
                Card.HEARTS_4, Card.HEARTS_6, Card.HEARTS_QUEEN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicateCard() {
        new PokerhandFactory().createHand(Card.HEARTS_5, Card.HEARTS_5, Card.HEARTS_7,
                Card.HEARTS_4, Card.HEARTS_6);
    }
}
