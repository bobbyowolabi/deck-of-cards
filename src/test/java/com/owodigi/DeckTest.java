package com.owodigi;

import com.owodigi.model.Card;
import com.owodigi.model.Deck;
import com.owodigi.model.DeckFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    private void assertEquals(final String message, final Card expected, final Card actual) {
        Assert.assertEquals(message + ": suit", expected.suit(), actual.suit());
        Assert.assertEquals(message + ": face value", expected.faceValue(), actual.faceValue());
    }
    
    private void assertEquals(final String message, final Iterator<Card> expected, final Iterator<Card> actual) {
        while (expected.hasNext()) {
            assertEquals(message, expected.next(), actual.next());
        }
    }
    
    private void assertEquals(final String message, final List<Card> expected, final List<Card> actual) {
        Assert.assertEquals(message + ": Card List size", expected.size(), actual.size());
        assertEquals(message, expected.iterator(), actual.iterator());
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
        Deck deck = DeckFactory.newInstance();
        deck.shuffle();
        final List<Card> permutation1 = new ArrayList<>();
        for (int i = 0; i < 52; ++i) {
            permutation1.add(i, deck.dealOneCard());
        }
        deck = DeckFactory.newInstance();
        deck.shuffle();
        final List<Card> permutation2 = new ArrayList<>();
        for (int i = 0; i < 52; ++i) {
            permutation2.add(i, deck.dealOneCard());
        }
        assertEquals("Expect reasonable shuffle implementation to not return the same deck consecutively", permutation1, permutation2);
    }
}
