package model.temperature;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime
{
    private Date date;

    public DateTime()
    {
        date = Calendar.getInstance().getTime();
    }

    public String getTimestamp()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }

    public String getSortableTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(
            "HH:mm:ss");
        return sdf.format(date);
    }
    public String getSortableDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "HH:mm:ss");
        return sdf.format(date);
    }
}
