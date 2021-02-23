package mediators;
// todo: Mangler lidt

import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;

public class TemperatureModelManager implements TemperatureModel
{
    private TemperatureList temperatureList;

    public TemperatureModelManager()
    {
        temperatureList = new TemperatureList();
    }

    @Override
    public void addTemperature(String id, double temperature)
    {
        Temperature temp = new Temperature(id, temperature);
        Temperature old = getLastInsertedTemperature();
        this.temperatureList.addTemperature(temp);
        if (old != null && old.getValue() != temp.getValue())
        {
            System.out.println("-->" + temp + " (from: " + old + ")");
        }
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {

    }
}
