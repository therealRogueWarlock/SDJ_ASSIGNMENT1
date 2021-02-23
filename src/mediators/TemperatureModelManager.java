package mediators;
// todo: Mangler lidt

import model.temperature.Temperature;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{

    private PropertyChangeSupport listenerSupport = new PropertyChangeSupport(this);
    private TemperatureList temperatureList;

    public TemperatureModelManager()
    {
        temperatureList = new TemperatureList();
    }

    @Override
    public void addTemperature(String id, double tempValue)
    {
        Temperature temperature = new Temperature(id, tempValue);

        Temperature old = getLastInsertedTemperature(id);

        this.temperatureList.addTemperature(temperature);
        System.out.println("Old: " + old);
        System.out.println("new: " + temperature);
        if (old != null && old.getValue() != temperature.getValue()) {

            listenerSupport.firePropertyChange("tempChange",old,temperature);
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
        listenerSupport.addPropertyChangeListener(propertyName,listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        listenerSupport.removePropertyChangeListener(propertyName,listener);
    }

}
