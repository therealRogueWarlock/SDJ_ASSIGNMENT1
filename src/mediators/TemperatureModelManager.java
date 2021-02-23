package mediators;
// todo: everything

import model.temperature.Temperature;
import model.temperature.TemperatureList;

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
}
