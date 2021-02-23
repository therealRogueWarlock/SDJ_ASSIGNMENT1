package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediators.TemperatureModel;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// todo: everything
public class TemperatureViewModel implements ViewModel, PropertyChangeListener {

    TemperatureModel model;

    private DoubleProperty temperature;

    private StringProperty output;
    private StringProperty id;
    private StringProperty filterLabel;

    private String filteredId;


    public TemperatureViewModel(TemperatureModel model) {
        this.model = model;

        output = new SimpleStringProperty();
        temperature = new SimpleDoubleProperty();
        id = new SimpleStringProperty();

        filterLabel = new SimpleStringProperty();
        filterLabel.setValue("All");

        model.addListener("tempChange", this);

    }

    public void getLastTemp(){
        Platform.runLater(() ->{

            // last measured temp from selected id.
            System.out.println(filteredId);
            Temperature lastMeasuredTemperature = model.getLastInsertedTemperature(filteredId);

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
