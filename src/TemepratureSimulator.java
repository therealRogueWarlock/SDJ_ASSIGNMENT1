import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import mediators.TemperatureModel;
import model.runnables.Thermometer;

public class TemepratureSimulator extends Application {

    public void start(Stage stage) throws Exception {
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);

        // creating Thermometer threads
        TemperatureModel temperatureModel = modelFactory.getTemperatureModel();
        Thermometer thermometer1 = new Thermometer(temperatureModel, 20,2,"T1");
        Thermometer thermometer2 = new Thermometer(temperatureModel,20,2,"T2");
        Thermometer thermometer3 = new Thermometer(temperatureModel, 20,2,"T3");


        Thread thermo1Thread = new Thread(thermometer1);
        Thread thermo2Thread = new Thread(thermometer2);
        Thread thermo3Thread = new Thread(thermometer3);

        thermo1Thread.start();
        thermo2Thread.start();
        thermo3Thread.start();

        viewHandler.start();
    }
}
