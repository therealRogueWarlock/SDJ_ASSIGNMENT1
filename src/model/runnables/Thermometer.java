package model.runnables;
// todo: everything
import mediators.TemperatureModel;

public class Thermometer implements Runnable
{

    private double temperature;
    private int distance;
    private String id;
    private TemperatureModel model;
    private int secondLastMeasure;

    public Thermometer(TemperatureModel model, double temperature, int distance, String id)
    {
        this.temperature = temperature;
        this.distance = distance;
        this.id = id;
        this.model = model;
        secondLastMeasure = 1;
    }

    public void setMeasureInterval(int secondLastMeasure)
    {
        this.secondLastMeasure = secondLastMeasure;
    }
/*
    private double temperature(int power, double outdoorTemperature){

        double tMax = Math.min(11 * power + 10, 11 * power + 10 + outdoorTemperature);

        tMax = Math.max(Math.max(temperature, tMax), outdoorTemperature);
        double heaterTerm = 0;

        if (power > 0){
            double den = Math.max((tMax * (20 - 5 * power) * (distance + 5)), 0.1);
            heaterTerm = 30 * secondLastMeasure * Math.abs(tMax - temperature) / den;
        }

        double outdoorTerm = (temperature - outdoorTemperature) * secondLastMeasure / 250.0;

        temperature = Math.min(Math.max(temperature - outdoorTerm + heaterTerm, outdoorTemperature), tMax);

        return temperature;
    }

 */

    public double temperature(double t, int p, int d, double t0, int s)
    {
        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        tMax = Math.max(Math.max(t, tMax), t0);
        double heaterTerm = 0;
        if (p > 0)
        {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outdoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
        return t;
    }


    @Override public void run()
    {

        while (true)
        {

            temperature = temperature(2, 1, distance,5,4);
            model.addTemperature(id, temperature);

            try
            {
                Thread.sleep(secondLastMeasure * 1000L);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
