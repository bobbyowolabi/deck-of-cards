package com.owodigi.model;

/**
 *
 */
class StandardDeck implements Deck {

    public StandardDeck() {
    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card dealOneCard() {
        return new Card();
    }
}
