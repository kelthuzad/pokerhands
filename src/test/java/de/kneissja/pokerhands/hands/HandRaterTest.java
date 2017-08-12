package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link HandRater}
 * @author kneissja
 */
public class HandRaterTest {

    private Hand createHand(Card... cards) {
        return new Hand(Arrays.asList(cards));
    }

    @Test
    public void handrating() {
        assertEquals(HandRating.HIGH_CARD, new HandRater().rateHand(createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2)));
        assertEquals(HandRating.PAIR, new HandRater().rateHand(createHand(Card.HEARTS_ACE, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2)));
        assertEquals(HandRating.TWO_PAIRS, new HandRater().rateHand(createHand(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2)));
        assertEquals(HandRating.THREE_OF_A_KIND, new HandRater().rateHand(createHand(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_3, Card.HEARTS_2)));
        assertEquals(HandRating.STRAIGHT, new HandRater().rateHand(createHand(Card.HEARTS_4, Card.SPADES_6, Card.DIAMONDS_5, Card.CLUBS_3, Card.HEARTS_2)));
        assertEquals(HandRating.FLUSH, new HandRater().rateHand(createHand(Card.HEARTS_4, Card.HEARTS_6, Card.HEARTS_JACK, Card.HEARTS_3, Card.HEARTS_9)));
        assertEquals(HandRating.FULL_HOUSE, new HandRater().rateHand(createHand(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.HEARTS_3, Card.DIAMONDS_3)));
        assertEquals(HandRating.FOUR_OF_A_KIND, new HandRater().rateHand(createHand(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.CLUBS_4, Card.DIAMONDS_3)));
        assertEquals(HandRating.STRAIGHT_FLUSH, new HandRater().rateHand(createHand(Card.HEARTS_4, Card.HEARTS_5, Card.HEARTS_6, Card.HEARTS_7, Card.HEARTS_8)));
    }
}
