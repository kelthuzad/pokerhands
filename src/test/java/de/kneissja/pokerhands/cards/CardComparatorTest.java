package de.kneissja.pokerhands.cards;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link CardComparator}
 * @author kneissja
 */
public class CardComparatorTest {

    @Test
    public void compareNullInput() {
        assertEquals(0, new CardComparator().compare(null, null));
        assertEquals(-1, new CardComparator().compare(Card.CLUBS_2, null));
        assertEquals(1, new CardComparator().compare(null, Card.DIAMONDS_2));
    }

    @Test
    public void compare() {
        // same values, suits must be ignored
        assertEquals(0, new CardComparator().compare(Card.CLUBS_4, Card.HEARTS_4));
        assertEquals(0, new CardComparator().compare(Card.HEARTS_4, Card.CLUBS_4));

        assertEquals(0, new CardComparator().compare(Card.CLUBS_2, Card.DIAMONDS_2));
        assertEquals(0, new CardComparator().compare(Card.CLUBS_8, Card.SPADES_8));
        assertEquals(0, new CardComparator().compare(Card.DIAMONDS_KING, Card.HEARTS_KING));
        assertEquals(0, new CardComparator().compare(Card.DIAMONDS_KING, Card.SPADES_KING));
        assertEquals(0, new CardComparator().compare(Card.HEARTS_9, Card.SPADES_9));

        // different values, suits must be ignored
        assertEquals(-1, new CardComparator().compare(Card.HEARTS_5, Card.HEARTS_4));
        assertEquals(-1, new CardComparator().compare(Card.HEARTS_ACE, Card.HEARTS_2));
        assertEquals(-1, new CardComparator().compare(Card.HEARTS_5, Card.SPADES_2));

        assertEquals(1, new CardComparator().compare(Card.DIAMONDS_9, Card.CLUBS_10));
        assertEquals(1, new CardComparator().compare(Card.CLUBS_7, Card.DIAMONDS_8));
        assertEquals(1, new CardComparator().compare(Card.SPADES_3, Card.HEARTS_4));
    }

    @Test
    public void compareLists() {
        final List<Card> list = Arrays.asList(Card.SPADES_4, Card.HEARTS_KING, Card.DIAMONDS_8, Card.HEARTS_JACK, Card.SPADES_7);
        list.sort(new CardComparator());
        assertEquals(Card.HEARTS_KING, list.get(0));
        assertEquals(Card.HEARTS_JACK, list.get(1));
        assertEquals(Card.DIAMONDS_8, list.get(2));
        assertEquals(Card.SPADES_7, list.get(3));
        assertEquals(Card.SPADES_4, list.get(4));

        final List<Card> listWithNull = Arrays.asList(Card.DIAMONDS_KING, Card.CLUBS_ACE, Card.HEARTS_2, null, Card.SPADES_7);
        listWithNull.sort(new CardComparator());
        assertEquals(Card.CLUBS_ACE, listWithNull.get(0));
        assertEquals(Card.DIAMONDS_KING, listWithNull.get(1));
        assertEquals(Card.SPADES_7, listWithNull.get(2));
        assertEquals(Card.HEARTS_2, listWithNull.get(3));
        assertEquals(null, listWithNull.get(4));

        final List<Card> listWithEquals = Arrays.asList(Card.SPADES_7, Card.HEARTS_2, Card.DIAMONDS_7);
        listWithEquals.sort(new CardComparator());
        assertEquals(Card.HEARTS_2, listWithEquals.get(2));
    }
}
