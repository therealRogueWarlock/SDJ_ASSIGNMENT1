package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import mediators.RadiatorModel;
import mediators.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

// todo: everything
public class TemperatureViewModel implements ViewModel{

    private TemperatureModel temperatureModel;
    private RadiatorModel radiatorModel;

    private StringProperty labelTemp1;
    private StringProperty labelTemp2;
    private StringProperty labelTemp3;

    private StringProperty radiatorPower;




    public TemperatureViewModel(TemperatureModel temperatureModel, RadiatorModel radiatorModel) {

        this.temperatureModel = temperatureModel;
        this.radiatorModel = radiatorModel;

        labelTemp1 = new SimpleStringProperty("T1: No value");
        labelTemp2 = new SimpleStringProperty("T2: No value");
        labelTemp3 = new SimpleStringProperty("T3: No value");


        radiatorPower = new SimpleStringProperty();

        radiatorPower.setValue(String.valueOf(radiatorModel.getCurrentPower()));


        temperatureModel.addListener("tempChange", this);
        radiatorModel.addListener("PowerChange", this);

    }

    public void getLastTemp(){

        Platform.runLater(() ->{

            Temperature lastInsertedTemperature = temperatureModel.getLastInsertedTemperature();

            switch (lastInsertedTemperature.getId()) {
                case "T1" -> labelTemp1.setValue(lastInsertedTemperature.toString() + " distance 1, inside");
                case "T2" -> labelTemp2.setValue(lastInsertedTemperature.toString() + " distance 7, inside");
                case "T3" -> labelTemp3.setValue(lastInsertedTemperature.toString() + " outside");
            }
            checkRadiatorPower();
        });
    }

    private void checkRadiatorPower(){
        radiatorPower.setValue(String.valueOf(radiatorModel.getCurrentPower()));
    }


    public void turnUpRadiator()
    {
        radiatorModel.turnRadiatorUp();
        checkRadiatorPower();
    }

    public void turnDownRadiator()
    {
        radiatorModel.turnRadiatorDown();
        checkRadiatorPower();
    }

    // property Getters

    public StringProperty labelTemp1Property() {
        return labelTemp1;
    }

    public StringProperty labelTemp2Property() {
        return labelTemp2;
    }


    public StringProperty labelTemp3Property() {
        return labelTemp3;
    }

    public StringProperty radiatorPowerProperty() {
        return radiatorPower;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        getLastTemp();
    }
}
