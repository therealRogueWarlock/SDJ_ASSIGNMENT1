package mediators;

import util.Subject;

// todo: everything
public interface RadiatorModel extends Subject
{
    int getCurrentState();
    void turnRadiatorUp();
    void turnRadiatorDown();
}
