package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import mediators.TemperatureModel;
import mediators.TemperatureModelManager;
import model.temperature.DateTime;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TempLineChartViewModel implements ViewModel{


    private TemperatureModelManager temperatureModel;

    private XYChart.Series indoor1 = new XYChart.Series();
    private XYChart.Series indoor2 = new XYChart.Series();
    private XYChart.Series outdoor1 = new XYChart.Series();



    public TempLineChartViewModel(TemperatureModel model) {

        this.temperatureModel = (TemperatureModelManager) model;


    }

    //todo:stuff here

    public XYChart.Series getIndoor1DataSeries(){
        return null;
    }


    private void sortData(){
        Platform.runLater(() ->{

            Temperature lastInsertedTemperature = temperatureModel.getLastInsertedTemperature();

            DateTime timeStamp = lastInsertedTemperature.getTime();
            double temperatureValue = lastInsertedTemperature.getValue();

            switch (lastInsertedTemperature.getId()) {
                case "T1" -> indoor1.getData().add(new XYChart.Data(timeStamp, temperatureValue));
                case "T2" -> indoor2.getData().add(new XYChart.Data(timeStamp, temperatureValue));
                case "T3" -> outdoor1.getData().add(new XYChart.Data(timeStamp, temperatureValue));
            }

        });
    }





    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        sortData();

    }
}
