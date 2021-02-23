package core;

// todo: everything

import mediators.TemperatureModel;
import mediators.TemperatureModelManager;

public class ModelFactory {

    TemperatureModel temperatureModel;

    public TemperatureModel getTemperatureModel() {

        if (temperatureModel == null){
            temperatureModel = new TemperatureModelManager();
        }

        return temperatureModel;
    }

}