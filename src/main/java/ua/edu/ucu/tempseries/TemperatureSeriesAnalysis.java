package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;
    private int tempLen;
    private final double LOWERLIMIT = -273.0;


    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }


    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        this.tempLen = temperatureSeries.length;
    }

    public double[] getTemperatureSeries() {
        return temperatureSeries;
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
        for (int i = 0; i < tempLen; i++) {
            average += temperatureSeries[i];
        }
        return average / tempLen;
    }

    public double deviation() {
        isValidLen();
        double deviation = 0;
        double average = average();

        for (int i = 0; i < tempLen; i++) {
            deviation += (temperatureSeries[i] - average)
                    * (temperatureSeries[i] - average);
        }

        return Math.sqrt(deviation/tempLen);
    }

    private boolean comparison(double elFirst, double elSecond) {
        if (elFirst < elSecond) {
            return true;
        }
        return false;
    }

    private double tempMinMax(boolean flag) {
        isValidLen();
        double limitTemp = temperatureSeries[0];
        for (int i = 1; i < tempLen; i++) {
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

        for (int i = 1; i < tempLen; i++) {
            double currDistance = Math.abs(temperatureSeries[i] - tempValue);

            if (currDistance == distance
                    && temperatureSeries[i] > closestValue) {
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

        int newLen = 0;
        for (int i = 0; i < tempLen; i++) {
            if (flag ^ comparison(temperatureSeries[i], tempValue)) {
                newLen++;
            }
        }

        double[] temps = new double[newLen];
        int counter = 0;

        for (int i = 0; i < tempLen; i++) {
            if (flag ^ comparison(temperatureSeries[i], tempValue)) {
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
        int newLen = temperatureSeries.length;
        if (tempLen == 0) {
            newLen = 1;
        }
        double[] newSeries = new double[newLen];


        while (newSeries.length < tempLen + temps.length) {
            newSeries = new double[newSeries.length * 2];

            int j = 0;
            while (j < temperatureSeries.length) {
                newSeries[j] = temperatureSeries[j];
                j++;
            }
        }

        int k = 0;
        while (k < temps.length) {
            if (temps[k] < LOWERLIMIT) {
                throw new InputMismatchException();
            }
            newSeries[k+tempLen] = temps[k];
            k++;
        }

        temperatureSeries = newSeries;
        tempLen = tempLen + temps.length;
        return tempLen;
    }
}
