package core;
// todo: everything


import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;

    private TemperatureViewModel temperatureViewModel;

    private WarningViewModel warningViewModel;



    public ViewModelFactory(ModelFactory modelFactory ) {
        this.modelFactory = modelFactory;

    }



    public TemperatureViewModel getTemperatureViewModel() {

        if (temperatureViewModel == null){
            temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
        }

        return temperatureViewModel;
    }


}

