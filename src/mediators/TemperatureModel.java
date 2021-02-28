package mediators;

import model.temperature.Temperature;
import model.temperature.TemperatureAlarm;
import util.Subject;

public interface TemperatureModel extends Subject {

    void addTemperature(String id, double temperature);

    Temperature getLastInsertedTemperature();

    Temperature getLastInsertedTemperature(String id);


}