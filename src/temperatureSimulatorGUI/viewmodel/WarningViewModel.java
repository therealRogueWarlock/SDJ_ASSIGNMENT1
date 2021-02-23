package temperatureSimulatorGUI.viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import mediators.TemperatureModel;

// todo: everything
public class WarningViewModel
{
    DoubleProperty highWarning;
    DoubleProperty lowWarning;

    TemperatureModel temperatureModel;

    public WarningViewModel(TemperatureModel temperatureModel)
    {
        this.temperatureModel = temperatureModel;

        highWarning =  new SimpleDoubleProperty(40);
        lowWarning =  new SimpleDoubleProperty(5);
    }

    public void spoilerAlert()
    {
        //if(highWarning.getValue() != null )
        //TODO: mangler
    }

    public DoubleProperty highWarningProperty()
    {
        return highWarning;
    }

    public DoubleProperty lowWarningProperty()
    {
        return lowWarning;
    }
}
