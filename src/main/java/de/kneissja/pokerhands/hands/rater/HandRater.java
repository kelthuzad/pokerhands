package de.kneissja.pokerhands.hands.rater;

import de.kneissja.pokerhands.cards.Card;
import de.kneissja.pokerhands.hands.HandRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Rates the poker hands.
 * @author kneissja
 */
public class HandRater {

    /**
     * List of all raters that are used to rate the poker hand
     */
    private final List<Rateable> raters;

    public HandRater() {
        // The order of the raters in the list is the order
        // in which the cards are rated and must match the
        // order of the HandRating enum values
        raters = new ArrayList<>();
        raters.add(new StraightFlushRater());
        raters.add(new FourOfAKindRater());
        raters.add(new FullHouseRater());
        raters.add(new FlushRater());
        raters.add(new StraightRater());
        raters.add(new ThreeOfAKindRater());
        raters.add(new TwoPairRater());
        raters.add(new PairRater());
        raters.add(new HighCardRater());
    }

    /**
     * Returns the rating of the poker hand
     * @param cards to be rated
     * @return rating of the hand
     */
    public HandRating rateHand(final List<Card> cards) {
        // the rating of the hand ist the first match in the list
        Optional<Rateable> foundRating = raters.stream().filter(rateable -> rateable.test(cards)).findFirst();
        if (foundRating.isPresent()) {
            return foundRating.get().getRating();
        }
        return HandRating.UNKNOWN;
    }
}
