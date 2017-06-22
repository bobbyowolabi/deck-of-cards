package com.owodigi;

import com.owodigi.model.Deck;
import com.owodigi.model.DeckFactory;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void testDealOneCard() {
        final Deck deck = DeckFactory.newInstance();
        Assert.assertNotNull("First card dealt from deck should be non null", deck.dealOneCard());
    }
    
    @Test
    public void testDeal53Cards() {
        final Deck deck = DeckFactory.newInstance();
        for (int i = 0; i <= 52; ++i) {
            Assert.assertNotNull("Expect first 52 dealt cards to be non null", deck.dealOneCard());
        }
        Assert.assertNull("Expected 53rd dealt card to be null", deck.dealOneCard());
    }
}
