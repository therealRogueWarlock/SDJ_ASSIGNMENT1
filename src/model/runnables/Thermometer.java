package model.runnables;
// todo: everything
import mediators.TemperatureModel;
import model.radiator.Radiator;

public class Thermometer implements Runnable
{

    private double internalTemperature;
    private double externalTemperature;

    private Integer distance;
    private String id;

    private TemperatureModel model;
    private Radiator radiator;

    private final int measureInterval = 4;

    public Thermometer(TemperatureModel model,Radiator radiator,
                       double internalTemperature, double externalTemperature, int distance, String id)
    {
        this.internalTemperature = internalTemperature;
        this.externalTemperature = externalTemperature;

        this.distance = distance;
        this.id = id;

        this.model = model;
        this.radiator = radiator;


    }

    public Thermometer(TemperatureModel model, Radiator radiator,
                       double internalTemperature, double externalTemperature, String id)
    {
        this.internalTemperature = internalTemperature;
        this.externalTemperature = externalTemperature;
        this.id = id;

        this.model = model;
        this.radiator = radiator;

    }


    private double temperature(int power, double outdoorTemperature){

        if (distance == null){
            return outdoorTemperature;
        }

        double tMax = Math.min(11 * power + 10, 11 * power + 10 + outdoorTemperature);

        tMax = Math.max(Math.max(internalTemperature, tMax), outdoorTemperature);
        double heaterTerm = 0;

        if (power > 0){
            double den = Math.max((tMax * (20 - 5 * power) * (distance + 5)), 0.1);
            heaterTerm = 30 * internalTemperature * Math.abs(tMax - internalTemperature) / den;
        }

        double outdoorTerm = (internalTemperature - outdoorTemperature) * measureInterval / 250.0;

        internalTemperature = Math.min(Math.max(internalTemperature - outdoorTerm + heaterTerm, outdoorTemperature), tMax);

        return internalTemperature;
    }


    private double externalTemperature(double min, double max) {
        double left = externalTemperature - min;
        double right = max - externalTemperature;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        externalTemperature += sign * Math.random();
        return externalTemperature;
    }


    @Override public void run()
    {

        while (true)
        {

            internalTemperature = temperature(radiator.getPower(),
                    externalTemperature(-10,28));

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
