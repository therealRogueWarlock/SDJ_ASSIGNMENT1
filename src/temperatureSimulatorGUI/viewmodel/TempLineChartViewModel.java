package temperatureSimulatorGUI.viewmodel;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;
import mediators.TemperatureModel;
import mediators.TemperatureModelManager;
import model.temperature.DateTime;
import model.temperature.Temperature;

import java.beans.PropertyChangeEvent;

public class TempLineChartViewModel implements ViewModel{


    private TemperatureModelManager temperatureModelManager;

    private XYChart.Series indoor1 = new XYChart.Series();
    private XYChart.Series indoor2 = new XYChart.Series();
    private XYChart.Series outdoor1 = new XYChart.Series();



    public TempLineChartViewModel(TemperatureModel model) {

        this.temperatureModelManager = (TemperatureModelManager) model;

        indoor1.setName("T1");
        indoor2.setName("T2");
        outdoor1.setName("T3");



        temperatureModelManager.addListener("tempAdded", this);


    }


    public XYChart.Series getIndoor1DataSeries() {
        return indoor1;
    }

    public XYChart.Series getIndoor2DataSeries() {
        return indoor2;
    }

    public XYChart.Series getOutdoor1DataSeries() {
        return outdoor1;
    }

    private void sortData(){
        Platform.runLater(() ->{

            Temperature lastInsertedTemperature = temperatureModelManager.getLastInsertedTemperature();
            System.out.println("Soirting data" + lastInsertedTemperature);
            DateTime timeStamp = lastInsertedTemperature.getTime();
            double temperatureValue = lastInsertedTemperature.getValue();

            switch (lastInsertedTemperature.getId()) {
                case "T1" -> indoor1.getData().add(new XYChart.Data(timeStamp.getSortableTime(), temperatureValue));
                case "T2" -> indoor2.getData().add(new XYChart.Data(timeStamp.getSortableTime(), temperatureValue));
                case "T3" -> outdoor1.getData().add(new XYChart.Data(timeStamp.getSortableTime(), temperatureValue));
            }

        });
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        sortData();
    }
}
