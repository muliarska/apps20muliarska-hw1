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

        double[] temperatureSeriesEmpty = {};
        this.seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);

        double[] temperatureSeriesManyEl = {3.0, -5.0, 1.0, 5.0};
        this.seriesAnalysisManyEl = new TemperatureSeriesAnalysis(temperatureSeriesManyEl);

    }

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
    }


    @Test
    public void testFindTempsLessThenToValueWithOneElementArray() {

        // call tested method
        double[] actualResult = seriesAnalysisOneEl.findTempsLessThen(0.0);

        // compare expected result with actual result
        assertEquals(actualResult[0], -1.0, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {

        // expect exception here
        seriesAnalysisEmpty.findTempsLessThen(1.0);
    }

    @Test
    public void testFindTempsLessThen() {

        double[] actualResult = seriesAnalysisManyEl.findTempsLessThen(2.0);

        assertEquals(actualResult[0], -5.0, 0.00001);
        assertEquals(actualResult[1], 1.0, 0.00001);
    }


    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        double expAvg = -1.0;
        double expDev = 0.0;
        double expMin = -1.0;
        double expMax = -1.0;

        TempSummaryStatistics statistics = seriesAnalysisOneEl.summaryStatistics();

        assertEquals(statistics.avgTemp, expAvg, 0.00001);
        assertEquals(statistics.devTemp, expDev, 0.00001);
        assertEquals(statistics.minTemp, expMin, 0.00001);
        assertEquals(statistics.maxTemp, expMax, 0.00001);
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

        assertEquals(statistics.avgTemp, expAvg, 0.00001);
        assertEquals(statistics.devTemp, expDev, 0.00001);
        assertEquals(statistics.minTemp, expMin, 0.00001);
        assertEquals(statistics.maxTemp, expMax, 0.00001);
    }

}
