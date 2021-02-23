package temperatureSimulatorGUI.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import mediators.TemperatureModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// todo: everything
public class WarningViewModel implements ViewModel, PropertyChangeListener
{
    DoubleProperty highWarning;
    DoubleProperty lowWarning;

    TemperatureModel temperatureModel;

    public WarningViewModel(TemperatureModel temperatureModel)
    {
        this.temperatureModel = temperatureModel;

        highWarning =  new SimpleDoubleProperty();
        lowWarning =  new SimpleDoubleProperty();
    }

    public void spoilerAlert()
    {
        //temperatureModel.getLastInsertedTemperature().GETINT ;((
        /*
        if(highWarning.getValue() != null && lowWarning.getValue() != null)
        {
            //TODO
        }

         */

    }

    public DoubleProperty highWarningProperty()
    {
        return highWarning;
    }

    public DoubleProperty lowWarningProperty()
    {
        return lowWarning;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
