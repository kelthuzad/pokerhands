package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.rater.HandRater;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link HandRater}
 * @author kneissja
 */
public class HandRaterTest {
    @Test
    public void StraightFlush() {
        assertEquals(HandRating.STRAIGHT_FLUSH, new HandRater().rateHand(Arrays.asList(Card.HEARTS_8, Card.HEARTS_7, Card.HEARTS_6, Card.HEARTS_5, Card.HEARTS_4)));
    }

    @Test
    public void HighCard() {
        assertEquals(HandRating.HIGH_CARD, new HandRater().rateHand(Arrays.asList(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2)));
    }

    @Test
    public void Pair() {
        assertEquals(HandRating.PAIR, new HandRater().rateHand(Arrays.asList(Card.HEARTS_ACE, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2)));
    }

    @Test
    public void TwoPairs() {
        assertEquals(HandRating.TWO_PAIRS, new HandRater().rateHand(Arrays.asList(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2)));
    }

    @Test
    public void ThreeOfAKind() {
        assertEquals(HandRating.THREE_OF_A_KIND, new HandRater().rateHand(Arrays.asList(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_3, Card.HEARTS_2)));
    }

    @Test
    public void Straight() {
        assertEquals(HandRating.STRAIGHT, new HandRater().rateHand(Arrays.asList(Card.SPADES_6, Card.DIAMONDS_5, Card.HEARTS_4, Card.CLUBS_3, Card.HEARTS_2)));
    }

    @Test
    public void Flush() {
        assertEquals(HandRating.FLUSH, new HandRater().rateHand(Arrays.asList(Card.HEARTS_4, Card.HEARTS_6, Card.HEARTS_JACK, Card.HEARTS_3, Card.HEARTS_9)));
    }

    @Test
    public void FullHouse() {
        assertEquals(HandRating.FULL_HOUSE, new HandRater().rateHand(Arrays.asList(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.HEARTS_3, Card.DIAMONDS_3)));
    }

    @Test
    public void FourOfAKind() {
        assertEquals(HandRating.FOUR_OF_A_KIND, new HandRater().rateHand(Arrays.asList(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.CLUBS_4, Card.DIAMONDS_3)));

    }
}
