package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatReturnsPredatorFoodListTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals("Хищники должны питаться: Животными, Птицами, Рыбами",
                expectedFood,
                actualFood);
    }

    @Test
    public void getFamilyReturnsFelineFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Семейство должно быть: 'Кошачьи'",
                expectedFamily,
                actualFamily);
    }

    @Test
    public void getKittensDefaultReturnsOneTest() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        Assert.assertEquals("По умолчанию должно возвращаться котят: 1",
                expectedKittens,
                actualKittens);
    }

    @Test
    public void getKittensWithParameterReturnsCorrectNumberTest() {
        int expectedCount = 5;
        int actualCount = feline.getKittens(expectedCount);
        Assert.assertEquals("Должно возвращаться: n котят",
                expectedCount,
                actualCount);
    }
}