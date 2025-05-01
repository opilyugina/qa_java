package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class AlexLionTest {

    private Feline feline;
    private AlexLion alex;

    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        alex = new AlexLion(feline);
    }

    @Test
    public void getFriendsReturnsListOfThreeFriendsTest() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        List<String> actualFriends = alex.getFriends();
        Assert.assertEquals(
                "Друзьями Алекса должны быть Марти, Глория, Мелман",
                expectedFriends,
                actualFriends
        );
    }

    @Test
    public void getPlaceOfLivingReturnsNYZooTest() {
        String expectedPlace = "Нью-Йоркский зоопарк";
        String actualPlace = alex.getPlaceOfLiving();
        Assert.assertEquals(
                "Алекс должен жить в Нью-Йоркском зоопарке",
                expectedPlace,
                actualPlace
        );
    }

    @Test
    public void getKittensReturnsZeroTest() {
        int expectedKittens = 0;
        int actualKittens = alex.getKittens();
        Assert.assertEquals(
                "У Алекса не должно быть котят",
                expectedKittens,
                actualKittens
        );
    }
}