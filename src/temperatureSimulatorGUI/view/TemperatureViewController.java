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
    private TemperatureViewModel viewModel;

    public void init(ViewHandler viewHandler, TemperatureViewModel viewModel)
    {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
/*
        outputLabelTemp1.textProperty().bind(viewModel.);
        outputLabelTemp2.textProperty().bind(viewModel.);
        outputLabelTemp3.textProperty().bind(viewModel.);

 */
    }

    public void turnUpButtonPressed(ActionEvent actionEvent)
    {
    }

    public void turnDownButtonPressed(ActionEvent actionEvent)
    {
    }

    public void warningButtonPressed(ActionEvent actionEvent)
    {
    }
}
