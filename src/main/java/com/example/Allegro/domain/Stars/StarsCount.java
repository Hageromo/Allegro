package com.example.Allegro.domain.Stars;

public record StarsCount(int value) {
    public static StarsCount ZERO = new StarsCount(0);

    public StarsCount{
        if (value < 0) {
            throw new RuntimeException("Invalid stars count");
        }
    }

    public StarsCount add(StarsCount other) {
        return new StarsCount(this.value + other.value);
    }
}
