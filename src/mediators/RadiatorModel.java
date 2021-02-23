package mediators;

import util.Subject;

public interface RadiatorModel extends Subject
{
    int getCurrentState();
    void turnRadiatorUp();
    void turnRadiatorDown();
}
