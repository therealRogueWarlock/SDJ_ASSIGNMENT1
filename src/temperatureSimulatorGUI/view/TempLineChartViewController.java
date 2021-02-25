package temperatureSimulatorGUI.view;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import temperatureSimulatorGUI.viewmodel.TemperatureViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;

import java.io.IOException;

public class TempLineChartViewController implements ViewController {


    public LineChart tempLineChartId;

    private ViewHandler viewHandler;
    private TemperatureViewModel temperatureViewModel;



    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel) {

        this.viewHandler = viewHandler;
        this.temperatureViewModel = (TemperatureViewModel) viewModel;

        tempLineChartId.getYAxis().setLabel("Temperature");
        tempLineChartId.getXAxis().setLabel("Time");






    }


    public void backButton(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("temperature");
    }


}
