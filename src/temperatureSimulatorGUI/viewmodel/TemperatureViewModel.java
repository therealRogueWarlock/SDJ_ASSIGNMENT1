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

    private DoubleProperty temperature;

    private StringProperty labelTemp1;
    private StringProperty labelTemp2;
    private StringProperty labelTemp3;

    private StringProperty radiatorPower;




    public TemperatureViewModel(TemperatureModel temperatureModel, RadiatorModel radiatorModel) {

        this.temperatureModel = temperatureModel;
        this.radiatorModel = radiatorModel;

        temperature = new SimpleDoubleProperty();

        labelTemp1 = new SimpleStringProperty();
        labelTemp2 = new SimpleStringProperty();
        labelTemp3 = new SimpleStringProperty();

        radiatorPower = new SimpleStringProperty();



        temperatureModel.addListener("tempChange", this);
        radiatorModel.addListener("PowerChange", this);

    }

    public void getLastTemp(){
        Platform.runLater(() ->{

            Temperature lastInsertedTemperature = temperatureModel.getLastInsertedTemperature();

            switch (lastInsertedTemperature.getId()) {
                case "T1" -> labelTemp1.setValue(temperature.toString());
                case "T2" -> labelTemp2.setValue(temperature.toString());
                case "T3" -> labelTemp3.setValue(temperature.toString());
            }

        });

    }

    public void turnUpRadiator()
    {
        radiatorModel.turnRadiatorUp();
    }

    public void turnDownRadiator()
    {
        radiatorModel.turnRadiatorDown();
    }

    // property Getters

    public DoubleProperty temperatureProperty() {
        return temperature;
    }


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
        System.out.println("viewmodel got property change from model");
        getLastTemp();
    }
}
