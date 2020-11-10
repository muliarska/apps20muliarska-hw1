package ua.edu.ucu.tempseries;

public final class TempSummaryStatistics {

    public final double avgTemp;
    public final double devTemp;
    public final double minTemp;
    public final double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis analysis) {
        this.avgTemp = analysis.average();
        this.devTemp = analysis.deviation();
        this.minTemp = analysis.min();
        this.maxTemp = analysis.max();
    }
}
