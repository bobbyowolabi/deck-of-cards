package com.owodigi;

import com.owodigi.model.Card;
import com.owodigi.model.Deck;
import com.owodigi.model.DeckFactory;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    private void assertNotEquals(final String message, final Card card1, final Card card2) {
        Assert.assertNotEquals(message + ": Suit", card1.suit(), card2.suit());
        Assert.assertNotEquals(message + ": Face Value", card1.faceValue(), card2.faceValue());
    }
    
    private void assertDistinct(final String message, final Deck deck1, final Deck deck2) {
        Card deck1Card;
        while ((deck1Card = deck1.dealOneCard()) != null) {
            assertNotEquals(message, deck1Card, deck2.dealOneCard());
        }
        Assert.assertNull("Expected to reach end of deck", deck2.dealOneCard());        
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
        assertDistinct("Expect reasonable shuffle implementation to not return the same deck consecutively", deck1, deck2);
    }
}
