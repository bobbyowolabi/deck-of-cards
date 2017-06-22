package com.owodigi.model;

/**
 * Represents a deck of style playing cards
 */
public interface Deck {

    /**
     * Results in the cards in this deck being randomly permuted.
     */
    public void shuffle();
    
    
    /**
     * Returns one card from this deck.  Once all the cards from this deck have
     * been dealt, then null will be returned.
     * 
     * @return one card from this deck if it has cards remaining; otherwise, null.
     */
    public Card dealOneCard();
}
