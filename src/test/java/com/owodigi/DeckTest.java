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
}
