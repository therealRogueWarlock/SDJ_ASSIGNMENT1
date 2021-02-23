package mediators;

import util.Subject;

public interface RadiatorModel extends Subject
{
    int getCurrentPower();
    void turnRadiatorUp();
    void turnRadiatorDown();
}
