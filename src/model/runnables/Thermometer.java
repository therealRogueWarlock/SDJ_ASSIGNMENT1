package model.runnables;
// todo: everything
import mediators.TemperatureModel;

public class Thermometer implements Runnable
{

    private double internalTemperature;
    private double externalTemperature;

    private int distance;
    private String id;

    private TemperatureModel model;

    private int measureInterval;

    public Thermometer(TemperatureModel model,
                       double internalTemperature, double externalTemperature, int distance, String id)
    {
        this.internalTemperature = internalTemperature;
        this.externalTemperature = externalTemperature;

        this.distance = distance;
        this.id = id;
        this.model = model;
        measureInterval = 1;
    }

    public void setMeasureInterval(int secondLastMeasure) {
        this.measureInterval = secondLastMeasure;
    }

    private double temperature(int power, double outdoorTemperature){

        double tMax = Math.min(11 * power + 10, 11 * power + 10 + outdoorTemperature);

        tMax = Math.max(Math.max(internalTemperature, tMax), outdoorTemperature);
        double heaterTerm = 0;

        if (power > 0){
            double den = Math.max((tMax * (20 - 5 * power) * (distance + 5)), 0.1);
            heaterTerm = 30 * internalTemperature * Math.abs(tMax - internalTemperature) / den;
        }

        double outdoorTerm = (internalTemperature - outdoorTemperature) * internalTemperature / 250.0;

        internalTemperature = Math.min(Math.max(internalTemperature - outdoorTerm + heaterTerm, outdoorTemperature), tMax);

        return internalTemperature;
    }


    private double externalTemperature(double t0, double min, double max)
    {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }


    @Override public void run()
    {

        while (true)
        {

            internalTemperature = temperature(2,
                    externalTemperature(externalTemperature,-10,28));

            System.out.println(id + " Adds new temp to model");
            model.addTemperature(id, internalTemperature);

            try
            {
                Thread.sleep(measureInterval * 1000L);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
