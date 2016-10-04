package iprogrammer.com.calendar;

import android.util.Log;

import com.google.api.client.util.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by virendra on 4/10/16.
 */

public class Utility {

    public static DateTime dateFormatGCalendar(String dateString, int hours, int min) {

        Log.d("TAG", "date string=" + dateString + " " + hours + " " + min);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(simpleDateFormat.parse(dateString));

            Calendar newCal = Calendar.getInstance();
            newCal.set(newCal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), hours, min, 00);
            return new DateTime(newCal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
