package temperatureSimulatorGUI.view;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import temperatureSimulatorGUI.viewmodel.TempLineChartViewModel;
import temperatureSimulatorGUI.viewmodel.ViewModel;

import java.io.IOException;

public class TempLineChartViewController implements ViewController {

    @FXML
    private LineChart tempLineChartId;

    private ViewHandler viewHandler;
    private TempLineChartViewModel tempLineChartViewModel;



    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel) {

        this.viewHandler = viewHandler;
        this.tempLineChartViewModel = (TempLineChartViewModel) viewModel;

        tempLineChartId.getYAxis().setLabel("Temperature");
        tempLineChartId.getXAxis().setLabel("Time");

        tempLineChartId.getData().add(tempLineChartViewModel.getIndoor1DataSeries());
        tempLineChartId.getData().add(tempLineChartViewModel.getIndoor2DataSeries());
        tempLineChartId.getData().add(tempLineChartViewModel.getOutdoor1DataSeries());

    }


    public void backButton(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("temperature");
    }


}
