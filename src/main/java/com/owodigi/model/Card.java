package com.owodigi.model;

/**
 * Represents a poker-style playing card
 */
public class Card {
    private final Suit suit;
    private final FaceValue faceValue;

    public Card(final Suit suit, final FaceValue faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }
    
    public Suit suit() {
        return suit;
    }

    public FaceValue faceValue() {
        return faceValue;
    }
}
