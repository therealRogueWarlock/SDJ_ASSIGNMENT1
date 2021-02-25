package core;
// todo: everything


import mediators.RadiatorModelManager;
import temperatureSimulatorGUI.viewmodel.TempLineChartViewModel;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

public class ViewModelFactory {

    private ModelFactory modelFactory;


    private TempLineChartViewModel tempLineChartViewModel;

    private TemperatureViewModel temperatureViewModel;

    private WarningViewModel warningViewModel;



    public ViewModelFactory(ModelFactory modelFactory ) {
        this.modelFactory = modelFactory;

    }

    public ViewModel getViewModelByName(String viewName){

        if (viewName.equals("temperature")){
            return getTemperatureViewModel();
        }

        if (viewName.equals("tempLineChart")){
            return getTempLineChartViewModel();
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
            temperatureViewModel =
                    new TemperatureViewModel(
                            modelFactory.getTemperatureModel(), modelFactory.getRadiatorModel());
        }

        return temperatureViewModel;
    }

    public TempLineChartViewModel getTempLineChartViewModel(){

        if (tempLineChartViewModel == null){
            tempLineChartViewModel = new TempLineChartViewModel(modelFactory.getTemperatureModel());
        }
        return tempLineChartViewModel;
    }




}

