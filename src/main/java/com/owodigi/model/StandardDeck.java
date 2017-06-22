package com.owodigi.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
class StandardDeck implements Deck {
    private List<Card> cards = new ArrayList<>();

    public StandardDeck() {
        for (int i = 0; i < 52; ++i) {
            cards.add(i, new Card());
        }
    }

    @Override
    public void shuffle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Card dealOneCard() {
        final Iterator<Card> iterator = cards.iterator();
        if (iterator.hasNext()) {
            final Card card = iterator.next();
            iterator.remove();
            return card;
        }
        return null;        
    }
}
