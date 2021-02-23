package core;

// todo: everything

import mediators.RadiatorModel;
import mediators.RadiatorModelManager;
import mediators.TemperatureModel;
import mediators.TemperatureModelManager;

public class ModelFactory {

    TemperatureModel temperatureModel;
    RadiatorModel radiatorModel;


    public TemperatureModel getTemperatureModel() {

        if (temperatureModel == null){
            temperatureModel = new TemperatureModelManager();
        }

        return temperatureModel;
    }

    public RadiatorModel getRadiatorModel(){

        if (radiatorModel == null){

            radiatorModel = new RadiatorModelManager();

        }

        return radiatorModel;
    }


}