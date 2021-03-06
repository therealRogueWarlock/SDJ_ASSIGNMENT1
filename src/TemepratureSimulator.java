import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import mediators.TemperatureModel;
import model.radiator.Radiator;
import model.runnables.Thermometer;

public class TemepratureSimulator extends Application {

    public void start(Stage stage) throws Exception {
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);

        // creating Thermometer threads
        TemperatureModel temperatureModel = modelFactory.getTemperatureModel();

        // creating new radiator
        Radiator radiator = new Radiator();
        // giving radiator to radiator model.
        modelFactory.getRadiatorModel().setRadiator(radiator);

        int startRoomTemp = 20;
        int startOutsideTemp = 10;

        Thermometer thermometer1 = new Thermometer(temperatureModel, radiator, startRoomTemp,startOutsideTemp,1,"T1");
        Thermometer thermometer2 = new Thermometer(temperatureModel,radiator,startRoomTemp,startOutsideTemp,7,"T2");
        Thermometer thermometer3 = new Thermometer(temperatureModel,radiator, startOutsideTemp,startOutsideTemp,"T3");


        Thread thermo1Thread = new Thread(thermometer1);
        Thread thermo2Thread = new Thread(thermometer2);
        Thread thermo3Thread = new Thread(thermometer3);

        thermo1Thread.start();
        thermo2Thread.start();
        thermo3Thread.start();

        viewHandler.start();
    }
}
