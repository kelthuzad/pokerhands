package de.kneissja.pokerhands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.Hand;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class PokerHandsServiceTest {

    private Hand createHand(Card... cards) {
        return new Hand(Arrays.asList(cards));
    }

    @Test
    public void findHighestHand_Highcard() {
        PokerHandsService service = new PokerHandsService();

        // highest card wins
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_ACE, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // highest card wins although all other cards are lower
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_KING, Card.SPADES_9, Card.CLUBS_6, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_3, Card.DIAMONDS_ACE, Card.SPADES_8, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // highest 2 cards have the same value, 3rd highest card wins
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_7, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // both hands equal
        final Hand hand4_equal1 = createHand(Card.SPADES_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_equal2 = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.HEARTS_6, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(null, service.findHighestPokerhand(hand4_equal1, hand4_equal2));
        assertEquals(null, service.findHighestPokerhand(hand4_equal2, hand4_equal1));
    }

    @Test
    public void findHighestHand_Pair() {
        PokerHandsService service = new PokerHandsService();

        // pair wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_ACE, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // highest pair wins
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_KING, Card.SPADES_8, Card.CLUBS_8, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_3, Card.DIAMONDS_ACE, Card.SPADES_9, Card.CLUBS_9, Card.HEARTS_2);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // equal pair, highest card wins
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_9, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_JACK, Card.HEARTS_2);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // both hands equal pairs
        final Hand hand4_equal1 = createHand(Card.SPADES_KING, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_equal2 = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.HEARTS_8, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(null, service.findHighestPokerhand(hand4_equal1, hand4_equal2));
        assertEquals(null, service.findHighestPokerhand(hand4_equal2, hand4_equal1));
    }

    @Test
    public void findHighestHand_TwoPair() {
        PokerHandsService service = new PokerHandsService();

        // two pair wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_6, Card.HEARTS_2);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // two pair wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_KING, Card.SPADES_8, Card.CLUBS_8, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_3, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_2, Card.HEARTS_2);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // highest two pair wins
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_8, Card.CLUBS_8, Card.HEARTS_2);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // equal two pairs, highest card wins
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.SPADES_8, Card.HEARTS_8, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_8, Card.CLUBS_8, Card.HEARTS_5);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // both hands equal two pairs
        final Hand hand4_equal1 = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.SPADES_8, Card.HEARTS_8, Card.HEARTS_2);
        final Hand hand4_equal2 = createHand(Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_8, Card.DIAMONDS_8, Card.SPADES_2);
        assertEquals(null, service.findHighestPokerhand(hand4_equal1, hand4_equal2));
        assertEquals(null, service.findHighestPokerhand(hand4_equal2, hand4_equal1));
    }

    @Test
    public void findHighestHand_ThreeOfAKind() {
        PokerHandsService service = new PokerHandsService();

        // three of a kind wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_8, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_3, Card.HEARTS_2);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // three of a kind wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_2, Card.SPADES_5, Card.CLUBS_8, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_3, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_4, Card.HEARTS_2);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // three of a kind wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.HEARTS_JACK, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_8, Card.HEARTS_2);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // higher three of a kind wins
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_4, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.HEARTS_JACK, Card.SPADES_8, Card.DIAMONDS_8, Card.CLUBS_8, Card.SPADES_2);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // two equal three of a kind is not possible
    }

    @Test
    public void findHighestHand_Straight() {
        PokerHandsService service = new PokerHandsService();

        // straight wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.DIAMONDS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_4, Card.SPADES_6, Card.DIAMONDS_5, Card.CLUBS_3, Card.HEARTS_2);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // straight wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_2, Card.SPADES_4, Card.CLUBS_8, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_7, Card.DIAMONDS_8, Card.SPADES_9, Card.CLUBS_10, Card.HEARTS_JACK);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // straight wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.HEARTS_JACK, Card.SPADES_8, Card.DIAMONDS_9, Card.CLUBS_10, Card.HEARTS_7);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // straight wins against three of a kind
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_KING, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // higher straight wins
        final Hand hand5_lower = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand5_higher = createHand(Card.HEARTS_7, Card.CLUBS_8, Card.DIAMONDS_9, Card.SPADES_10, Card.HEARTS_JACK);
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_lower, hand5_higher));
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_higher, hand5_lower));

        // equal straights
        final Hand hand6_equal1 = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand6_equal2 = createHand(Card.SPADES_5, Card.HEARTS_6, Card.CLUBS_7, Card.DIAMONDS_8, Card.DIAMONDS_9);
        assertEquals(null, service.findHighestPokerhand(hand6_equal1, hand6_equal2));
        assertEquals(null, service.findHighestPokerhand(hand6_equal2, hand6_equal1));
    }

    @Test
    public void findHighestHand_Flush() {
        PokerHandsService service = new PokerHandsService();

        // flush wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.DIAMONDS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_4, Card.HEARTS_6, Card.HEARTS_JACK, Card.HEARTS_3, Card.HEARTS_9);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // flush wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_8, Card.HEARTS_QUEEN);
        final Hand hand2_higher = createHand(Card.HEARTS_4, Card.HEARTS_6, Card.HEARTS_JACK, Card.HEARTS_3, Card.HEARTS_9);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // flush wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.SPADES_10, Card.SPADES_2, Card.SPADES_8, Card.SPADES_6, Card.SPADES_ACE);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // flush wins against three of a kind
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_KING, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.DIAMONDS_9, Card.DIAMONDS_3, Card.DIAMONDS_8, Card.DIAMONDS_JACK, Card.DIAMONDS_4);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // flush wins against straight
        final Hand hand5_lower = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand5_higher = createHand(Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_4, Card.CLUBS_ACE, Card.CLUBS_10);
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_lower, hand5_higher));
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_higher, hand5_lower));

        // higher flush wins
        final Hand hand6_lower = createHand(Card.HEARTS_5, Card.HEARTS_QUEEN, Card.HEARTS_KING, Card.HEARTS_6, Card.HEARTS_9);
        final Hand hand6_higher = createHand(Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_4, Card.CLUBS_ACE, Card.CLUBS_10);
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_lower, hand6_higher));
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_higher, hand6_lower));

        // equal flushes
        final Hand hand6_equal1 = createHand(Card.HEARTS_5, Card.HEARTS_QUEEN, Card.HEARTS_KING, Card.HEARTS_6, Card.HEARTS_9);
        final Hand hand6_equal2 = createHand(Card.CLUBS_5, Card.CLUBS_QUEEN, Card.CLUBS_KING, Card.CLUBS_6, Card.CLUBS_9);
        assertEquals(null, service.findHighestPokerhand(hand6_equal1, hand6_equal2));
        assertEquals(null, service.findHighestPokerhand(hand6_equal2, hand6_equal1));
    }

    @Test
    public void findHighestHand_FullHouse() {
        PokerHandsService service = new PokerHandsService();

        // full house wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_4, Card.DIAMONDS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.HEARTS_3, Card.DIAMONDS_3);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // full house wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_8, Card.HEARTS_7);
        final Hand hand2_higher = createHand(Card.CLUBS_QUEEN, Card.HEARTS_QUEEN, Card.DIAMONDS_QUEEN, Card.CLUBS_6, Card.HEARTS_6);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // full house wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.SPADES_10, Card.HEARTS_10, Card.CLUBS_10, Card.CLUBS_JACK, Card.HEARTS_JACK);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // full house wins against three of a kind
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_KING, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.SPADES_5, Card.HEARTS_7, Card.CLUBS_7, Card.CLUBS_5, Card.HEARTS_5);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // full house wins against straight
        final Hand hand5_lower = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand5_higher = createHand(Card.HEARTS_KING, Card.CLUBS_4, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_4);
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_lower, hand5_higher));
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_higher, hand5_lower));

        // full house wins against flush
        final Hand hand6_lower = createHand(Card.HEARTS_5, Card.HEARTS_QUEEN, Card.HEARTS_KING, Card.HEARTS_6, Card.HEARTS_9);
        final Hand hand6_higher = createHand(Card.SPADES_8, Card.CLUBS_8, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_8);
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_lower, hand6_higher));
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_higher, hand6_lower));

        // highest full house wins
        final Hand hand7_lower = createHand(Card.SPADES_4, Card.CLUBS_4, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_4);
        final Hand hand7_higher = createHand(Card.SPADES_8, Card.CLUBS_8, Card.HEARTS_KING, Card.SPADES_KING, Card.HEARTS_8);
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_lower, hand7_higher));
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_higher, hand7_lower));

        // equal full houses not possible
    }

    @Test
    public void findHighestHand_FourOfAKind() {
        PokerHandsService service = new PokerHandsService();

        // four of a kind wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_ACE, Card.DIAMONDS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_4, Card.SPADES_4, Card.DIAMONDS_4, Card.CLUBS_4, Card.DIAMONDS_3);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // four of a kind wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_8, Card.HEARTS_7);
        final Hand hand2_higher = createHand(Card.CLUBS_QUEEN, Card.HEARTS_QUEEN, Card.DIAMONDS_QUEEN, Card.SPADES_QUEEN, Card.HEARTS_6);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // four of a kind wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.SPADES_10, Card.HEARTS_10, Card.CLUBS_10, Card.DIAMONDS_10, Card.HEARTS_JACK);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // four of a kind wins against three of a kind
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_KING, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.SPADES_5, Card.DIAMONDS_5, Card.CLUBS_7, Card.CLUBS_5, Card.HEARTS_5);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // four of a kind wins against straight
        final Hand hand5_lower = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand5_higher = createHand(Card.HEARTS_KING, Card.CLUBS_10, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.SPADES_KING);
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_lower, hand5_higher));
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_higher, hand5_lower));

        // four of a kind wins against flush
        final Hand hand6_lower = createHand(Card.HEARTS_5, Card.HEARTS_QUEEN, Card.HEARTS_KING, Card.HEARTS_6, Card.HEARTS_9);
        final Hand hand6_higher = createHand(Card.SPADES_8, Card.CLUBS_8, Card.DIAMONDS_8, Card.DIAMONDS_KING, Card.HEARTS_8);
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_lower, hand6_higher));
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_higher, hand6_lower));

        // four of a kind wins against full house
        final Hand hand7_lower = createHand(Card.SPADES_4, Card.CLUBS_4, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_4);
        final Hand hand7_higher = createHand(Card.SPADES_6, Card.CLUBS_6, Card.CLUBS_7, Card.DIAMONDS_6, Card.HEARTS_6);
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_lower, hand7_higher));
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_higher, hand7_lower));

        // equal four of a kind not possible
    }

    @Test
    public void findHighestHand_StraightFlush() {
        PokerHandsService service = new PokerHandsService();

        // straight flush wins against high card
        final Hand hand1_lower = createHand(Card.HEARTS_KING, Card.SPADES_8, Card.DIAMONDS_6, Card.CLUBS_ACE, Card.DIAMONDS_2);
        final Hand hand1_higher = createHand(Card.HEARTS_4, Card.HEARTS_5, Card.HEARTS_6, Card.HEARTS_7, Card.HEARTS_8);
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_lower, hand1_higher));
        assertEquals(hand1_higher, service.findHighestPokerhand(hand1_higher, hand1_lower));

        // straight flush wins against pair
        final Hand hand2_lower = createHand(Card.HEARTS_2, Card.DIAMONDS_4, Card.SPADES_4, Card.CLUBS_8, Card.HEARTS_7);
        final Hand hand2_higher = createHand(Card.CLUBS_QUEEN, Card.CLUBS_ACE, Card.CLUBS_JACK, Card.CLUBS_KING, Card.CLUBS_10);
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_lower, hand2_higher));
        assertEquals(hand2_higher, service.findHighestPokerhand(hand2_higher, hand2_lower));

        // straight flush wins against two pair
        final Hand hand3_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_4, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand3_higher = createHand(Card.SPADES_10, Card.SPADES_7, Card.SPADES_9, Card.SPADES_8, Card.SPADES_JACK);
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_lower, hand3_higher));
        assertEquals(hand3_higher, service.findHighestPokerhand(hand3_higher, hand3_lower));

        // straight flush wins against three of a kind
        final Hand hand4_lower = createHand(Card.HEARTS_KING, Card.SPADES_KING, Card.DIAMONDS_KING, Card.CLUBS_4, Card.HEARTS_2);
        final Hand hand4_higher = createHand(Card.SPADES_5, Card.SPADES_2, Card.SPADES_4, Card.SPADES_6, Card.SPADES_3);
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_lower, hand4_higher));
        assertEquals(hand4_higher, service.findHighestPokerhand(hand4_higher, hand4_lower));

        // straight flush wins against straight
        final Hand hand5_lower = createHand(Card.HEARTS_5, Card.SPADES_6, Card.DIAMONDS_7, Card.CLUBS_8, Card.HEARTS_9);
        final Hand hand5_higher = createHand(Card.HEARTS_KING, Card.HEARTS_JACK, Card.HEARTS_10, Card.HEARTS_QUEEN, Card.HEARTS_9);
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_lower, hand5_higher));
        assertEquals(hand5_higher, service.findHighestPokerhand(hand5_higher, hand5_lower));

        // straight flush wins against flush
        final Hand hand6_lower = createHand(Card.HEARTS_5, Card.HEARTS_QUEEN, Card.HEARTS_KING, Card.HEARTS_6, Card.HEARTS_9);
        final Hand hand6_higher = createHand(Card.SPADES_8, Card.SPADES_7, Card.SPADES_10, Card.SPADES_9, Card.SPADES_6);
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_lower, hand6_higher));
        assertEquals(hand6_higher, service.findHighestPokerhand(hand6_higher, hand6_lower));

        // straight flush wins against full house
        final Hand hand7_lower = createHand(Card.SPADES_4, Card.CLUBS_4, Card.CLUBS_KING, Card.DIAMONDS_KING, Card.HEARTS_4);
        final Hand hand7_higher = createHand(Card.CLUBS_5, Card.CLUBS_6, Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_9);
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_lower, hand7_higher));
        assertEquals(hand7_higher, service.findHighestPokerhand(hand7_higher, hand7_lower));

        // straight flush wins against four of a kind
        final Hand hand8_lower = createHand(Card.SPADES_4, Card.CLUBS_4, Card.HEARTS_4, Card.DIAMONDS_4, Card.CLUBS_10);
        final Hand hand8_higher = createHand(Card.CLUBS_5, Card.CLUBS_6, Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_9);
        assertEquals(hand8_higher, service.findHighestPokerhand(hand8_lower, hand8_higher));
        assertEquals(hand8_higher, service.findHighestPokerhand(hand8_higher, hand8_lower));

        // highest straight flush wins
        final Hand hand9_lower = createHand(Card.SPADES_2, Card.SPADES_5, Card.SPADES_3, Card.SPADES_4, Card.SPADES_6);
        final Hand hand9_higher = createHand(Card.CLUBS_5, Card.CLUBS_6, Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_9);
        assertEquals(hand9_higher, service.findHighestPokerhand(hand9_lower, hand9_higher));
        assertEquals(hand9_higher, service.findHighestPokerhand(hand9_higher, hand9_lower));

        // equal straight flushes
        final Hand hand10_equal1 = createHand(Card.HEARTS_5, Card.HEARTS_6, Card.HEARTS_7, Card.HEARTS_8, Card.HEARTS_9);
        final Hand hand10_equal2 = createHand(Card.CLUBS_5, Card.CLUBS_6, Card.CLUBS_7, Card.CLUBS_8, Card.CLUBS_9);
        assertEquals(null, service.findHighestPokerhand(hand10_equal1, hand10_equal2));
        assertEquals(null, service.findHighestPokerhand(hand10_equal2, hand10_equal1));
    }
}
