package codeKata;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SumOfDifferencesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void basicTests() {
        assertEquals(9, SumOfDifferences.sumOfDifferences(new int[]{1, 2, 10}));
        assertEquals(2, SumOfDifferences.sumOfDifferences(new int[]{-3, -2, -1}));
        assertEquals(0, SumOfDifferences.sumOfDifferences(new int[]{1, 1, 1, 1, 1}));
        assertEquals(34, SumOfDifferences.sumOfDifferences(new int[]{-17, 17}));
        assertEquals(0, SumOfDifferences.sumOfDifferences(new int[0]));
        assertEquals(0, SumOfDifferences.sumOfDifferences(new int[]{0}));
        assertEquals(0, SumOfDifferences.sumOfDifferences(new int[]{-1}));
        assertEquals(0, SumOfDifferences.sumOfDifferences(new int[]{1}));
    }
}