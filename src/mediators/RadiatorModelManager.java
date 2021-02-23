package mediators;

import model.radiator.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements RadiatorModel
{

    private PropertyChangeSupport listenerSupport = new PropertyChangeSupport(this);
    private Radiator radiator;

    public RadiatorModelManager() {
        this.radiator = new Radiator();
    }

    @Override
    public int getCurrentPower() {
        return radiator.getPower();
    }

    @Override
    public void turnRadiatorUp() {
        radiator.turnUp();
    }

    @Override
    public void turnRadiatorDown() {
        radiator.turnDown();
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
