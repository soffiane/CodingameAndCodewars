package codeKata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacebookLikesAdderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void staticTests() {
        assertEquals("no one likes this", FacebookLikesAdder.whoLikesIt());
        assertEquals("Peter likes this", FacebookLikesAdder.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", FacebookLikesAdder.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", FacebookLikesAdder.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", FacebookLikesAdder.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}