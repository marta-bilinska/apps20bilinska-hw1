package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TemperatureSeriesAnalysisTest {
    double[] averageArray = {1.0, 10.0, 3.0, -1.0};
    double[] arrayOfOne = {1.0};
    double[] emptyArray = {};

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }


    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();

    }

    @Test
    public void testDeviationOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 4.1457809879443;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testMinAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();

    }

    @Test
    public void testMinArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();

    }

    @Test
    public void testFindTempClosestToZeroAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroSpecificArray() {
        double[] temperatureSeries = {-0.2, 0.2, 3, -7};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(1.0);
    }

    @Test
    public void testFindTempClosestToValueArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(1.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(9.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThanAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0, -1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThanEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThanArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThanAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {10.0, 3.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThanEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThanArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(3.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5;
        double actualResult = seriesAnalysis.addTemps(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsEmptyArray() {
        double[] temperatureSeries = emptyArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1;
        double actualResult = seriesAnalysis.addTemps(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsArrayOfOne() {
        double[] temperatureSeries = arrayOfOne;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2;
        double actualResult = seriesAnalysis.addTemps(4.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatisticsAverageArray() {
        double[] temperatureSeries = averageArray;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        TempSummaryStatistics expResult = new TempSummaryStatistics(3.25, 4.14578098794425, -1.0, 10.0);

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        assert (expResult.getAvgTemp() == actualResult.getAvgTemp()
                && expResult.getMaxTemp() == actualResult.getMaxTemp()
                && expResult.getMinTemp() == actualResult.getMinTemp()
                && expResult.getDevTemp() == actualResult.getDevTemp());
    }

    @Test
    public void testDefaultConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        int expResult = 0;
        int actualResult = seriesAnalysis.getLength();

        assert (expResult == actualResult);
    }

    @Test(expected = InputMismatchException.class)
    public void testInputValidation() {
        double[] temperatureSeries = {-400, -380, 1, 235, 23};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

    }

    @Test(expected = InputMismatchException.class)
    public void testAddValidation() {
        double[] temperatureSeries = {12, 1, 235, 23};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(-750, 0);
    }

    @Test
    public void testAddValidationAverage() {
        double[] temperatureSeries = {12, 1, 235};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(750, 0);
        int expResult = 5;
        int actualResult = seriesAnalysis.getLength();
        assert (expResult == actualResult);
    }

    @Test
    public void testAddValidationLonger() {
        double[] temperatureSeries = {12, 1, 235};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(750, 0, 34, 45, 56, 6, 11, 12, 123);
        int expResult = 12;
        int actualResult = seriesAnalysis.getLength();
        assert (expResult == actualResult);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetTemperatureSeriesRemove() {
        double[] temperatureSeries = {12, 1, 235};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.getTemperatureSeries().iterator().remove();
    }

    @Test
    public void testAddTempsEmpty() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(750, 0);
        int expResult = 2;
        int actualResult = seriesAnalysis.getLength();
        assert (expResult == actualResult);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetTemperature() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(arrayOfOne);
        Iterator iter = seriesAnalysis.getTemperatureSeries().iterator();
        for (int i = 0; i < 3; i++) {
            iter.next();
        }
    }
}
