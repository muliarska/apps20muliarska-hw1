package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    public double[] temperatureSeries;
    public int tempLen;


    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }


    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        this.tempLen = temperatureSeries.length;
    }

    private void isValidLen() {
        if (tempLen == 0) {
            throw new IllegalArgumentException(
                    "There are no temperatures int he array");
        }
    }

    public double average() {
        isValidLen();
        double average = 0;
        for (int i=0; i < tempLen; i++) {
            average += temperatureSeries[i];
        }
        return average / tempLen;
    }

    public double deviation() {
        isValidLen();
        double deviation = 0;
        double average = average();

        for (int i=0; i < tempLen; i++) {
            deviation += Math.pow((temperatureSeries[i] - average), 2);
        }

        return Math.sqrt(deviation/tempLen);
    }

    private boolean comparison(double el1, double el2) {
        if (el1 < el2) {
            return true;
        }
        return false;
    }

    private double tempMinMax(boolean flag) {
        isValidLen();
        double limitTemp = temperatureSeries[0];
        for (int i=1; i < tempLen; i++) {
            if (flag ^ comparison(temperatureSeries[i], limitTemp)) {
                limitTemp = temperatureSeries[i];
            }
        }
        return limitTemp;
    }

    public double min() {
        return tempMinMax(false);
    }

    public double max() {
        return tempMinMax(true);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        isValidLen();
        double distance = Math.abs(temperatureSeries[0] - tempValue);
        double closestValue = temperatureSeries[0];

        for (int i=1; i < tempLen; i++) {
            double currDistance = Math.abs(temperatureSeries[i] - tempValue);

            if (currDistance == distance && temperatureSeries[i] > closestValue) {
                closestValue = temperatureSeries[i];
            }

            if (currDistance < distance) {
                distance = currDistance;
                closestValue = temperatureSeries[i];
            }
        }
        return closestValue;
    }

    private double[] findTemps(double tempValue, boolean flag) {
        isValidLen();
        double[] temps = new double[tempLen];
        int counter = 0;

        for (int i=0; i < tempLen; i++) {
            if (flag ^ comparison(temperatureSeries[i], tempValue)){
                temps[counter] = temperatureSeries[i];
                counter++;
            }
        }
        return temps;
    }

    public double[] findTempsLessThen(double tempValue) {
        return findTemps(tempValue, false);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findTemps(tempValue, true);
    }

    public TempSummaryStatistics summaryStatistics() {
        isValidLen();
        TempSummaryStatistics statistics = new TempSummaryStatistics(this);
        return statistics;
    }

    public int addTemps(double... temps) {
        int newLen = tempLen * 2;
        if (tempLen == 0) {
            newLen = 1;
        }
        double[] newSeries = new double[newLen];

        int i = 0;
        int j = 0;

        while(j < temps.length) {
            // increase size of the array
            while (i < tempLen) {
                newSeries[i] = temperatureSeries[i];
                i++;
            }

            // add new temps
            while (j < temps.length || i < temperatureSeries.length) {
                if (temps[j] < -273) {
                    throw new InputMismatchException();
                }
                newSeries[i] = temps[j];
            }
        }

        temperatureSeries = newSeries;
        tempLen = i;
        return tempLen;
    }
}
