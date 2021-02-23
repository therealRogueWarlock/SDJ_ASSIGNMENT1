package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediators.RadiatorModel;
import mediators.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

// todo: everything
public class TemperatureViewModel implements ViewModel{

    private TemperatureModel temperatureModel;
    private RadiatorModel radiatorModel;

    private DoubleProperty temperature;

    private StringProperty output;
    private StringProperty id;
    private StringProperty filterLabel;

    private String filteredId;


    public TemperatureViewModel(TemperatureModel temperatureModel, RadiatorModel radiatorModel) {

        this.temperatureModel = temperatureModel;
        this.radiatorModel = radiatorModel;

        output = new SimpleStringProperty();
        temperature = new SimpleDoubleProperty();
        id = new SimpleStringProperty();

        filterLabel = new SimpleStringProperty();
        filterLabel.setValue("All");

        temperatureModel.addListener("tempChange", this);
        radiatorModel.addListener("PowerChange", this);

    }

    public void getLastTemp(){
        Platform.runLater(() ->{

            // last measured temp from selected id.
            System.out.println(filteredId);
            Temperature lastMeasuredTemperature = temperatureModel.getLastInsertedTemperature(filteredId);

            if (lastMeasuredTemperature != null) {
                output.setValue(lastMeasuredTemperature.toString());

                temperature.setValue(lastMeasuredTemperature.getValue());
            }else{
                output.setValue("Unknowen thermometer id");
            }
        });


    }

    public void filterId(){
        filteredId = id.getValue();
        filterLabel.setValue(filteredId);
    }

    public DoubleProperty temperatureProperty() {
        return temperature;
    }


    public StringProperty filterLabelProperty() {
        return filterLabel;
    }

    public StringProperty idProperty() {
        return id;
    }


    public StringProperty outputProperty() {
        return output;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("viewmodel got property change from model");
        getLastTemp();
    }
}
