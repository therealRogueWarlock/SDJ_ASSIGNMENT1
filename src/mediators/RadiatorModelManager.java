package mediators;

import model.radiator.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel {

    private PropertyChangeSupport listenerSupport = new PropertyChangeSupport(this);
    private Radiator radiator;


    public void setRadiator(Radiator radiator) {
        this.radiator = radiator;
    }

    @Override
    public int getCurrentPower() {
        return radiator.getPower();
    }

    @Override
    public void turnRadiatorUp() {
        radiator.turnUp();
        listenerSupport.firePropertyChange("PowerChange", null, getCurrentPower());
    }

    @Override
    public void turnRadiatorDown() {
        radiator.turnDown();
        listenerSupport.firePropertyChange("PowerChange", null, getCurrentPower());
    }


    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        listenerSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        listenerSupport.removePropertyChangeListener(propertyName,listener);
    }


}
