package ua.edu.ucu.tempseries;
import static org.junit.Assert.*;

import org.junit.Test;

public class TempSummaryStatisticsTest {

    @Test
    public void testCheckEqualsNull() {
        TempSummaryStatistics stat1 =
                new TempSummaryStatistics(1, 2, 1, 11);
        TempSummaryStatistics stat2 = null;
        assertFalse(stat1.checkEquals(stat2));
    }

    @Test
    public void testCheckEqualsTrue(){
        TempSummaryStatistics stat1 =
                new TempSummaryStatistics(1, 2, 1, 11);
        TempSummaryStatistics stat2 =
                new TempSummaryStatistics(1, 2, 1, 11);
        assertTrue(stat1.checkEquals(stat2));
    }

    @Test
    public void testCheckEqualsFalse(){
        TempSummaryStatistics stat1 =
                new TempSummaryStatistics(1, 2, 1, 11);
        TempSummaryStatistics stat2 =
                new TempSummaryStatistics(2, 2, 1, 11);
        assertFalse(stat1.checkEquals(stat2));
    }
}
