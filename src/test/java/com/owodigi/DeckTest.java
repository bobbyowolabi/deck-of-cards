package com.owodigi;

import com.owodigi.model.Card;
import com.owodigi.model.Deck;
import com.owodigi.model.DeckFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    private void assertDistinct(final String message, final Deck deck1, final Deck deck2) {
        final List<Card> deck1List = dealADeck(deck1);
        final List<Card> deck2List = dealADeck(deck2);
        Assert.assertNotEquals(message, deck1List, deck2List);
    }
    
    private List<Card> dealADeck(final Deck deck) {
        final List<Card> deckList = new ArrayList<>();
        for (int i = 0; i < 52; ++i) {
            deckList.add(i, deck.dealOneCard());
        }
        return deckList;
    }
    
    @Test
    public void testDealOneCard() {
        final Deck deck = DeckFactory.newInstance();
        Assert.assertNotNull("First card dealt from deck should be non null", deck.dealOneCard());
    }
    
    @Test
    public void testDeal53Cards() {
        final Deck deck = DeckFactory.newInstance();
        for (int i = 0; i < 52; ++i) {
            Assert.assertNotNull("Expect first 52 dealt cards to be non null", deck.dealOneCard());
        }
        Assert.assertNull("Expected 53rd dealt card to be null", deck.dealOneCard());
    }
    
    @Test
    public void testShuffleProducesDistinctDecks() {
        final Deck deck1 = DeckFactory.newInstance();
        deck1.shuffle();
        final Deck deck2 = DeckFactory.newInstance();
        deck2.shuffle();
        assertDistinct("Expect reasonable shuffle implementation not to return the same deck consecutively", deck1, deck2);
    }
}
