package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class AlexLionTest {

    @Test
    public void getFriendsReturnsListOfFriends() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        AlexLion alex = new AlexLion(feline);
        Assert.assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        AlexLion alex = new AlexLion(feline);
        Assert.assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        AlexLion alex = new AlexLion(feline);
        Assert.assertEquals(0, alex.getKittens());
    }
}
