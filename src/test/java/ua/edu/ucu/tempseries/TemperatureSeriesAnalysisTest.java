package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis seriesAnalysisOneEl;
    TemperatureSeriesAnalysis seriesAnalysisEmpty;
    TemperatureSeriesAnalysis seriesAnalysisManyEl;


    public TemperatureSeriesAnalysisTest() {
        // setup input data
        double[] temperatureSeriesOneEl = {-1.0};
        this.seriesAnalysisOneEl = new TemperatureSeriesAnalysis(temperatureSeriesOneEl);

        this.seriesAnalysisEmpty = new TemperatureSeriesAnalysis();

        double[] temperatureSeriesManyEl = {3.0, -5.0, 1.0, 5.0};
        this.seriesAnalysisManyEl = new TemperatureSeriesAnalysis(temperatureSeriesManyEl);

    }


    // TEST AVERAGE
    @Test
    public void testAverageWithOneElementArray() {
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.average();
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;

        double actualResult = seriesAnalysisManyEl.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }


    // TEST DEVIATION
    @Test
    public void testDeviationWithOneElementArray() {
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.deviation();
    }

    @Test
    public void testDeviation() {
        double expResult = Math.sqrt(14.0);

        double actualResult = seriesAnalysisManyEl.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }


    // TEST MIN
    @Test
    public void testMinWithOneElementArray() {
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.min();
    }

    @Test
    public void testMin() {
        double expResult = -5.0;

        double actualResult = seriesAnalysisManyEl.min();

        assertEquals(expResult, actualResult, 0.00001);
    }


    // TEST MAX
    @Test
    public void testMaxWithOneElementArray() {
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.max();
    }

    @Test
    public void testMax() {
        double expResult = 5.0;

        double actualResult = seriesAnalysisManyEl.max();

        assertEquals(expResult, actualResult, 0.00001);
    }


    // TEST FIND CLOSEST TO ZERO
    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double expResult = 1.0;

        double actualResult = seriesAnalysisManyEl.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }


    // TEST FIND CLOSEST TO VALUE
    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
         double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysisOneEl.findTempClosestToValue(-2.0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.findTempClosestToValue(1.0);
    }

    @Test
    public void testFindTempClosestToValue() {
        double expResult = 5.0;

        double actualResult = seriesAnalysisManyEl.findTempClosestToValue(4.0);

        assertEquals(expResult, actualResult, 0.00001);


        // given 1.0 and -1.0 on the same distance from zero
        double[] temperatureSeries = {3.0, -1.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult1 = 1.0;

        double actualResult1 = seriesAnalysis.findTempClosestToValue(0.0);

        assertEquals(expResult1, actualResult1, 0.00001);
    }


    // TEST FIND TEMPS LESS THAN VALUE
    @Test
    public void testFindTempsLessThenToValueWithOneElementArray() {

        // call tested method
        double[] actualResult = seriesAnalysisOneEl.findTempsLessThen(0.0);
        double[] expResult = {-1.0};

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.findTempsLessThen(1.0);
    }

    @Test
    public void testFindTempsLessThen() {

        double[] actualResult = seriesAnalysisManyEl.findTempsLessThen(2.0);
        double[] expResult = {-5.0, 1.0};

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    // TEST FIND TEMPS GREATER THAN VALUE
    @Test
    public void testFindTempsGreaterThenToValueWithOneElementArray() {

        // call tested method
        double[] actualResult = seriesAnalysisOneEl.findTempsGreaterThen(-2.0);
        double[] expResult = {-1.0};

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.findTempsGreaterThen(1.0);
    }

    @Test
    public void testFindTempsGreaterThen() {

        double[] actualResult = seriesAnalysisManyEl.findTempsGreaterThen(2.0);
        double[] expResult = {3.0, 5.0};

        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    // TEST SUMMARY STATISTICS
    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        double expAvg = -1.0;
        double expDev = 0.0;
        double expMin = -1.0;
        double expMax = -1.0;

        TempSummaryStatistics statistics = seriesAnalysisOneEl.summaryStatistics();

        assertEquals(statistics.getAvgTemp(), expAvg, 0.00001);
        assertEquals(statistics.getDevTemp(), expDev, 0.00001);
        assertEquals(statistics.getMinTemp(), expMin, 0.00001);
        assertEquals(statistics.getMaxTemp(), expMax, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.summaryStatistics();
    }


    @Test
    public void testSummaryStatistics() {

        double expAvg = 1.0;
        double expDev = Math.sqrt(14.0);
        double expMin = -5.0;
        double expMax = 5.0;

        TempSummaryStatistics statistics = seriesAnalysisManyEl.summaryStatistics();

        assertEquals(statistics.getAvgTemp(), expAvg, 0.00001);
        assertEquals(statistics.getDevTemp(), expDev, 0.00001);
        assertEquals(statistics.getMinTemp(), expMin, 0.00001);
        assertEquals(statistics.getMaxTemp(), expMax, 0.00001);
    }


    // TEST ADD TEMPS
    @Test
    public void testAddTempsWithOneElementArray() {
        double[] newSeries = {1.0, 4.0};

        seriesAnalysisOneEl.addTemps(newSeries);

        double[] expResult = {-1.0, 1.0, 4.0, 0.0};
        double[] actualResult = seriesAnalysisOneEl.getTemperatureSeries();

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsWithEmptyArray() {
        double[] newSeries = {1.0, 4.0};

        seriesAnalysisEmpty.addTemps(newSeries);

        double[] expResult = {1.0, 4.0};
        double[] actualResult = seriesAnalysisEmpty.getTemperatureSeries();

        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testAddTemps() {
        double[] newSeries = {1.0, 4.0};

        seriesAnalysisManyEl.addTemps(newSeries);

        double[] expResult = {3.0, -5.0, 1.0, 5.0, 1.0, 4.0, 0.0, 0.0};
        double[] actualResult = seriesAnalysisManyEl.getTemperatureSeries();

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

}
