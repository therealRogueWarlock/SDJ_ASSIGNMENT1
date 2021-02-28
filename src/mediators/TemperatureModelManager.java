package mediators;
// todo: Mangler lidt

import model.temperature.Temperature;
import model.temperature.TemperatureAlarm;
import model.temperature.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{

    private PropertyChangeSupport listenerSupport = new PropertyChangeSupport(this);
    private TemperatureList temperatureList;
    private TemperatureAlarm temperatureAlarm;


    public TemperatureModelManager()
    {
        temperatureList = new TemperatureList();
        temperatureAlarm = new TemperatureAlarm();
    }

    @Override
    public void addTemperature(String id, double tempValue)
    {
        Temperature temperature = new Temperature(id, tempValue);

        Temperature old = getLastInsertedTemperature(id);

        this.temperatureList.addTemperature(temperature);

        listenerSupport.firePropertyChange("tempChange",old,temperature);
    }


    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    public void setAlarmMaxValue(double value){
        temperatureAlarm.setMaxValue(value);
    }

    public void setAlarmMinValue(double value){
        temperatureAlarm.setMinValue(value);
    }

    public double getAlarmMaxValue(){
        return temperatureAlarm.getMaxValue();
    }

    public double getAlarmMinValue(){
        return temperatureAlarm.getMinValue();
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
