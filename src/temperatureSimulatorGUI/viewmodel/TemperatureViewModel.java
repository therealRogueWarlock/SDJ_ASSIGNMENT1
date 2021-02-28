package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import mediators.RadiatorModel;
import mediators.TemperatureModel;
import mediators.TemperatureModelManager;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

// todo: everything
public class TemperatureViewModel implements ViewModel{

    private TemperatureModelManager temperatureModelManager;
    private RadiatorModel radiatorModel;

    private StringProperty labelTemp1;
    private StringProperty labelTemp2;
    private StringProperty labelTemp3;

    private StringProperty radiatorPower;
    private StringProperty warningInfo;




    public TemperatureViewModel(TemperatureModel temperatureModel, RadiatorModel radiatorModel) {

        this.temperatureModelManager = (TemperatureModelManager) temperatureModel;
        this.radiatorModel = radiatorModel;

        labelTemp1 = new SimpleStringProperty("T1: No value");
        labelTemp2 = new SimpleStringProperty("T2: No value");
        labelTemp3 = new SimpleStringProperty("T3: No value");


        radiatorPower = new SimpleStringProperty();
        warningInfo = new SimpleStringProperty();

        radiatorPower.setValue(String.valueOf(radiatorModel.getCurrentPower()));



        temperatureModel.addListener("tempChange", this);
        radiatorModel.addListener("PowerChange", this);

    }

    public void getLastTemp(){

        Platform.runLater(() ->{

            Temperature lastInsertedTemperature = temperatureModelManager.getLastInsertedTemperature();

            switch (lastInsertedTemperature.getId()) {
                case "T1" -> labelTemp1.setValue(lastInsertedTemperature.toString() + " distance 1, inside");
                case "T2" -> labelTemp2.setValue(lastInsertedTemperature.toString() + " distance 7, inside");
                case "T3" -> labelTemp3.setValue(lastInsertedTemperature.toString() + " outside");
            }
            checkRadiatorPower();
            checkAlarm(lastInsertedTemperature);
        });
    }

    private void checkRadiatorPower(){
        radiatorPower.setValue(String.valueOf(radiatorModel.getCurrentPower()));
    }

    private void checkAlarm(Temperature lastInsertedTemperature){
        double tempValue = lastInsertedTemperature.getValue();
        String tempId = lastInsertedTemperature.getId();

        double maxValue = temperatureModelManager.getAlarmMaxValue();
        double minValue = temperatureModelManager.getAlarmMinValue();

        if(tempId.equals("T3")){
          // do nothing
        }else if (tempValue >= maxValue ){
            warningInfo.setValue(tempId + " detects a temperature above alarm max value" +
                    ", turn down the radiator!");
        }else if(tempValue <= minValue){
            warningInfo.setValue(tempId + " detects a temperature " +
                    "below alarm min value" +
                    ", turn up the radiator!");
        }else{
            warningInfo.setValue("Temperature is perfect!");
        }

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

    public StringProperty warningInfoProperty(){
        return warningInfo;
    }



    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        getLastTemp();
    }
}
