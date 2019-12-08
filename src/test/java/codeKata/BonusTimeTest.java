package codeKata;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusTimeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void basicTests() {
        boolean wellConfigured=unicodeTest();
        assertEquals((wellConfigured?"£":"\u00A3")+"100000",BonusTime.bonusTime(10000, true));
        assertEquals((wellConfigured?"£":"\u00A3")+"250000",BonusTime.bonusTime(25000, true));
        assertEquals((wellConfigured?"£":"\u00A3")+"10000",BonusTime.bonusTime(10000, false));
        assertEquals((wellConfigured?"£":"\u00A3")+"60000",BonusTime.bonusTime(60000, false));
        assertEquals((wellConfigured?"£":"\u00A3")+"20",BonusTime.bonusTime(2, true));
        assertEquals((wellConfigured?"£":"\u00A3")+"78",BonusTime.bonusTime(78, false));
        assertEquals((wellConfigured?"£":"\u00A3")+"678900",BonusTime.bonusTime(67890, true));
    }

    public boolean unicodeTest(){
        System.out.println("\u00A3 == £:"+"\u00A3".equalsIgnoreCase("£"));
        System.out.println("if previous result was false or had ? symbol then perhaps you need to escape unicode due to misconfiguration");
        return "\u00A3".equalsIgnoreCase("£");
    }
}