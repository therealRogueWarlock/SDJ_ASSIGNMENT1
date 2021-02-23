package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;

public class TemperatureViewController
{
    public Label outputLabelTemp1;
    public Label outputLabelTemp2;
    public Label outputLabelTemp3;
    public Label radiatorValue;
    public Label warningLabel;

    private ViewHandler viewHandler;
    private TemperatureViewModel temperatureViewModel;

    public void init(ViewHandler viewHandler, TemperatureViewModel temperatureViewModel)
    {
        this.viewHandler = viewHandler;
        this.temperatureViewModel = temperatureViewModel;
/*
        outputLabelTemp1.textProperty().bind(temperatureViewModel.);
        outputLabelTemp2.textProperty().bind(temperatureViewModel.);
        outputLabelTemp3.textProperty().bind(temperatureViewModel.);

 */
    }

    public void turnUpButtonPressed(ActionEvent actionEvent)
    {
     //   temperatureViewModel.
    }

    public void turnDownButtonPressed(ActionEvent actionEvent)
    {
      //  temperatureViewModel.
    }

    public void warningButtonPressed(ActionEvent actionEvent)
    {

    }

}
