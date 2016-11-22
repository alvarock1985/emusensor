package xyz.acmeapps.api.EmuSensor.data;

import xyz.acmeapps.api.EmuSensor.model.SensorData;
import xyz.acmeapps.api.EmuSensor.model.SensorDataTimestamp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    public List<SensorDataTimestamp> data2 = new ArrayList<>();



    public List<SensorDataTimestamp> getDataTs(){

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
                        int avg = 0;
                        if(rs.getString("name")=="temp" && rs.getInt("sensorid")==sd.getId()){
                            ArrayList<Integer> list = new ArrayList<>();
                            while(rs.next()){
                                list.add(rs.getInt("data"));
                            }
                            for(int y =0; i<list.size();i++){
                                avg += list.get(i);
                            }
                            sd.setTempData(avg);
                        }else if(rs.getString("name")=="caudal" && rs.getInt("sensorid")==sd.getId()){
                            ArrayList<Integer> list = new ArrayList<>();
                            while(rs.next()){
                                list.add(rs.getInt("data"));
                            }
                            for(int y =0; i<list.size();i++){
                                avg += list.get(i);
                            }
                            sd.setCaudalData(avg);
                        }else{
                            ArrayList<Integer> list = new ArrayList<>();
                            while(rs.next()){
                                list.add(rs.getInt("data"));
                            }
                            for(int y =0; i<list.size();i++){
                                avg += list.get(i);
                            }
                            sd.setHumData(avg);
                        }
                        data2.add(sd);
                    }
                }
            }return data2;
        }
        catch(Exception e){
            return null;
        }
    }













}
