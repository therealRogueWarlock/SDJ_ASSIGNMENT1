package model.radiator;

public class Power3State implements RadiatorState
{
    private static final int POWER = 3;
    private Thread sleepThread;

    public Power3State(Radiator radiator)
    {
        sleepThread = new Thread(()->{
            try
            {
                Thread.sleep(10000);
                radiator.setPowerState(new Power2State());
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        sleepThread.setDaemon(true);
        sleepThread.start();
    }

    @Override public void turnUp(Radiator radiator)
    {
        //Do nothing
    }

    @Override public void turnDown(Radiator radiator)
    {
        sleepThread.interrupt();
        radiator.setPowerState(new Power2State());
    }

    @Override public int getPower()
    {
        return POWER;
    }
}
