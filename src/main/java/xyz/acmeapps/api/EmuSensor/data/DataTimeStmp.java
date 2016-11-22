package xyz.acmeapps.api.EmuSensor.data;

import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 * Created by alvaro on 21-11-16.
 */
public class DataTimeStmp {

    public Statement statement;
    public DataHistoric2 dh2 = new DataHistoric2();
    public List<SensorData> data = dh2.getAllData();
    public Time time = new Time();
    public Timestamp now = time.getTime();
    public Calendar cal = Calendar.getInstance();
    public Timestamp target = new Timestamp(new Date().getTime());



    public void getDataTs(){

        cal.setTimeInMillis(target.getTime());
        cal.add(Calendar.HOUR, -5);
        target = new Timestamp(cal.getTime().getTime());

        DataBase db = new DataBase();
        try{
            Connection con = db.connectToDb();
            statement = con.createStatement();
            String  query = "select sensor.station_stationid, sensor.sensorid, sensor.name, datasensor.data, datasensor.timestamp from DATASENSOR \n" +
                    "join SENSOR on SENSOR.SENSORID = SENSOR.SENSORID where timestamp >= to_timestamp('"+now+"', 'dd-mm-yyyy hh24:mi:ss') and timestamp <= to_timestamp('"+target+"', 'dd-mm-yyyy hh24:mi:ss') ";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                for(int i=0; i<data.size();i++){
                    if(data.get(i).getId() == rs.getInt("station_stationid")){
                        SensorDataTimestamp sd = new SensorDataTimestamp();
                        sd.setId(rs.getInt("sensorid"));
                        sd.setName(rs.getString("name"));
                        if()


                    }




                }





            }




        }
        catch(Exception e){

        }




    }













}
