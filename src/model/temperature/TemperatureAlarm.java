package model.temperature;

public class TemperatureAlarm {
    private double maxValue = 35.0;
    private double minValue = 19.0;


    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

}
