package com.owodigi.model;

/**
 *
 */
public class DeckFactory {

    /**
     * 
     * @return 
     */
    public static Deck newInstance() {
       return new StandardDeck(); 
    }
}
