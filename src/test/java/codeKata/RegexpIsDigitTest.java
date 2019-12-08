package codeKata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexpIsDigitTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isDigit() {
        assertFalse(RegexpIsDigit.isDigit(""));
        assertTrue(RegexpIsDigit.isDigit("7"));
        assertFalse(RegexpIsDigit.isDigit(" "));
        assertFalse(RegexpIsDigit.isDigit("a"));
        assertFalse(RegexpIsDigit.isDigit("a5"));
        assertFalse(RegexpIsDigit.isDigit("14"));
    }
}