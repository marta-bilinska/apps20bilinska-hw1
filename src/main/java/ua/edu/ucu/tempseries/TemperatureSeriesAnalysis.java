package ua.edu.ucu.tempseries;



import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.function.BiFunction;

public class TemperatureSeriesAnalysis {
    private final double possibleMinimum = -273.0;
    private final int initialSize = 10;
    private double[] temperatureSeries;
    private int length;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[initialSize];
        this.length = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (hasIllegalTemperature(temperatureSeries)) {
            throw new InputMismatchException();
        }
        this.temperatureSeries = temperatureSeries;
        this.length = temperatureSeries.length;

    }

    public Iterable<Double> getTemperatureSeries() {
        return () -> new Iterator<Double>() {
            private int i = -1;
            @Override
            public boolean hasNext() {
                return i < length - 1;
            }
            @Override
            public Double next() {
                return temperatureSeries[++i];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    public void checkForEmptySeries() {
        if (this.length < 1) {
            throw new IllegalArgumentException();
        }
    }

    private double sum() {
        double sum = 0.0;
        for (double temperature : getTemperatureSeries()) {
            sum += temperature;
        }
        return sum;
    }

    private boolean hasIllegalTemperature(double[] tempArray) {
        for (double temp : tempArray) {
            if (temp < this.possibleMinimum) {
                return true;
            }
        }
        return false;
    }

    public double average() {
        checkForEmptySeries();
        return sum() / length;
    }

    public double deviation() {
        checkForEmptySeries();
        double mean = average();
        double sum = 0.0;
        for (double temperature : getTemperatureSeries()) {
            double diffFromMean = temperature - mean;
            sum += diffFromMean * diffFromMean;
        }
        return Math.sqrt(sum / length);
    }

    public double min() {
        checkForEmptySeries();
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] < min) {
                min = temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        checkForEmptySeries();
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < length; i++) {
            if (temperatureSeries[i] > max) {
                max = temperatureSeries[i];
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0.0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkForEmptySeries();
        double closestDistance = Double.POSITIVE_INFINITY;
        double result = Double.POSITIVE_INFINITY;
        for (double temperature : getTemperatureSeries()) {
            double distance = Math.abs(temperature - tempValue);
            if (distance < closestDistance
                    || (distance == closestDistance && result < temperature)
            ) {
                closestDistance = distance;
                result = temperature;
            }
        }
        return result;
    }

    public double[] findTempsLessThen(double tempValue) {
        return findElements(tempValue, (x, y) -> x < y);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findElements(tempValue, (x, y) -> x >= y);
    }


    private double[] findElements(double tempValue,
                          BiFunction<Double, Double, Boolean> comparator) {

        int resultLength = 0;
        for (double temperature : getTemperatureSeries()) {
            if (comparator.apply(temperature, tempValue)) {
                resultLength++;
            }
        }
        double[] result = new double[resultLength];
        int i = 0;
        for (double temperature : getTemperatureSeries()) {
            if (comparator.apply(temperature, tempValue)) {
                result[i] = temperature;
                i++;
            }
        }
        return result;
    }

    public int getLength() {
        return length;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkForEmptySeries();
        return new TempSummaryStatistics(
                this.average(),
                this.deviation(),
                this.min(),
                this.max()
        );
    }

    public int addTemps(double... temps) {
        if (hasIllegalTemperature(temps)) {
            throw new InputMismatchException();
        }
        int requiredLength = length + temps.length;
        if (requiredLength > temperatureSeries.length) {
            int newLength;
            if (length * 2 < requiredLength) {
                newLength = requiredLength;
            } else {
                newLength = length * 2;
            }
            double[] newTempArray = new double[newLength];
            int i = 0;
            for (double element : getTemperatureSeries()) {
                newTempArray[i] = element;
                i++;
            }
            temperatureSeries = newTempArray;
        }
        for (double temp : temps) {
            temperatureSeries[length] = temp;
            length++;
        }
        return length;
    }
}
