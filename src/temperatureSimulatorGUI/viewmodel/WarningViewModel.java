package temperatureSimulatorGUI.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import mediators.TemperatureModel;
import mediators.TemperatureModelManager;

import java.beans.PropertyChangeEvent;

// todo: everything
public class WarningViewModel implements ViewModel
{
    DoubleProperty maxWarning;
    DoubleProperty minWarning;

    TemperatureModelManager temperatureModelManager;

    public WarningViewModel(TemperatureModel temperatureModel)
    {
        this.temperatureModelManager = (TemperatureModelManager) temperatureModel;

        maxWarning =  new SimpleDoubleProperty();
        minWarning =  new SimpleDoubleProperty();

        maxWarning.setValue(this.temperatureModelManager.getAlarmMaxValue());
        minWarning.setValue(this.temperatureModelManager.getAlarmMinValue());


    }

    public void updateAlarmValues(){
        temperatureModelManager.setAlarmMaxValue(maxWarning.getValue());
        temperatureModelManager.setAlarmMinValue(minWarning.getValue());
    }


    public DoubleProperty maxWarningProperty()
    {
        return maxWarning;
    }

    public DoubleProperty minWarningProperty()
    {
        return minWarning;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
