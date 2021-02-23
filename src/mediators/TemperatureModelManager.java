package mediators;
// todo: everything

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
    public void addTemperature(String id, double temperature) {

    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return null;
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return null;
    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {

    }
}
