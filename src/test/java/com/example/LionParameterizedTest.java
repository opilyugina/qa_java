package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;
    private Feline feline;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, Наличие гривы: {1}")
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(
                String.format("Для пола '%s' наличие гривы должно быть %s", sex, expectedHasMane),
                expectedHasMane,
                actualHasMane
        );
    }
}