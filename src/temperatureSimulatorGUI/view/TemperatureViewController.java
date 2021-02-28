package temperatureSimulatorGUI.view;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;

import java.io.IOException;

public class TemperatureViewController implements ViewController
{
    public Label radiatorValue;
    public Label warningLabel;

    public Label outputLabelTemp1;
    public Label outputLabelTemp2;
    public Label outputLabelTemp3;

    private ViewHandler viewHandler;
    private TemperatureViewModel temperatureViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel)
    {
        this.viewHandler = viewHandler;
        this.temperatureViewModel = (TemperatureViewModel) viewModel;

        outputLabelTemp1.textProperty().bind(temperatureViewModel.labelTemp1Property());
        outputLabelTemp2.textProperty().bind(temperatureViewModel.labelTemp2Property());
        outputLabelTemp3.textProperty().bind(temperatureViewModel.labelTemp3Property());

        radiatorValue.textProperty().bind(temperatureViewModel.radiatorPowerProperty());
        warningLabel.textProperty().bind(temperatureViewModel.warningInfoProperty());
    }

    public void turnUpButtonPressed(ActionEvent actionEvent)
    {
        temperatureViewModel.turnUpRadiator();
    }

    public void turnDownButtonPressed(ActionEvent actionEvent)
    {
        temperatureViewModel.turnDownRadiator();
    }

    public void warningButtonPressed(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("warning");
    }

    public void lineChartViewButtonPressed(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("tempLineChart");

    }

}
