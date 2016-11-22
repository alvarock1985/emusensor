package xyz.acmeapps.api.EmuSensor.data;


import java.sql.Timestamp;

/**
 * Created by alvaro on 21-11-16.
 */
public class Time {


    public Timestamp getTime(){


        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        return date;

    }
}
