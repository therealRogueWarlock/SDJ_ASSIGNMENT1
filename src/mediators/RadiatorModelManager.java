package mediators;

import java.beans.PropertyChangeListener;

// todo: everything
public class RadiatorModelManager implements RadiatorModel
{
    @Override
    public int getCurrentState() {
        return 0;
    }

    @Override
    public void turnRadiatorUp() {

    }

    @Override
    public void turnRadiatorDown() {

    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {

    }
}
