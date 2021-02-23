package mediators;

import util.Subject;

// todo: everything
public interface RadiatorModel extends Subject
{
    int getCurrentPower();
    void turnRadiatorUp();
    void turnRadiatorDown();
}
