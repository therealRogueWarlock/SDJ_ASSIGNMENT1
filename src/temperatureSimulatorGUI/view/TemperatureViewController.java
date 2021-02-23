package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;

import javax.swing.text.View;

public class TemperatureViewController
{
    public Label radiatorValue;
    public Label warningLabel;

    public Label outputLabelTemp1;
    public Label outputLabelTemp2;
    public Label outputLabelTemp3;


    private ViewHandler viewHandler;
    private TemperatureViewModel temperatureViewModel;

    public void init(ViewHandler viewHandler, ViewModel viewModel)
    {
        this.viewHandler = viewHandler;
        this.temperatureViewModel = (TemperatureViewModel) viewModel;

        outputLabelTemp1.textProperty().bind(temperatureViewModel.labelTemp1Property());
        outputLabelTemp2.textProperty().bind(temperatureViewModel.labelTemp2Property());
        outputLabelTemp3.textProperty().bind(temperatureViewModel.labelTemp3Property());

        radiatorValue.textProperty().bind(temperatureViewModel.radiatorPowerProperty());
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
        //Switch view to WarningView.fxml
    }

}
