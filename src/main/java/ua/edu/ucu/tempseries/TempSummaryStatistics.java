package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;


    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public TempSummaryStatistics(TemperatureSeriesAnalysis analysis) {
        this.avgTemp = analysis.average();
        this.devTemp = analysis.deviation();
        this.minTemp = analysis.min();
        this.maxTemp = analysis.max();
    }
}
