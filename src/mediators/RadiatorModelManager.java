package mediators;

import model.radiator.Radiator;

import java.beans.PropertyChangeListener;

// todo: everything
public class RadiatorModelManager implements RadiatorModel
{
    private Radiator radiator;

    public RadiatorModelManager(Radiator radiator)
    {
        this.radiator = radiator;
    }

    @Override
    public int getCurrentState() {
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

    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {

    }
}
