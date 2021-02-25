package mediators;

import model.radiator.Radiator;
import util.Subject;

public interface RadiatorModel extends Subject
{
    int getCurrentPower();
    void setRadiator(Radiator radiator);
    void turnRadiatorUp();
    void turnRadiatorDown();
}
