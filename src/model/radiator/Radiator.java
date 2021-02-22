package model.radiator;

public class Radiator
{
    private RadiatorState currentState = new OffState();

    public void turnUp()
    {
        currentState.turnUp(this);
    }

    public void turnDown()
    {
        currentState.turnDown(this);
    }

    public void getPower()
    {
        currentState.getPower();
    }

    void setPowerState(RadiatorState state)
    {
        this.currentState = state;
    }

}
