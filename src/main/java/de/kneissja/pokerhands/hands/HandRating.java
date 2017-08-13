package de.kneissja.pokerhands.hands;

/**
 * Rating of poker hands.
 * The order of the rating is given by the order of declaration.
 * @author kneissja
 */
public enum HandRating {
    UNKNOWN,
    HIGH_CARD,
    PAIR,
    TWO_PAIRS,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH;
}
