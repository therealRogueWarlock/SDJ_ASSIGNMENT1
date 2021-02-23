package core;
// todo: everything


import mediators.RadiatorModelManager;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;

    private TemperatureViewModel temperatureViewModel;

    private WarningViewModel warningViewModel;



    public ViewModelFactory(ModelFactory modelFactory ) {
        this.modelFactory = modelFactory;

    }

    public ViewModel getViewModelByName(String viewName){

        if (viewName.equals("temperature")){
            return getTemperatureViewModel();
        }

        if (viewName.equals("warning")){
            return getWarningViewModel();
        }
        return null;
    }



    public WarningViewModel getWarningViewModel(){
        if (warningViewModel == null ){
            warningViewModel = new WarningViewModel(modelFactory.getTemperatureModel());
        }

        return warningViewModel;

    }


    public TemperatureViewModel getTemperatureViewModel() {

        if (temperatureViewModel == null){
            temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
        }

        return temperatureViewModel;
    }


}

