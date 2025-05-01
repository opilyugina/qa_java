package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
    }

    @Test(expected = Exception.class)
    public void constructorShouldThrowExceptionForInvalidGenderTest() throws Exception {
        new Lion("Недопустимое значение, используйте: Самец или Самка", feline);
    }

    @Test
    public void getFoodShouldReturnPredatorFoodListTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        Assert.assertEquals("Лев как хищник должен питаться: Животными, Птицами, Рыбами",
                expectedFood,
                actualFood);
    }

    @Test
    public void getKittensShouldReturnValueFromFelineTest() throws Exception {
        int expectedKittensCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);

        int actualKittensCount = lion.getKittens();
        Assert.assertEquals("Количество котят должно совпадать с возвращаемым значением Feline",
                expectedKittensCount,
                actualKittensCount);
    }

    @Test
    public void getFoodShouldCallFelineWithPredatorArgumentTest() throws Exception {
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}