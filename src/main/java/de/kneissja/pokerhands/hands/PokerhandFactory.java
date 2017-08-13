package de.kneissja.pokerhands.hands;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.cards.CardComparator;
import de.kneissja.pokerhands.hands.rater.HandRater;

import java.util.*;

/**
 * Creates {@link Hand} instances.
 * @author kneissja
 */
public class PokerhandFactory {
    /**
     * Number of cards in a hand
     */
    private static final int HAND_SIZE = 5;

    /**
     * Creates a new {@link Hand} from the cards
     * @param cards Cards in the hand
     * @return A new {@link Hand}
     */
    public Hand createHand(Collection<Card> cards) {
        verifyCards(cards);

        List<Card> cardList = new ArrayList<>(cards);
        cardList.sort(new CardComparator());
        HandRating rating = new HandRater().rateHand(cardList);

        switch (rating) {
            case HIGH_CARD: return new HighCardHand(cardList);
            case PAIR: return new PairHand(cardList);
            case TWO_PAIRS: return new TwoPairHand(cardList);
            case THREE_OF_A_KIND: return new ThreeOfAKindHand(cardList);
            default: throw new IllegalStateException("Unknown card rating: "+rating);
        }
    }

    /**
     * Creates a new {@link Hand} from the cards
     * @param cards Cards in the hand
     * @return A new {@link Hand}
     */
    public Hand createHand(Card... cards) {
        return createHand(Arrays.asList(cards));
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
}
