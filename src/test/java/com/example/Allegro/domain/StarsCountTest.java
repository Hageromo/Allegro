package com.example.Allegro.domain;

import com.example.Allegro.domain.Stars.StarsCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StarsCountTest {


    //Given
    StarsCount prime = new StarsCount(1);


    @Test
    public void add(){

        //When
        StarsCount sum = new StarsCount(2);
        StarsCount results = sum.add(prime);

        //The
        assertThat(results).isEqualTo(new StarsCount(3));
    }

    @Test
    public void StarsCountNegative(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    StarsCount starsCount = new StarsCount(-3);
                }, "Invalid stars count");

        Assertions.assertEquals("Invalid stars count", thrown.getMessage());
    }

    @Test
    public void StarsCountZero(){

        //When
        StarsCount sum = new StarsCount(0);
        StarsCount results = sum.add(prime);

        //Then
        assertThat(results).isEqualTo(new StarsCount(1));
    }

}