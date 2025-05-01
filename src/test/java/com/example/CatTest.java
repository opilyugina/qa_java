package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CatTest {

    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeowTest() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals("Кошка должна говорить: 'Мяу'",
                expectedSound,
                actualSound);
    }

    @Test
    public void getFoodReturnsPredatorFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Кошка должна питаться как хищник: Животными, Птицами, Рыбами",
                expectedFood,
                actualFood);
    }
}