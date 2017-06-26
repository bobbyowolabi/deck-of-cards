package com.owodigi.model;

/**
 * Factory class that can vend Deck objects.
 */
public class DeckFactory {

    /**
     * Return a new Deck Instance
     * 
     * @return 
     */
    public static Deck newInstance() {
       return new StandardDeck(); 
    }
}
