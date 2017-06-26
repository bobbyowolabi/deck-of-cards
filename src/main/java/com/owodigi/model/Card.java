package com.owodigi.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.suit);
        hash = 59 * hash + Objects.hashCode(this.faceValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.suit != other.suit) {
            return false;
        }
        return this.faceValue == other.faceValue;
    }
    
    public Suit suit() {
        return suit;
    }

    public FaceValue faceValue() {
        return faceValue;
    }
}
